package com.shianlife.shian_platform.mvp.ordercenter.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class OrderCenterAuditListBean extends BaseHttpParams {
    private int pageSize; //每页显示记录数
    private int pageNumber; //当前页
    private Params params;

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

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public static class Params {
        private int listType;//审核列表类型（0，所有数据。1.待审核列表。2已完成列表）

        public int getListType() {
            return listType;
        }

        public void setListType(int listType) {
            this.listType = listType;
        }
    }
}
