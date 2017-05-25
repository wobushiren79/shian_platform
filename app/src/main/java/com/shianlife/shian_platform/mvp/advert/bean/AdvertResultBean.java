package com.shianlife.shian_platform.mvp.advert.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

import java.util.List;

/**
 * Created by zm.
 */

public class AdvertResultBean extends BaseDataResult{
    private List<AdvertisementData> items;

    public List<AdvertisementData> getItems() {
        return items;
    }

    public void setItems(List<AdvertisementData> items) {
        this.items = items;
    }

    public static class AdvertisementData {
        private String banner;//   广告页地址
        private String url;//  广告链接地址

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
