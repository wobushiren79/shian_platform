package com.shianlife.shian_platform.custom.view.tablist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.shianlife.shian_platform.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zm.
 */

public class BaseTabListView extends LinearLayout {
    private View mView;
    private TabLayout mTablayout;
    private AppBarLayout mAppbar;
    private ViewPager mViewpager;

    private TabListViewPagerAdapter pagerAdapter;
    private TabListViewPagerChangeListener pagerChangeListener;

    protected LinkedHashMap<String, View> mapListView;//列表数据

    public BaseTabListView(Context context) {
        super(context, null);
    }

    public BaseTabListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        initData();
    }

    private void initView() {
        mView = View.inflate(getContext(), R.layout.layout_tab_list_view, this);
        mTablayout = (TabLayout) mView.findViewById(R.id.tablayout);
        mAppbar = (AppBarLayout) mView.findViewById(R.id.appbar);
        mViewpager = (ViewPager) mView.findViewById(R.id.viewpager);
    }

    private void initData() {


    }

    /**
     * 设置pagerAdapter
     *
     * @param adapter
     */
    public void setPagerAdapter(TabListViewPagerAdapter adapter) {
        mViewpager.setAdapter(pagerAdapter);
    }

    /**
     * 设置pager改变监听
     *
     * @param pagerChangeListener
     */
    public void setOnPagerChangeListener(TabListViewPagerChangeListener pagerChangeListener) {
        mViewpager.addOnPageChangeListener(pagerChangeListener);
    }

    /**
     * 设置数据
     *
     * @param mapListView
     */
    public void setListView(LinkedHashMap<String, View> mapListView) {
        this.mapListView = mapListView;
        int index = 0;

        List<View> listDataView = new ArrayList<>();
        for (Map.Entry<String, View> entry : mapListView.entrySet()) {
            View itemView = entry.getValue();
            listDataView.add(itemView);
            index++;
        }

        if (pagerAdapter == null)
            pagerAdapter = new TabListViewPagerAdapter(getContext(), listDataView);
        mViewpager.setAdapter(pagerAdapter);

        if (pagerChangeListener == null)
            pagerChangeListener = new TabListViewPagerChangeListener();
        mViewpager.addOnPageChangeListener(pagerChangeListener);

        mTablayout.setupWithViewPager(mViewpager);

        index = 0;
        for (Map.Entry<String, View> entry : mapListView.entrySet()) {
            String titleName = entry.getKey();
            mTablayout.getTabAt(index).setText(titleName);
            index++;
        }
    }

}

