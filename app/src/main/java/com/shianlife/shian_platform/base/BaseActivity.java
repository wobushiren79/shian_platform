package com.shianlife.shian_platform.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.custom.title.BackNormalTitle;
import com.shianlife.shian_platform.custom.title.NormalTitle;
import com.shianlife.shian_platform.utils.AppUtils;

import butterknife.ButterKnife;


/**
 * Created by zm.
 */

public abstract class BaseActivity extends FragmentActivity {

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
    public void setTitle(String titleName, int titleType) {
        rlHead.removeAllViews();
        rlHead.setVisibility(View.VISIBLE);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (titleType == BaseTitleEnum.NORMALTITLE.getTitleType()) {
            //添加普通标题栏
            addNormalTitle(titleName, layoutParams);
        } else if (titleType == BaseTitleEnum.BACKNORMALTITLE.getTitleType()) {
            addBackTitle(titleName, layoutParams);
        } else {
            rlHead.setVisibility(View.GONE);
        }
    }

    /**
     * @param titleName
     * @param layoutParams
     */
    private void addBackTitle(String titleName, RelativeLayout.LayoutParams layoutParams) {
        BackNormalTitle backNormalTitle = new BackNormalTitle(BaseActivity.this);
        backNormalTitle.setLayoutParams(layoutParams);
        backNormalTitle.setTitle(titleName);
        rlHead.addView(backNormalTitle);
    }


    /**
     * 添加普通通标题
     *
     * @param titleName
     * @param layoutParams
     */
    private void addNormalTitle(String titleName, RelativeLayout.LayoutParams layoutParams) {
        NormalTitle normalTitle = new NormalTitle(BaseActivity.this);
        normalTitle.setLayoutParams(layoutParams);
        normalTitle.setTitle(titleName);
        rlHead.addView(normalTitle);
    }

    /**
     * 隐藏标题栏
     */
    public void setTitleVisible(int visible) {
        rlHead.setVisibility(visible);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BaseApplication) getApplicationContext()).removeActivity(this);
    }

    protected abstract void initView();

    protected abstract void initData();
}
