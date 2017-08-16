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
        private GoodsServiceInfo goodsServiceInfo;
        private String createdName;

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
