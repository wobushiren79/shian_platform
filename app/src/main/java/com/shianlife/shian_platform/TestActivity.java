package com.shianlife.shian_platform;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shianlife.shian_platform.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity {
    @BindView(R.id.iv_test)
    ImageView ivTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        Glide
                .with(this)
                .load("http://oq6rkq859.bkt.clouddn.com/ceshi2/20170522102456/d0f8543178d241659052d670927480f1.jpg")
                .into(ivTest);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
