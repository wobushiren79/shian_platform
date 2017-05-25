package com.shianlife.shian_platform.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.FindAdapter;
import com.shianlife.shian_platform.appenum.FindEnum;
import com.shianlife.shian_platform.base.BaseFragment;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.find.presenter.impl.FindPresenterImpl;
import com.shianlife.shian_platform.mvp.find.view.IFindView;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by zm.
 */

public class FindFragment extends BaseFragment implements IFindView {
    View view;
    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    PtrClassicFrameLayout ptrLayout;
    @BindView(R.id.iv_collection)
    ImageView ivCollection;
    Unbinder unbinder;


    private int pagerNum = 0;
    private int pagerSize = 10;
    private int findType = FindEnum.DEFAULTFIND.getCode();
    private FindAdapter findAdapter;
    private FindPresenterImpl findPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        findAdapter = new FindAdapter(getContext());
        rcContent.setAdapter(findAdapter);
    }

    @Override
    protected void initData() {
        findPresenter = new FindPresenterImpl(this);
        findPresenter.getFindData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public int getPagerSize() {
        return pagerSize;
    }

    @Override
    public int getPagerNum() {
        return pagerNum;
    }

    @Override
    public int getFindType() {
        return findType;
    }

    @Override
    public void showData(BaseDataResult result) {
        ptrLayout.refreshComplete();
        FindResultBean resultBean = (FindResultBean) result;
        findAdapter.setData(resultBean.getItems());
    }

    @Override
    public void showMsg(String msg) {
        ptrLayout.refreshComplete();
        pagerNum = pagerNum > 0 ? pagerNum : pagerNum--;
        ToastUtils.showToastShort(getContext(), msg);
    }


    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            pagerNum++;
            findPresenter.getFindData();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            pagerNum = 0;
            findPresenter.getFindData();
        }
    };

    @OnClick(R.id.iv_collection)
    public void onViewClicked() {

    }


}
