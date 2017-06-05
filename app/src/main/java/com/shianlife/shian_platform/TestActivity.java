package com.shianlife.shian_platform;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.view.fileupload.FileUpLoadButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity {
    @BindView(R.id.ll_content)
    RelativeLayout llContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

    }

    @Override
    protected void initView() {
        llContent.addView(new FileUpLoadButton(this, "testClass", "testName"));
    }

    @Override
    protected void initData() {

    }
}
