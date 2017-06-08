package com.shianlife.shian_platform.custom.show.orderdetails;

import android.content.Context;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class DetailsItemTextLayout extends BaseLayout {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;

    public DetailsItemTextLayout(Context context, String title, String content) {
        super(context, R.layout.layout_details_item_text);
        tvTitle.setText(title);
        tvContent.setText(content);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
