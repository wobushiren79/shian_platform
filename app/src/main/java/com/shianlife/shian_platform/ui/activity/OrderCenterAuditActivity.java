package com.shianlife.shian_platform.ui.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.ui.order.ordercenter.OrderCenterAuditSubmitLayout;

public class OrderCenterAuditActivity extends OrderCenterDetailsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    private void init() {
        setTitle("工单审核", BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        addSubmitLayout();
    }


    private void addSubmitLayout() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int dpmargin = getResources().getDimensionPixelOffset(R.dimen.dimen_16dp);
        layoutParams.topMargin = dpmargin;
        OrderCenterAuditSubmitLayout layout = new OrderCenterAuditSubmitLayout(this);
        layout.setOrderId(orderId);
        layout.setLayoutParams(layoutParams);


        llContent.addView(layout);
    }

}
