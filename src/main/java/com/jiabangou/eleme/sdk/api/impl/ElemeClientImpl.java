package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.*;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Order;
import com.jiabangou.eleme.sdk.model.PushAction;
import com.jiabangou.eleme.sdk.model.ResultMessage;
import com.jiabangou.eleme.sdk.utils.ElemeUtils;
import okhttp3.OkHttpClient;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

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
    private PushProcessor pushProcessor;

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

    @Override
    public void setPushProcessor(PushProcessor pushProcessor) {
        this.pushProcessor = pushProcessor;
    }

    @Override
    public ResultMessage handle(String url, Map<String, String> params) {
        if (this.pushProcessor == null) {
            return new ResultMessage("pushProcessor does not implement");
        }
        try {
            sigCheck(url, params);
        } catch (Exception e) {
            return new ResultMessage(e.getMessage());
        }
        String pushAction = params.get("push_action");
        if (PushAction.NEW_ORDER.equals(pushAction)) {
            String eleme_order_ids = params.get("eleme_order_ids");
            List<Long> orderIds = Arrays.asList(eleme_order_ids.split(",")).stream().map(Long::valueOf).collect(toList());
            List<Order> orders = new ArrayList<>(orderIds.size());
            for (Long orderId : orderIds) {
                try {
                    orders.add(this.getOrderService().get(orderId));
                } catch (ElemeErrorException e) {
                    return new ResultMessage(e.getMessage());
                }
            }
            this.pushProcessor.newOrder(orders);
        } else if (PushAction.ORDER_STATUS_UPDATE.equals(pushAction)) {
            Long elemeOrderId = Long.valueOf(params.get("eleme_order_id"));
            String tpOrderId = params.get("tp_order_id");
            Short newStatus = Short.valueOf(params.get("new_status"));
            String extra = params.get("extra");
            try {
                Order order = this.getOrderService().get(elemeOrderId);
                this.pushProcessor.orderStatusUpdate(order, tpOrderId, newStatus, extra);
            } catch (ElemeErrorException e) {
                return new ResultMessage(e.getMessage());
            }
        } else if (PushAction.REFUND_ORDER.equals(pushAction)) {
            Long elemeOrderId = Long.valueOf(params.get("eleme_order_id"));
            Short refundStatus = Short.valueOf(params.get("refund_status"));

            try {
                Order order = this.getOrderService().get(elemeOrderId);
                this.pushProcessor.refundOrder(order, refundStatus);
            } catch (ElemeErrorException e) {
                return new ResultMessage(e.getMessage());
            }
        } else if (PushAction.DELIVERY.equals(pushAction)) {
            Long elemeOrderId = Long.valueOf(params.get("eleme_order_id"));
            Short statusCode = Short.valueOf(params.get("status_code"));
            Short subStatusCode = Short.valueOf(params.get("sub_status_code"));
            String name = params.get("name");
            String phone = params.get("phone");
            Long updatedAt = Long.valueOf(params.get("update_at"));

            try {
                Order order = this.getOrderService().get(elemeOrderId);
                this.pushProcessor.delivery(order, statusCode, subStatusCode, name, phone, updatedAt);
            } catch (ElemeErrorException e) {
                return new ResultMessage(e.getMessage());
            }
        }
        return ResultMessage.buildOk();
    }

    protected void sigCheck(String url, Map<String, String> params) {
        if (!url.contains("?")) {
            throw new RuntimeException("timestamp, sig, consumer_key is required");
        }
        String noQueryUrl = url.substring(0, url.indexOf("?"));
        String queryString = url.substring(url.indexOf("?") + 1, url.length());
        Map<String, String> signParams = new HashMap<>();
        String sig = null;
        List<String> queryParts = Arrays.asList(StringUtils.split(queryString, "&"));
        for (String queryPart : queryParts) {
            String[] kv = queryPart.split("=");
            if ("sig".equals(kv[0])) {
                sig = kv[1];
            } else {
                signParams.put(kv[0], kv[1]);
            }
        }
        if (sig == null) {
            throw new RuntimeException("sig is required");
        }
        if (!signParams.containsKey("timestamp")) {
            throw new RuntimeException("timestamp is required");
        }
        if (!signParams.containsKey("consumer_key")) {
            throw new RuntimeException("consumer_key is required");
        }
        if (configStorage.getConsumerKey().equals(signParams.get("consumer_key"))) {
            throw new RuntimeException("consumer_key is incorrect");
        }
        signParams.putAll(params);

        List<String> sortParams = signParams.entrySet().stream()
                .map(entry -> entry.getKey() + "=" +
                        ElemeUtils.urlEncode(entry.getValue())).sorted().collect(toList());

        String signature = DigestUtils.sha1Hex(ElemeUtils.toHex(noQueryUrl + "?" +
                StringUtils.join(sortParams, "&")
                + configStorage.getConsumerSecret()));

        if (!signature.equals(sig)) {
            throw new RuntimeException("sig is incorrect");
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
