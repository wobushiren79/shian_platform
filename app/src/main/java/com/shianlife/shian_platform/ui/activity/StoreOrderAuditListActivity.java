package com.shianlife.shian_platform.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.StoreOrderAuditViewPageAdapter;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.appenum.GoodsOrderStatusEnum;
import com.shianlife.shian_platform.appenum.GoodsPerformStatusEnum;
import com.shianlife.shian_platform.appenum.StoreOrderAuditListEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.listener.StoreOrderAuditPagerChangeListener;
import com.shianlife.shian_platform.ui.order.store.StoreOrderAuditList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class StoreOrderAuditListActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private StoreOrderAuditListEnum[] mStoreOrderListEna;
    private StoreOrderAuditViewPageAdapter mStoreAdapter;
    private StoreOrderAuditPagerChangeListener mPagerListener;
    private List<View> viewList;
    public static boolean isRefresh_Change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order_audit_list);


    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_goods_audit), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {
        mStoreOrderListEna = new StoreOrderAuditListEnum[]{
                StoreOrderAuditListEnum.auditing,
                StoreOrderAuditListEnum.servicesuccess
        };
        viewList = new ArrayList<>();

        Integer[] temp = null;
        StoreOrderAuditList auditingList = new StoreOrderAuditList(this, temp, GoodsPerformStatusEnum.auditing.getCode());
        viewList.add(auditingList);

        StoreOrderAuditList successList = new StoreOrderAuditList
                (this, new Integer[]{GoodsOrderStatusEnum.servicecomplete.getCode(), GoodsOrderStatusEnum.servicesuccess.getCode()}, null);
        viewList.add(successList);

        tablayout.setupWithViewPager(viewpager);
        mStoreAdapter = new StoreOrderAuditViewPageAdapter(this, viewList);
        mPagerListener = new StoreOrderAuditPagerChangeListener();
        viewpager.setAdapter(mStoreAdapter);
        viewpager.addOnPageChangeListener(mPagerListener);

        for (int i = 0; i < mStoreOrderListEna.length; i++) {
            tablayout.getTabAt(i).setText(mStoreOrderListEna[i].getName());
        }
    }
}
