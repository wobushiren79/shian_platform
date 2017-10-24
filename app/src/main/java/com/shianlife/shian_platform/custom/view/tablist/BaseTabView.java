package com.shianlife.shian_platform.custom.view.tablist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by zm.
 */

public class BaseTabView extends LinearLayout {
    private String titleName;

    public BaseTabView(Context context) {
        this(context, null);
    }

    public BaseTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.titleName = "未设置";
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleNmae() {
        return titleName;
    }

}
