package com.shianlife.shian_platform.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;

public class OrderCenterAuditActivity extends OrderCenterDetailsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_center_audit);
        init();
    }


    private void init() {
        setTitle("工单审核", BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }


}
