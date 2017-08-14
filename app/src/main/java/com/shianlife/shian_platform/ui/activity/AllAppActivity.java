package com.shianlife.shian_platform.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.MyAppAdapter;
import com.shianlife.shian_platform.appenum.APPEnum;
import com.shianlife.shian_platform.appenum.AdvertisementEnum;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollRecyclerView;
import com.shianlife.shian_platform.ui.custom.MainAdvertisementLayout;

import butterknife.BindView;

public class AllAppActivity extends BaseActivity {

    @BindView(R.id.platform_gridview)
    ScrollRecyclerView platformGridview;
    @BindView(R.id.tools_gridview)
    ScrollRecyclerView toolsGridview;
    @BindView(R.id.other_gridview)
    ScrollRecyclerView otherGridview;
    @BindView(R.id.appadvertisementlayout)
    MainAdvertisementLayout appadvertisementlayout;

    APPEnum[] platformData;
    APPEnum[] toolsData;
    APPEnum[] otherData;

    MyAppAdapter platformAppAdapter;
    MyAppAdapter toolsAppAdapter;
    MyAppAdapter otherAppAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_app);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_app), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        platformGridview.setLayoutManager(new GridLayoutManager(this, 3));
        toolsGridview.setLayoutManager(new GridLayoutManager(this, 3));
        otherGridview.setLayoutManager(new GridLayoutManager(this, 3));

        platformAppAdapter = new MyAppAdapter(this);
        toolsAppAdapter = new MyAppAdapter(this);
        otherAppAdapter = new MyAppAdapter(this);

    }

    @Override
    protected void initData() {
        platformData = new APPEnum[]{
                APPEnum.ZSPROJECT,
                APPEnum.CEMETERY,
                APPEnum.VRCEMETERY,
                APPEnum.BEFORECONTRACT
        };
        toolsData = new APPEnum[]{
                APPEnum.NAVIGATION,
                APPEnum.CALENDAR,
                APPEnum.CALCULATOR,
                APPEnum.DIDI,
                APPEnum.COMMUNICATION
        };
        otherData = new APPEnum[]{
                APPEnum.INTEGRALMALL
        };
        platformAppAdapter.setData(platformData);
        toolsAppAdapter.setData(toolsData);
        otherAppAdapter.setData(otherData);

        platformGridview.setAdapter(platformAppAdapter);
        toolsGridview.setAdapter(toolsAppAdapter);
        otherGridview.setAdapter(otherAppAdapter);

        appadvertisementlayout.setType(AdvertisementEnum.APP.getCode());
    }
}
