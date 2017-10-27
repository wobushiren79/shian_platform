package com.shianlife.shian_platform.ui.order.ordercenter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.WorkOrderAuditStatusEnum;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.custom.show.ImageUpLoadShowLayout;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.IOrderCenterSubmitAuditPresenter;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.impl.OrderCenterSubmitAuditPresenterImpl;
import com.shianlife.shian_platform.mvp.ordercenter.view.IOrderCenterSubmitAuditView;
import com.shianlife.shian_platform.ui.activity.OrderCenterAuditListActivity;
import com.shianlife.shian_platform.utils.CheckUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class OrderCenterAuditSubmitLayout extends BaseLayout implements View.OnClickListener, IOrderCenterSubmitAuditView {
    @BindView(R.id.layout_image_upload)
    ImageUpLoadShowLayout imageUpLoadShowLayout;
    @BindView(R.id.et_submit_content)
    EditText etSubmitContent;
    @BindView(R.id.tv_submit_nopass)
    TextView tvSubmitNopass;
    @BindView(R.id.tv_submit_pass)
    TextView tvSubmitPass;

    private String fileClass;
    private Long orderId;
    private IOrderCenterSubmitAuditPresenter orderCenterSubmitAuditPresenter;

    public OrderCenterAuditSubmitLayout(Context context) {
        this(context, null);
    }

    public OrderCenterAuditSubmitLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_order_center_submit, attrs);
    }

    @Override
    protected void initView() {
        fileClass = "order/workorder";

        tvSubmitNopass.setOnClickListener(this);
        tvSubmitPass.setOnClickListener(this);

        imageUpLoadShowLayout.setTitle("提交图片");
        imageUpLoadShowLayout.setBaseData(fileClass);
    }

    @Override
    protected void initData() {
        orderCenterSubmitAuditPresenter = new OrderCenterSubmitAuditPresenterImpl(this);
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public void onClick(View v) {
        if (imageUpLoadShowLayout.isUpLoading()) {
            ToastUtils.showToastShort(getContext(), "图片上传中。。。");
            return;
        }
        if (v == tvSubmitNopass) {
            submitNoPass();
        } else if (v == tvSubmitPass) {
            submitPass();
        }
    }

    /**
     * 不通过
     */
    private void submitNoPass() {
        orderCenterSubmitAuditPresenter.submitAudit(WorkOrderAuditStatusEnum.no_pass.getCode());
    }

    /**
     * 通过
     */
    private void submitPass() {
        orderCenterSubmitAuditPresenter.submitAudit(WorkOrderAuditStatusEnum.pass.getCode());
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToastShort(getContext(), msg);
    }

    @Override
    public void submitOrderCenterAuditSuccess(OrderCenterSubmitAuditResultBean resultBean) {
        ToastUtils.showToastShort(getContext(), "提交成功");
        OrderCenterAuditListActivity.is_Refresh = true;
        CheckUtils.scanForActivity(getContext()).finish();
    }

    @Override
    public void submitOrderCenterAuditFail(String msg) {
        ToastUtils.showToastShort(getContext(), msg);
    }

    @Override
    public Long getOrderId() {
        return orderId;
    }

    @Override
    public String getAuditSummary() {
        return etSubmitContent.getText().toString();
    }

    @Override
    public String getAuditPic() {
        return imageUpLoadShowLayout.getDataString();
    }


}
