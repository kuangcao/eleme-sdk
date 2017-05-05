package com.jiabangou.eleme.pcsdk;

import com.jiabangou.eleme.pcsdk.api.*;

/**
 *
 * Created by freeway on 2016/12/4.
 */
public interface ElemePCSDKClient {

    void setElemePCConfigStorage(ElemePCConfigStorage configStorage);

    void setPCLogListener(PCLogListener logListener);

    LoginService getLoginService();

    FoodService getFoodService();

    OrderService getOrderService();

    CommentService getCommentService();

    DeliveryService getDeliveryService();
}
