package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class InServiceListResultBean extends BaseDataResult {
    List<InServiceItemData> list;
    private long pageSize;
    private long pageNum;

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

    public List<InServiceItemData> getList() {
        return list;
    }

    public void setList(List<InServiceItemData> list) {
        this.list = list;
    }

    public static class InServiceItemData extends BaseDriverOrderResultItemBean{

    }
}
