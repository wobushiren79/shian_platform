package com.shianlife.shian_platform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseFragment;

/**
 * Created by zm.
 */

public class StoreFragment extends BaseFragment {
    private View mBaseLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseLayout = inflater.inflate(R.layout.fragment_store, null, false);

        initView();
        initData();
        return mBaseLayout;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
