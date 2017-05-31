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
import com.shianlife.shian_platform.base.BaseFragment;
import com.shianlife.shian_platform.listener.DriverPagerListener;

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
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            TextView tvContent = new TextView(getContext());
            tvContent.setText(i + "test");
            viewList.add(tvContent);
        }
        mDriverPagerAdapter = new DriverOrderViewPagerAdapter(getContext(), viewList);
        mPagerListener = new DriverPagerListener();
        viewpager.setAdapter(mDriverPagerAdapter);
        viewpager.addOnPageChangeListener(mPagerListener);
        tablayout.setupWithViewPager(viewpager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
