package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class FailServiceListResultBean extends BaseDataResult {
    List<FailServiceItemData> list;
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

    public List<FailServiceItemData> getList() {
        return list;
    }

    public void setList(List<FailServiceItemData> list) {
        this.list = list;
    }

    public static class FailServiceItemData extends BaseDriverOrderResultItemBean {
        //取消订单后是否还车
        private boolean cancelReturnCar;

        public boolean isCancelReturnCar() {
            return cancelReturnCar;
        }

        public void setCancelReturnCar(boolean cancelReturnCar) {
            this.cancelReturnCar = cancelReturnCar;
        }
    }
}
