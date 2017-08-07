package com.shianlife.shian_platform.mvp.order.bean;

import java.util.List;

/**
 * Created by zm.
 */

public class StoreAuditPerformListResultBean {
    private List<Content> content;

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public static class Content {
        private Long id;
        /**
         * 订单表
         */
        private GoodsOrder goodsOrder;
        /**
         * 商品表
         */
        private GoodsOrderItem goodsOrderItem;
        /**
         * 服务信息
         */
        private GoodsServiceInfo goodsServiceInfo;
        /**
         * 执行单
         */
        private GoodsPerform goodsPerform;
        /**
         * 执行单审核表
         */
        private GoodsPerformHistory goodsPerformHistory;


    }

}
