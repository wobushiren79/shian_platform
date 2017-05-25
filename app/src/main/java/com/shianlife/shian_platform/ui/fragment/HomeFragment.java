package com.shianlife.shian_platform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by zm.
 */

public class HomeFragment extends BaseFragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null, false);
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
