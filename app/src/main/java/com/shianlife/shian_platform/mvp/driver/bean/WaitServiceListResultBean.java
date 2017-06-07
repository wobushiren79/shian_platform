package com.shianlife.shian_platform.mvp.driver.bean;

import java.util.List;

/**
 * Created by zm.
 */

public class WaitServiceListResultBean {
    List<WaitServiceItemData> items;

    public List<WaitServiceItemData> getItems() {
        return items;
    }

    public void setItems(List<WaitServiceItemData> items) {
        this.items = items;
    }

    public static class WaitServiceItemData extends BaseDriverOrderResultItemBean{

    }
}
