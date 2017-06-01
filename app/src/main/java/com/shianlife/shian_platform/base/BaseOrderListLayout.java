package com.shianlife.shian_platform.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.ButterKnife;

/**
 * Created by zm.
 */

public abstract class BaseOrderListLayout extends LinearLayout {
    View view;

    public BaseOrderListLayout(Context context, int layoutId) {
        this(context, layoutId, null);
    }

    public BaseOrderListLayout(Context context, int layoutId, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, layoutId, this);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void refesh();
}
