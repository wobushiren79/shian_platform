package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class SuccessServiceListResultBean extends BaseDataResult {
    List<SuccessServiceItemData> list;
    private long pageSize;
    private long pageNum;

    public List<SuccessServiceItemData> getList() {
        return list;
    }

    public void setList(List<SuccessServiceItemData> list) {
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

    public static class SuccessServiceItemData extends BaseDriverOrderResultItemBean {

    }
}
