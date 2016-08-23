package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.*;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Order;
import com.jiabangou.eleme.sdk.model.PushAction;
import com.jiabangou.eleme.sdk.model.ResultMessage;
import com.jiabangou.eleme.sdk.utils.ElemeUtils;
import okhttp3.OkHttpClient;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 客户端实现
 * Created by freeway on 16/7/13.
 */
public final class ElemeClientImpl implements ElemeClient {

    private ElemeConfigStorage configStorage;
    private LogListener logListener;
    private OkHttpClient client;
    private FoodService foodService;
    private RestaurantService restaurantService;
    private FoodCategoryService foodCategoryService;
    private ImageService imageService;
    private OrderService orderService;
    private CommentService commentService;
    private PushConsumer pushConsumer;

    public ElemeClientImpl(ElemeConfigStorage configStorage) {
        this.configStorage = configStorage;
    }


    @Override
    public void setElemeConfigStorage(ElemeConfigStorage configStorage) {
        this.configStorage = configStorage;
    }

    @Override
    public void setLogListener(LogListener logListener) {
        this.logListener = logListener;
    }

    public void setPushConsumer(PushConsumer pushConsumer) {
        this.pushConsumer = pushConsumer;
    }

    @Override
    public ResultMessage pushHandle(String url, Map<String, String> params) {
        if (this.pushConsumer == null) {
            return new ResultMessage("pushConsumer does not implement");
        }
        try {
            ElemeUtils.sigCheck(url, params, configStorage.getConsumerKey(), configStorage.getConsumerSecret());
        } catch (Exception e) {
            return new ResultMessage(e.getMessage());
        }
        String pushAction = params.get("push_action");
        if (PushAction.NEW_ORDER.equals(pushAction)) {
            String eleme_order_ids = params.get("eleme_order_ids");
            List<Long> orderIds = Arrays.asList(eleme_order_ids.split(",")).stream().map(Long::valueOf).collect(toList());
            try {
                List<Order> orders = new ArrayList<>(orderIds.size());
                for (Long orderId : orderIds) {
                    orders.add(this.getOrderService().get(orderId));
                }
                this.pushConsumer.newOrder(orders);
            } catch (ElemeErrorException e) {
                logging(e.getRequestUrl(), false, e.getRequestParams().toString(), e.getResponseString());
                return new ResultMessage(e.getMessage());
            }
        } else if (PushAction.ORDER_STATUS_UPDATE.equals(pushAction)) {
            Long elemeOrderId = Long.valueOf(params.get("eleme_order_id"));
            String tpOrderId = params.get("tp_order_id");
            Short newStatus = Short.valueOf(params.get("new_status"));
            String extra = params.get("extra");
            try {
                Order order = this.getOrderService().get(elemeOrderId);
                this.pushConsumer.orderStatusUpdate(order, tpOrderId, newStatus, extra);
            } catch (ElemeErrorException e) {
                logging(e.getRequestUrl(), false, e.getRequestParams().toString(), e.getResponseString());
                return new ResultMessage(e.getMessage());
            }
        } else if (PushAction.REFUND_ORDER.equals(pushAction)) {
            Long elemeOrderId = Long.valueOf(params.get("eleme_order_id"));
            Short refundStatus = Short.valueOf(params.get("refund_status"));

            try {
                Order order = this.getOrderService().get(elemeOrderId);
                this.pushConsumer.refundOrder(order, refundStatus);
            } catch (ElemeErrorException e) {
                logging(e.getRequestUrl(), false, e.getRequestParams().toString(), e.getResponseString());
                return new ResultMessage(e.getMessage());
            }
        } else if (PushAction.DELIVERY.equals(pushAction)) {
            Long elemeOrderId = Long.valueOf(params.get("eleme_order_id"));
            Short statusCode = Short.valueOf(params.get("status_code"));
            Short subStatusCode = StringUtils.isNotBlank(params.get("sub_status_code")) ? Short.valueOf(params.get("sub_status_code")) : 0;
            String name = params.get("name");
            String phone = params.get("phone");
            Long updatedAt = Long.valueOf(params.get("update_at"));

            try {
                Order order = this.getOrderService().get(elemeOrderId);
                this.pushConsumer.delivery(order, statusCode, subStatusCode, name, phone, updatedAt);
            } catch (ElemeErrorException e) {
                logging(e.getRequestUrl(), false, e.getRequestParams().toString(), e.getResponseString());
                return new ResultMessage(e.getMessage());
            }
        }
        return ResultMessage.buildOk();
    }

    private void logging(String cmd, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, isSuccess, request, response);
        }
    }

    private OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }

    @Override
    public FoodService getFoodService() {
        if (foodService == null) {
            foodService = new FoodServiceImpl(getClient(), configStorage, logListener);
        }
        return foodService;
    }

    @Override
    public FoodCategoryService getFoodCategoryService() {
        if (foodCategoryService == null) {
            foodCategoryService = new FoodCategoryServiceImpl(getClient(), configStorage, logListener);
        }
        return foodCategoryService;
    }

    @Override
    public RestaurantService getRestaurantService() {
        if (restaurantService == null) {
            restaurantService = new RestaurantServiceImpl(getClient(), configStorage, logListener);
        }
        return restaurantService;
    }

    @Override
    public ImageService getImageService() {
        if (imageService == null) {
            imageService = new ImageServiceImpl(getClient(), configStorage, logListener);
        }
        return imageService;
    }

    @Override
    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(getClient(), configStorage, logListener);
        }
        return orderService;
    }

    @Override
    public CommentService getCommentService() {
        if (commentService == null) {
            commentService = new CommentServiceImpl(getClient(), configStorage, logListener);
        }
        return commentService;
    }

}
