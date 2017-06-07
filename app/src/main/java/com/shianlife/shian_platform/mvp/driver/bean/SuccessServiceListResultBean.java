package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class SuccessServiceListResultBean extends BaseDataResult {
    List<SuccessServiceItemData> items;

    public List<SuccessServiceItemData> getItems() {
        return items;
    }

    public void setItems(List<SuccessServiceItemData> items) {
        this.items = items;
    }

    public static class SuccessServiceItemData extends BaseDriverOrderResultItemBean {

    }
}
