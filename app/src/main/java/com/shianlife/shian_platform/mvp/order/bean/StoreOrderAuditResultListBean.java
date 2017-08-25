package com.shianlife.shian_platform.mvp.order.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderAuditResultListBean {
    private int pageSize; //每页显示记录数
    private int pageNumber; //当前页
    private List<Content> content;//内容

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public static class Content {

        private Long id;
        private GoodsOrder goodsOrder;
        private GoodsPerform        goodsPerform;
        private GoodsServiceInfo goodsServiceInfo;
        /**
         * 订单取消记录
         */
        private GoodsOrderCancel goodsOrderCancel;

        /**
         * 执行单交易关闭
         */
        private GoodsPerformCancel goodsPerformCancel;

        private String createdName;
        private String orderAttr;//订单属性

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

        public GoodsPerform getGoodsPerform() {
            return goodsPerform;
        }

        public void setGoodsPerform(GoodsPerform goodsPerform) {
            this.goodsPerform = goodsPerform;
        }

        public String getOrderAttr() {
            return orderAttr;
        }

        public void setOrderAttr(String orderAttr) {
            this.orderAttr = orderAttr;
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

        public GoodsServiceInfo getGoodsServiceInfo() {
            return goodsServiceInfo;
        }

        public void setGoodsServiceInfo(GoodsServiceInfo goodsServiceInfo) {
            this.goodsServiceInfo = goodsServiceInfo;
        }

        public String getCreatedName() {
            return createdName;
        }

        public void setCreatedName(String createdName) {
            this.createdName = createdName;
        }
    }
}
