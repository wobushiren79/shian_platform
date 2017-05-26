package com.shianlife.shian_platform.mvp.dynamic.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class DynamicResultBean extends BaseDataResult {
    private List<DynamicItemsInfo> items;

    public List<DynamicItemsInfo> getItems() {
        return items;
    }

    public void setItems(List<DynamicItemsInfo> items) {
        this.items = items;
    }

    public static class DynamicItemsInfo {
        String time;//  创建时间
        String title;//  标题内容
        int id;//

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}
