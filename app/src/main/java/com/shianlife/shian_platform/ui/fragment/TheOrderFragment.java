package com.shianlife.shian_platform.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.FindAdapter;
import com.shianlife.shian_platform.adapter.OrderShowListAdapter;
import com.shianlife.shian_platform.base.BaseFragment;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.mvp.order.bean.OrderShowResultBean;
import com.shianlife.shian_platform.mvp.order.presenter.IOrderShowPresenter;
import com.shianlife.shian_platform.mvp.order.presenter.impl.OrderShowPresenterImpl;
import com.shianlife.shian_platform.mvp.order.view.IOrderShowView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * Created by zm.
 */

public class TheOrderFragment extends BaseFragment implements IOrderShowView {

    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;
    Unbinder unbinder;

    private View mBaseLayout;
    private OrderShowListAdapter mShowListAdapter;
    private IOrderShowPresenter orderShowPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseLayout = inflater.inflate(R.layout.fragment_theorder, null, false);
        unbinder = ButterKnife.bind(this, mBaseLayout);

        initView();
        initData();
        return mBaseLayout;
    }

    @Override
    protected void initView() {
        rcContent.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mShowListAdapter = new OrderShowListAdapter(getContext());
        rcContent.setAdapter(mShowListAdapter);
    }

    @Override
    protected void initData() {
        orderShowPresenter = new OrderShowPresenterImpl(this);
        orderShowPresenter.getOrderShowItem();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showOrderItems(OrderShowResultBean resultBean) {
        mShowListAdapter.setData(resultBean.getList());
    }
}
