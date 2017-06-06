package com.shianlife.shian_platform.custom.show;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class EditTextShowLayout extends BaseLayout implements ILayoutDataView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    EditText tvContent;
    @BindView(R.id.iv_map)
    ImageView ivMap;
    @BindView(R.id.tv_mileage)
    TextView tvMileage;

    //无
    public static final int NOTHING = 0;
    //里程模式
    public static final int MILEAGE = 1;
    //地图模式
    public static final int MAP = 2;

    private CallBack callBack;

    public EditTextShowLayout(Context context) {
        super(context, R.layout.layout_show_edittext);
    }

    public EditTextShowLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_show_edittext, attrs);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setTitle(titleName);
        setContent(contentText);
        setState(layoutType);
        setHintText(hintText);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 设置提示信息
     */
    private void setHintText(String hintText) {
        tvContent.setHint(hintText);
    }

    /**
     * 设置输入类型
     */
    public void setInputType(int inputType) {
        tvContent.setInputType(inputType);
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
     * 设置内容为粗体
     */
    public void setContentBold() {
        TextPaint tp = tvContent.getPaint();
        tp.setFakeBoldText(true);
    }

    /**
     * 设置是否可点击
     */
    public void setUncheck(boolean isCheck) {
        tvContent.setFocusable(isCheck);
    }

    /**
     * 设置布局状态
     *
     * @param state
     */
    @Override
    public void setState(int state) {
        switch (state) {
            case NOTHING:
                break;
            case MAP:
                ivMap.setVisibility(VISIBLE);
                break;
            case MILEAGE:
                tvMileage.setVisibility(VISIBLE);
                break;
        }
    }


    public String getData() {
        return tvContent.getText().toString();
    }

    @OnClick({R.id.tv_content, R.id.iv_map})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_content:
                if (callBack != null)
                    callBack.clickContent();
                break;
            case R.id.iv_map:
                if (callBack != null)
                    callBack.clickMap();
                break;
        }
    }


    public interface CallBack {
        void clickMap();

        void clickContent();
    }
}
