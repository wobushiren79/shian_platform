package com.shianlife.shian_platform.ui.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.DynamicAdapter;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollRecyclerView;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;
import com.shianlife.shian_platform.mvp.dynamic.presenter.IDynamicPresenter;
import com.shianlife.shian_platform.mvp.dynamic.presenter.impl.DynamicPresenterImpl;
import com.shianlife.shian_platform.mvp.dynamic.view.IDynamicView;
import com.shianlife.shian_platform.ui.activity.DynamicListActivity;
import com.shianlife.shian_platform.utils.IntentUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class MainDynamicLayout extends BaseLayout implements IDynamicView {
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.listView)
    ScrollRecyclerView listView;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private int pagerSize = 3;//动态通知数量
    private IDynamicPresenter dynamicPresenter;
    private DynamicAdapter dynamicAdapter;

    public MainDynamicLayout(Context context) {
        this(context, null);
    }

    public MainDynamicLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_maindynamic, attrs);
    }


    @Override
    protected void initView() {
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected void initData() {
        dynamicPresenter = new DynamicPresenterImpl(this);
        dynamicAdapter = new DynamicAdapter(getContext());
        listView.setAdapter(dynamicAdapter);
        dynamicPresenter.getDynamicData();
    }

    @OnClick(R.id.iv_more)
    public void onViewClicked() {
        new IntentUtils.Build(getContext(), DynamicListActivity.class)
                .start();
    }

    @Override
    public int getPagerSize() {
        return pagerSize;
    }

    @Override
    public int getPagerNum() {
        return 0;
    }

    @Override
    public void showData(DynamicResultBean result) {
        DynamicResultBean data =  result;
        dynamicAdapter.setData(data.getItems());
        this.setVisibility(VISIBLE);
    }



    @Override
    public void showMsg(String msg) {

    }
}
