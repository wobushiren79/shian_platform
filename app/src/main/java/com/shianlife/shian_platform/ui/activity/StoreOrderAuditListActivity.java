package com.shianlife.shian_platform.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.appenum.StoreOrderAuditListEnum;
import com.shianlife.shian_platform.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreOrderAuditListActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private StoreOrderAuditListEnum[] mStoreOrderListEna;
    private List<View> viewList;
    public static boolean isRefresh_Change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order_audit_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        setTitle("单项审核", BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {
        mStoreOrderListEna = new StoreOrderAuditListEnum[]{
                StoreOrderAuditListEnum.auditing,
                StoreOrderAuditListEnum.servicesuccess
        };
        viewList = new ArrayList<>();
    }
}
