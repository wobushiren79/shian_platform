package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class InServiceListResultBean extends BaseDataResult {
    List<InServiceItemData> items;

    public List<InServiceItemData> getItems() {
        return items;
    }

    public void setItems(List<InServiceItemData> items) {
        this.items = items;
    }

    public static class InServiceItemData {

    }
}
