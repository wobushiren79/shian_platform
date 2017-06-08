package com.shianlife.shian_platform.custom.show.orderdetails;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class DetailsLayout extends BaseLayout {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_content)
    LinearLayout llContent;


    public DetailsLayout(Context context) {
        super(context, R.layout.layout_details_item);
    }

    public DetailsLayout(Context context, String title) {
        super(context, R.layout.layout_details_item);
        setTitle(title);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    /**
     * 設置
     *
     * @param name
     */
    public void setTitle(String name) {
        tvTitle.setText(name);
    }

    /**
     * 添加普通文本佈局
     *
     * @param titleName
     * @param content
     */
    public void addTextView(String titleName, String content) {
        DetailsItemTextLayout textLayout = new DetailsItemTextLayout(getContext(), titleName, content);
        llContent.addView(textLayout);
    }

    /**
     * 添加图片文本布局
     *
     * @param titleName
     * @param picUrl
     */
    public void addPicView(String titleName, String picUrl) {
        DetailsItemPicLayout picLayout = new DetailsItemPicLayout(getContext(), titleName, picUrl);
        llContent.addView(picLayout);
    }
}
