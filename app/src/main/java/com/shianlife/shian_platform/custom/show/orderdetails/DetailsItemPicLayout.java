package com.shianlife.shian_platform.custom.show.orderdetails;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.ui.activity.ImagePreviewActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class DetailsItemPicLayout extends BaseLayout {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_pic)
    ImageView ivPic;

    private String title;
    private String url;

    public DetailsItemPicLayout(Context context, String title, String url) {
        super(context, R.layout.layout_details_item_pic);
        this.title = title;
        this.url = url;
        tvTitle.setText(title);
        AppUtils.loadPic(getContext(), ivPic, url, R.drawable.zhy_details_def_pic);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.iv_pic)
    public void onViewClicked() {
        new IntentUtils.Build(getContext(), ImagePreviewActivity.class)
                .setString(IntentUtils.INTENT_URL, Constants.QINIUURL + url)
                .start();

    }
}
