package com.shianlife.shian_platform.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.shianlife.shian_platform.R;

import butterknife.ButterKnife;

/**
 * Created by zm.
 */

public abstract class BaseLayout extends LinearLayout {
    View view;

    protected TypedArray typedArray = null;
    protected String titleName;
    protected String contentText;
    protected String hintText;
    protected int layoutType;
    protected boolean showMode;


    public BaseLayout(Context context, int layoutId) {
        this(context, layoutId, null);
    }

    public BaseLayout(Context context, int layoutId, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, layoutId, this);
        ButterKnife.bind(this);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomAttr);
        getAttrs();
        initView();
        initData();
    }

    protected void getAttrs() {
        titleName = typedArray.getString(R.styleable.CustomAttr_titleName);
        hintText = typedArray.getString(R.styleable.CustomAttr_hintText);
        contentText = typedArray.getString(R.styleable.CustomAttr_contentText);
        layoutType = typedArray.getInt(R.styleable.CustomAttr_layoutType, -1);
        showMode = typedArray.getBoolean(R.styleable.CustomAttr_showMode, false);
        typedArray.recycle();
    }

    protected abstract void initView();

    protected abstract void initData();


}
