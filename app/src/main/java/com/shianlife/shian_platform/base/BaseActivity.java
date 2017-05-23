package com.shianlife.shian_platform.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by zm.
 */

public abstract class BaseActivity extends Activity {

    public DisplayMetrics metrics = new DisplayMetrics();

    RelativeLayout rlHead;
    FrameLayout flBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(R.layout.activity_base);

        rlHead = (RelativeLayout) findViewById(R.id.rl_head);
        flBase = (FrameLayout) findViewById(R.id.fl_base);

        ((BaseApplication) getApplicationContext()).addActivity(this);
        //设置状态栏颜色
        AppUtils.setWindowStatusBarColor(this, R.color.zhy_title_color_1);
        //获取屏幕高宽
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void setContentView(int layoutResID) {
        View v = LayoutInflater.from(this).inflate(layoutResID, null);
        flBase.addView(v, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void setContentView(View view) {
        // TODO Auto-generated method stub
        flBase.addView(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    /**
     * 设置标题
     *
     * @param titleName
     */
    public void setTitle(String titleName) {
        rlHead.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BaseApplication) getApplicationContext()).removeActivity(this);
    }

    protected abstract void initView();

    protected abstract void initData();
}
