package com.shianlife.shian_platform.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollRecyclerView;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class CustomerHelpActivity extends BaseActivity {

    @BindView(R.id.ll_linehelp)
    LinearLayout llLinehelp;
    @BindView(R.id.ll_phonehelp)
    LinearLayout llPhonehelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_help);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_help), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        AppUtils.call(llPhonehelp, Constants.helpPhone);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ll_linehelp, R.id.ll_phonehelp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_linehelp:
                ToastUtils.showToastShort(CustomerHelpActivity.this, getString(R.string.customerhelp_state_1));
                break;
//            case R.id.ll_phonehelp:
//                AppUtils.call(view, "4009679678");
//                break;

        }
    }
}
