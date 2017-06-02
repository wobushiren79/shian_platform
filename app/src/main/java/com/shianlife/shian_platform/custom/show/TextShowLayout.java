package com.shianlife.shian_platform.custom.show;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class TextShowLayout extends BaseLayout implements ILayoutDataView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_orderstate)
    TextView tvOrderstate;
    @BindView(R.id.iv_remark)
    ImageView ivRemark;
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.iv_map)
    ImageView ivMap;

    //无
    public static final int NOTHING = 0;
    //状态模式
    public static final int STATE = 1;
    //手机模式
    public static final int PHONE = 2;
    //地图模式
    public static final int MAP = 3;
    //备注模式
    public static final int REMARK = 4;

    private CallBack callBack;

    public TextShowLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_show_text, attrs);
    }

    public TextShowLayout(Context context) {
        super(context, R.layout.layout_show_text);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setTitle(titleName);
        setContent(contentText);
        setState(layoutType);

    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 设置标题
     *
     * @param name
     */
    public void setTitle(String name) {
        tvTitle.setText(name);
    }

    /**
     * 设置内容
     *
     * @param content
     */
    public void setContent(String content) {
        tvContent.setText(content);
    }


    /**
     * 设置状态文字
     *
     * @param name
     */
    public void setStateText(String name) {
        tvOrderstate.setText(name);
    }

    /**
     * 设置内容为粗体
     */
    public void setContentBold() {
        TextPaint tp = tvContent.getPaint();
        tp.setFakeBoldText(true);
    }

    /**
     * 设置类型
     *
     * @param state
     */
    public void setState(int state) {
        switch (state) {
            case NOTHING:
                break;
            case MAP:
                ivMap.setVisibility(VISIBLE);
                break;
            case REMARK:
                ivRemark.setVisibility(VISIBLE);
                break;
            case PHONE:
                ivPhone.setVisibility(VISIBLE);
                break;
            case STATE:
                tvOrderstate.setVisibility(VISIBLE);
                break;
        }

    }

    @OnClick({R.id.iv_remark, R.id.iv_phone, R.id.iv_map})
    public void onViewClicked(View view) {
        if (callBack != null) {
            switch (view.getId()) {
                case R.id.iv_remark:
                    callBack.clickRemark(this);
                    break;
                case R.id.iv_phone:
                    callBack.clickPhone(this);
                    break;
                case R.id.iv_map:
                    callBack.clickMap(this);
                    break;
            }
        }
    }

    public interface CallBack {
        void clickRemark(View view);

        void clickPhone(View view);

        void clickMap(View view);
    }
}
