package com.shianlife.shian_platform.ui.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.MyAppAdapter;
import com.shianlife.shian_platform.appenum.APPEnum;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollRecyclerView;
import com.shianlife.shian_platform.ui.activity.AllAppActivity;
import com.shianlife.shian_platform.utils.IntentUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class MainAppLayout extends BaseLayout {

    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.gridview)
    ScrollRecyclerView gridview;


    private APPEnum[] appNameList;
    private MyAppAdapter appAdapter;

    public MainAppLayout(Context context) {
        this(context, null);
    }

    public MainAppLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_mainapp, attrs);
    }

    @Override
    protected void initView() {
        gridview.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    protected void initData() {
        appNameList = new APPEnum[]{
                APPEnum.ZSPROJECT,
                APPEnum.CEMETERY,
                APPEnum.BEFORECONTRACT,
                APPEnum.NAVIGATION,
                APPEnum.CALENDAR,
                APPEnum.ALL
        };

        appAdapter = new MyAppAdapter(getContext());
        appAdapter.setData(appNameList);
        gridview.setAdapter(appAdapter);
    }


    @OnClick(R.id.iv_more)
    public void onViewClicked() {
        new IntentUtils
                .Build(getContext(), AllAppActivity.class)
                .start();
    }
}
