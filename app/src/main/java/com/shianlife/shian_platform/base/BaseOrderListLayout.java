package com.shianlife.shian_platform.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by zm.
 */

public abstract class BaseOrderListLayout extends LinearLayout {
    public BaseOrderListLayout(Context context) {
        super(context);
    }

    public BaseOrderListLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public abstract void refesh();
}
