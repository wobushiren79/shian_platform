package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class FailServiceListResultBean extends BaseDataResult {
    List<FailServiceItemData> items;

    public List<FailServiceItemData> getItems() {
        return items;
    }

    public void setItems(List<FailServiceItemData> items) {
        this.items = items;
    }

    public static class FailServiceItemData extends BaseDriverOrderResultItemBean {

    }
}
