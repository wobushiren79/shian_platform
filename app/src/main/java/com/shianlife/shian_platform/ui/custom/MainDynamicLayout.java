package com.shianlife.shian_platform.ui.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class MainDynamicLayout extends BaseLayout {
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.listView)
    ScrollRecyclerView listView;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public MainDynamicLayout(Context context) {
        this(context, null);
    }

    public MainDynamicLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_maindynamic, attrs);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.iv_more)
    public void onViewClicked() {
    }
}
