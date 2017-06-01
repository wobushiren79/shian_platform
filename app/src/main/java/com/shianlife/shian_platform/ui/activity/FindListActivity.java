package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.FindAdapter;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.appenum.FindEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.find.presenter.impl.FindPresenterImpl;
import com.shianlife.shian_platform.mvp.find.view.IFindView;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class FindListActivity extends BaseActivity implements IFindView {

    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    PtrClassicFrameLayout ptrLayout;

    private int pagerSize = 10;
    private int pagerNum = 0;
    private int findType = FindEnum.COLLECTIONFIND.getCode();
    private FindAdapter findAdapter;
    private FindPresenterImpl findPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_list);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_find), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
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
    public Context getContext() {
        return this;
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
    public void showData(FindResultBean result) {
        ptrLayout.refreshComplete();
        FindResultBean resultBean = result;
        findAdapter.setData(resultBean.getItems());
    }

    @Override
    public void showMsg(String msg) {
        ptrLayout.refreshComplete();
        pagerNum = pagerNum > 0 ? pagerNum : pagerNum--;
//        ToastUtils.showToastShort(getContext(), msg);
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
}
