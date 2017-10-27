package com.shianlife.shian_platform.ui.activity;

import android.os.Bundle;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.ui.order.ordercenter.OrderCenterTabListLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderCenterAuditListActivity extends BaseActivity {

    public static boolean is_Refresh = false;
    @BindView(R.id.tab_list_view)
    OrderCenterTabListLayout tabListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_center_audit_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        setTitle("工单审核", BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (is_Refresh) {
            tabListView.refreshData();
        }
    }
}
