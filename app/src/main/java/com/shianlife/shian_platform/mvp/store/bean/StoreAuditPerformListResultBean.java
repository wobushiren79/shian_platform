package com.shianlife.shian_platform.mvp.store.bean;

import java.io.Serializable;
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

    public static class Content implements Serializable {
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

        /**
         * 执行商家姓名
         */
        private String performUserName;

        /**
         * 执行商家电话
         */
        private String performUserPhone;


        /**
         * 订单取消记录
         */
        private GoodsOrderCancel goodsOrderCancel;

        /**
         * 执行单交易关闭
         */
        private GoodsPerformCancel goodsPerformCancel;

        public GoodsOrderCancel getGoodsOrderCancel() {
            return goodsOrderCancel;
        }

        public void setGoodsOrderCancel(GoodsOrderCancel goodsOrderCancel) {
            this.goodsOrderCancel = goodsOrderCancel;
        }

        public GoodsPerformCancel getGoodsPerformCancel() {
            return goodsPerformCancel;
        }

        public void setGoodsPerformCancel(GoodsPerformCancel goodsPerformCancel) {
            this.goodsPerformCancel = goodsPerformCancel;
        }

        public String getPerformUserPhone() {
            return performUserPhone;
        }

        public void setPerformUserPhone(String performUserPhone) {
            this.performUserPhone = performUserPhone;
        }

        public String getPerformUserName() {
            return performUserName;
        }

        public void setPerformUserName(String performUserName) {
            this.performUserName = performUserName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public GoodsOrder getGoodsOrder() {
            return goodsOrder;
        }

        public void setGoodsOrder(GoodsOrder goodsOrder) {
            this.goodsOrder = goodsOrder;
        }

        public GoodsOrderItem getGoodsOrderItem() {
            return goodsOrderItem;
        }

        public void setGoodsOrderItem(GoodsOrderItem goodsOrderItem) {
            this.goodsOrderItem = goodsOrderItem;
        }

        public GoodsServiceInfo getGoodsServiceInfo() {
            return goodsServiceInfo;
        }

        public void setGoodsServiceInfo(GoodsServiceInfo goodsServiceInfo) {
            this.goodsServiceInfo = goodsServiceInfo;
        }

        public GoodsPerform getGoodsPerform() {
            return goodsPerform;
        }

        public void setGoodsPerform(GoodsPerform goodsPerform) {
            this.goodsPerform = goodsPerform;
        }

        public GoodsPerformHistory getGoodsPerformHistory() {
            return goodsPerformHistory;
        }

        public void setGoodsPerformHistory(GoodsPerformHistory goodsPerformHistory) {
            this.goodsPerformHistory = goodsPerformHistory;
        }
    }

}
