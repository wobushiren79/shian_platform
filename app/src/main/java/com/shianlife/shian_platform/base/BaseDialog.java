package com.shianlife.shian_platform.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class BaseDialog extends Dialog {

    protected TextView tvTop;
    protected LinearLayout llContent;
    protected TextView tvBtn1;
    protected TextView tvBtn2;

    protected DisplayMetrics outMetrics;
    protected View view;

    protected View mViewItem;
    protected String mTopText = "确认提交？";
    protected String mBtn1Text;
    protected String mBtn2Text;

    protected OnClickListener topClickListener;
    protected OnClickListener bottomClickListener;

    boolean isBtn1V = false;
    boolean isBtn2V = false;

    public BaseDialog(Context context) {
        super(context, R.style.tipsDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_base, null);
        setContentView(view);
        initView();
        initData();
    }

    private void initView() {

        llContent = (LinearLayout) view.findViewById(R.id.ll_content);
        tvBtn1 = (TextView) view.findViewById(R.id.tv_btn1);
        tvBtn2 = (TextView) view.findViewById(R.id.tv_btn2);
        tvTop = (TextView) view.findViewById(R.id.tv_top);
        tvBtn1.setOnClickListener(onClickListener);
        tvBtn2.setOnClickListener(onClickListener);
    }

    private void initData() {
        if (isBtn1V)
            tvBtn1.setVisibility(View.VISIBLE);
        if (isBtn2V)
            tvBtn2.setVisibility(View.VISIBLE);
        tvTop.setText(mTopText);
        tvBtn1.setText(mBtn1Text);
        tvBtn2.setText(mBtn2Text);
    }


    /**
     * 设置标题栏
     *
     * @param view
     */
    public void setView(View view) {
        this.mViewItem = view;
        llContent.addView(mViewItem);
    }

    /**
     * 设置头
     *
     * @param top
     */
    public void setTop(String top) {
        this.mTopText = top;
    }

    /**
     * 设置按钮1
     *
     * @param text
     * @param onClickListener
     */
    public void setTopButton(String text, OnClickListener onClickListener) {
        isBtn1V = true;
        mBtn1Text = text;
        tvBtn1.setText(mBtn1Text);
        topClickListener = onClickListener;
    }

    /**
     * 设置按钮2
     *
     * @param text
     * @param onClickListener
     */
    public void setBottomButton(String text, OnClickListener onClickListener) {
        isBtn2V = true;
        mBtn2Text = text;
        tvBtn2.setText(mBtn2Text);
        bottomClickListener = onClickListener;
    }


    void topClick() {
        if (topClickListener != null) {
            topClickListener.onClick(this, 0);
        }
    }

    void bottomClick() {
        if (bottomClickListener != null) {
            bottomClickListener.onClick(this, 0);
        }
    }

    @Override
    public void show() {
        super.show();
        outMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = (int) (outMetrics.widthPixels * 0.67);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == tvBtn1) {
                topClick();
            } else if (v == tvBtn2) {
                bottomClick();
            }
        }
    };
}
