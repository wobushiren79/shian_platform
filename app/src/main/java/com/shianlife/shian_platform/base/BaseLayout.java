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

public abstract class BaseLayout extends LinearLayout {
    View view;

    public BaseLayout(Context context, int layoutId) {
        this(context, layoutId, null);
    }

    public BaseLayout(Context context, int layoutId, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, layoutId, this);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initView();

    protected abstract void initData();


}
