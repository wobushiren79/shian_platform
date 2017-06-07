package com.shianlife.shian_platform.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.DriverOrderViewPagerAdapter;
import com.shianlife.shian_platform.appenum.DriverOrderListEnum;
import com.shianlife.shian_platform.base.BaseFragment;
import com.shianlife.shian_platform.listener.DriverPagerListener;
import com.shianlife.shian_platform.ui.order.driver.BaseDriverLayout;
import com.shianlife.shian_platform.ui.order.driver.FailService;
import com.shianlife.shian_platform.ui.order.driver.InService;
import com.shianlife.shian_platform.ui.order.driver.SuccessService;
import com.shianlife.shian_platform.ui.order.driver.WaitService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zm.
 */

public class DriverOrderFragment extends BaseFragment {
    View view;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;


    private DriverOrderViewPagerAdapter mDriverPagerAdapter;
    private DriverPagerListener mPagerListener;
    private DriverOrderListEnum[] mDriverOrderListEna;
    public static boolean isRefesh = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_driver_order, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout.setTabGravity(TabLayout.GRAVITY_CENTER);
    }

    @Override
    protected void initData() {

        mDriverOrderListEna = new DriverOrderListEnum[]{
                DriverOrderListEnum.waitservice,
                DriverOrderListEnum.inservice,
                DriverOrderListEnum.successservice,
                DriverOrderListEnum.failservice
        };

        List<View> viewList = new ArrayList<>();

        for (int i = 0; i < mDriverOrderListEna.length; i++) {
            BaseDriverLayout baseView = null;
            if (mDriverOrderListEna[i].getCode() == DriverOrderListEnum.waitservice.getCode()) {
                baseView = new WaitService(getContext());
            } else if (mDriverOrderListEna[i].getCode() == DriverOrderListEnum.inservice.getCode()) {
                baseView = new InService(getContext());
            } else if (mDriverOrderListEna[i].getCode() == DriverOrderListEnum.successservice.getCode()) {
                baseView = new SuccessService(getContext());
            } else if (mDriverOrderListEna[i].getCode() == DriverOrderListEnum.failservice.getCode()) {
                baseView = new FailService(getContext());
            } else {
                baseView = new WaitService(getContext());
            }
            viewList.add(baseView);
        }
        mDriverPagerAdapter = new DriverOrderViewPagerAdapter(getContext(), viewList);
        mPagerListener = new DriverPagerListener();
        viewpager.setAdapter(mDriverPagerAdapter);
        viewpager.addOnPageChangeListener(mPagerListener);
        tablayout.setupWithViewPager(viewpager);

        for (int i = 0; i < mDriverOrderListEna.length; i++) {
            tablayout.getTabAt(i).setText(mDriverOrderListEna[i].getName());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
