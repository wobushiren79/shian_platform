package com.shianlife.shian_platform.custom.show.orderdetails;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    private String title;
    private String[] urls;

    public DetailsItemPicLayout(Context context, String title, String url) {
        super(context, R.layout.layout_details_item_pic);
        this.title = title;
        tvTitle.setText(title);
        urls = url.split(",");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        for (String url : urls) {
            addPic(url);
        }
    }


    private void addPic(final String url) {
        ImageView iv = new ImageView(getContext());
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentUtils.Build(getContext(), ImagePreviewActivity.class)
                        .setString(IntentUtils.INTENT_URL, Constants.QINIUURL + url)
                        .start();
            }
        });
        llContent.addView(iv);
        AppUtils.loadPic(getContext(), iv, url, R.drawable.zhy_details_def_pic);
    }
}
