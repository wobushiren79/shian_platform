package com.shianlife.shian_platform.mvp.driver.bean;

import java.util.List;

/**
 * Created by zm.
 */

public class WaitServiceListResultBean {

    private List<WaitServiceItemData> list;
    private long pageSize;
    private long pageNum;

    public List<WaitServiceItemData> getList() {
        return list;
    }

    public void setList(List<WaitServiceItemData> list) {
        this.list = list;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public static class WaitServiceItemData extends BaseDriverOrderResultItemBean {

    }
}
