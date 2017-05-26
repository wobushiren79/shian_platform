package com.shianlife.shian_platform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.AdvertisementEnum;
import com.shianlife.shian_platform.base.BaseFragment;
import com.shianlife.shian_platform.ui.custom.MainAdvertisementLayout;
import com.shianlife.shian_platform.ui.custom.MainAppLayout;
import com.shianlife.shian_platform.ui.custom.MainDynamicLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zm.
 */

public class HomeFragment extends BaseFragment {
    View view;
    @BindView(R.id.mainadvertisement_layout)
    MainAdvertisementLayout mainadvertisementLayout;
    @BindView(R.id.maindynamic_layout)
    MainDynamicLayout maindynamicLayout;
    @BindView(R.id.mainapp_layout)
    MainAppLayout mainappLayout;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mainadvertisementLayout.setType(AdvertisementEnum.MAIN.getCode());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
