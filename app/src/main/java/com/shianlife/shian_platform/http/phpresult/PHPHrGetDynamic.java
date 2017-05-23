package com.shianlife.shian_platform.http.phpresult;


import com.shianlife.shian_platform.http.phpmodel.DynamicItemsInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public class PHPHrGetDynamic {

    private List<DynamicItemsInfo> items;

    public List<DynamicItemsInfo> getItems() {
        return items;
    }

    public void setItems(List<DynamicItemsInfo> items) {
        this.items = items;
    }
}
