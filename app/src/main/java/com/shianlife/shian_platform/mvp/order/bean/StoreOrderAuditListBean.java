package com.shianlife.shian_platform.mvp.order.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderAuditListBean extends BaseHttpParams {
    private int pageSize; //每页显示记录数
    private int pageNumber; //当前页
    private Content content;//内容


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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public static class Content {
        private List<Integer> orderStatus;//订单状态
        private Integer performStatus; //执行人ID

        public List<Integer> getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(List<Integer> orderStatus) {
            this.orderStatus = orderStatus;
        }

        public Integer getPerformStatus() {
            return performStatus;
        }

        public void setPerformStatus(Integer performStatus) {
            this.performStatus = performStatus;
        }
    }
}
