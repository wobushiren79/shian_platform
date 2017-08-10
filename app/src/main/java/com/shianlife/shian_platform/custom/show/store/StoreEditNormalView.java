package com.shianlife.shian_platform.custom.show.store;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;

import butterknife.BindView;


/**
 * Created by zm.
 */

public class StoreEditNormalView extends BaseLayout {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_content)
    EditText etContent;


    public StoreEditNormalView(Context context) {
        super(context, R.layout.layout_store_edit_normal_view);
    }

    public StoreEditNormalView(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_store_edit_normal_view, attrs);
    }


    @Override
    protected void initView() {
        tvTitle.setText(titleName);
        etContent.setText(contentText);
        etContent.setHint(hintText);
        setEnabled(!showMode);
    }

    @Override
    protected void initData() {
    }

    public void setData(String data) {
        etContent.setText(data);
    }

    public String getData() {
        return etContent.getText().toString();
    }

    /**
     * 设置编辑状态
     *
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        etContent.setEnabled(enabled);
        if (enabled) {
            etContent.setGravity(Gravity.CENTER_VERTICAL );
        } else {
            etContent.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        }
    }


}
