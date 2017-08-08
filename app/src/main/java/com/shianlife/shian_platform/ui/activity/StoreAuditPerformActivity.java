package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.appenum.GoodsAduitResultEnum;
import com.shianlife.shian_platform.appenum.GoodsPerformStatusEnum;
import com.shianlife.shian_platform.appenum.GoodsServiceWayEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.custom.show.store.StoreEditNormalView;
import com.shianlife.shian_platform.custom.view.fileupload.FileUpLoadButton;
import com.shianlife.shian_platform.mvp.order.bean.GoodsPerform;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformResultBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformSubmitResultBean;
import com.shianlife.shian_platform.mvp.order.presenter.IStoreAuditPerformPresenter;
import com.shianlife.shian_platform.mvp.order.presenter.IStoreAuditPerformSubmitPresenter;
import com.shianlife.shian_platform.mvp.order.presenter.impl.StoreAuditPerformPresenterImpl;
import com.shianlife.shian_platform.mvp.order.presenter.impl.StoreAuditPerformSubmitPresenterImpl;
import com.shianlife.shian_platform.mvp.order.view.IStoreAuditPerformSubmitView;
import com.shianlife.shian_platform.mvp.order.view.IStoreAuditPerformView;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoreAuditPerformActivity extends BaseActivity implements IStoreAuditPerformView, IStoreAuditPerformSubmitView {

    @BindView(R.id.perform_status)
    StoreEditNormalView performStatus;
    @BindView(R.id.perform_way)
    StoreEditNormalView performWay;
    @BindView(R.id.accept_time)
    StoreEditNormalView acceptTime;
    @BindView(R.id.start_time)
    StoreEditNormalView startTime;
    @BindView(R.id.end_time)
    StoreEditNormalView endTime;
    @BindView(R.id.tv_perform_content)
    TextView tvPerformContent;
    @BindView(R.id.iv_perform_pic_1)
    ImageView ivPerformPic1;
    @BindView(R.id.iv_perform_pic_2)
    ImageView ivPerformPic2;
    @BindView(R.id.iv_perform_pic_3)
    ImageView ivPerformPic3;
    @BindView(R.id.et_audit_content)
    EditText etAuditContent;
    @BindView(R.id.tv_unpass)
    TextView tvUnpass;
    @BindView(R.id.tv_pass)
    TextView tvPass;

    private Intent intent;
    private StoreAuditPerformListResultBean.Content data;
    private IStoreAuditPerformPresenter storeAuditPerformPresenter;
    private IStoreAuditPerformSubmitPresenter storeAuditPerformSubmitPresenter;
    private List<String> picUrls;
    private Integer auditResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_audit_perform);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_goods_audit_perform), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {
        intent = getIntent();
        data = (StoreAuditPerformListResultBean.Content) intent.getSerializableExtra(IntentUtils.INTENT_DATA);
        if (data == null) {
            ToastUtils.showToastShort(this, "数据错误");
            finish();
            return;
        }
        GoodsPerform goodsPerform = data.getGoodsPerform();
        if (goodsPerform == null) {
            ToastUtils.showToastShort(this, "数据错误");
            return;
        }
        performStatus.setData(GoodsPerformStatusEnum.getValueText(goodsPerform.getPerformStatus()));
        performWay.setData(GoodsServiceWayEnum.getValueText(goodsPerform.getPerformWay()));
        acceptTime.setData(goodsPerform.getAcceptTime());
        startTime.setData(goodsPerform.getStartTime());
        endTime.setData(goodsPerform.getEndTime());

        storeAuditPerformPresenter = new StoreAuditPerformPresenterImpl(this);
        storeAuditPerformPresenter.getAuditPerformDetails();
        storeAuditPerformSubmitPresenter=new StoreAuditPerformSubmitPresenterImpl(this);
    }

    @OnClick({R.id.tv_unpass, R.id.tv_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_unpass:
                auditResult = GoodsAduitResultEnum.fail_aduit.getCode();
                break;
            case R.id.tv_pass:
                auditResult = GoodsAduitResultEnum.pass_aduit.getCode();
                break;
        }
        TipsDialog dialog = new TipsDialog(this);
        dialog.setTop("提醒");
        dialog.setTitle("提交审核通过以后，不可撤回，请确认是否继续提交审核通过");
        dialog.setBottomButton("确认提交", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                storeAuditPerformSubmitPresenter.submitAuditPerform();
            }
        });
        dialog.setTopButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void submitAuditPerformSuccess(StoreAuditPerformSubmitResultBean resultBean) {
        ToastUtils.showToastShort(this, "提交成功");
        StoreOrderAuditListActivity.isRefresh_Change = true;
        StoreOrderAuditPerformActivity.isRefresh_Change = true;
        finish();
    }

    @Override
    public void submitAuditPerformFail(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public void getStoreAuditPerformSuccess(StoreAuditPerformResultBean resultBean) {

    }

    @Override
    public void getStoreAuditPerformFail(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public Long getPerformId() {
        if (data.getGoodsPerform() != null)
            return data.getGoodsPerform().getId();
        else
            return null;
    }

    @Override
    public String getAuditInfo() {
        return etAuditContent.getText().toString();
    }

    @Override
    public Integer getAuditResult() {
        return auditResult;
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public void setAuditPerformPic(List<String> urls) {
        this.picUrls = urls;
        if (urls.size() == 0) {
            return;
        }
        if (urls.size() >= 1) {
            AppUtils.loadPic(this, ivPerformPic1, urls.get(0));
            ivPerformPic1.setOnClickListener(onClickListener);
        }
        if (urls.size() >= 2) {
            AppUtils.loadPic(this, ivPerformPic2, urls.get(1));
            ivPerformPic2.setOnClickListener(onClickListener);
        }
        if (urls.size() >= 3) {
            AppUtils.loadPic(this, ivPerformPic3, urls.get(2));
            ivPerformPic3.setOnClickListener(onClickListener);
        }


    }

    @Override
    public void setAuditPerformContent(String msg) {
        tvPerformContent.setText(msg);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == ivPerformPic1) {
                checkDetails(picUrls.get(0));
            } else if (v == ivPerformPic2) {
                checkDetails(picUrls.get(1));
            } else if (v == ivPerformPic3) {
                checkDetails(picUrls.get(2));
            }
        }
    };

    /**
     * 查看圖片詳情
     */
    private void checkDetails(String url) {
        new IntentUtils
                .Build(getContext(), ImagePreviewActivity.class)
                .setString(IntentUtils.INTENT_URL, url)
                .start();
    }
}
