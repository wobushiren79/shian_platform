package com.shianlife.shian_platform.http.phpresult;


import com.shianlife.shian_platform.http.phpmodel.HotIssueData;

import java.util.List;

public class PHPHrGetHotIssue {
    private List<HotIssueData> items;

    public List<HotIssueData> getItems() {
        return items;
    }

    public void setItems(List<HotIssueData> items) {
        this.items = items;
    }
}
