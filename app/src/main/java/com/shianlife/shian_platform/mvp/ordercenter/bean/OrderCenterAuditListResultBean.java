package com.shianlife.shian_platform.mvp.ordercenter.bean;

import java.util.List;

/**
 * Created by zm.
 */

public class OrderCenterAuditListResultBean {

    List<Content> content;
    private long pageSize;
    private long pageNumber;

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public static class Content extends OrderCenterDetails {


    }
}
