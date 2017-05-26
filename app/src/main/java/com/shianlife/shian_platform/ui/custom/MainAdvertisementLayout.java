package com.shianlife.shian_platform.ui.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.AdvertisementEnum;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;
import com.shianlife.shian_platform.mvp.advert.presenter.IAdvertPresenter;
import com.shianlife.shian_platform.mvp.advert.presenter.impl.AdvertPresenterImpl;
import com.shianlife.shian_platform.mvp.advert.view.IAdvertView;
import com.shianlife.shian_platform.ui.activity.WebActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class MainAdvertisementLayout extends BaseLayout implements IAdvertView {
    @BindView(R.id.iv_content)
    ImageView ivContent;
    @BindView(R.id.bt_cancel)
    Button btCancel;

    private IAdvertPresenter advertPresenter;
    private AdvertResultBean data;
    private int advertisementType;

    public MainAdvertisementLayout(Context context) {
        this(context, null);
    }

    public MainAdvertisementLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_mainadvertisement, attrs);

    }

    @Override
    protected void initData() {
        advertPresenter = new AdvertPresenterImpl(this);

    }

    public void setType(int type) {
        advertisementType = type;
        advertPresenter.getAdvertData();
    }

    @Override
    protected void initView() {

    }

    @Override
    public int getAdvertType() {
        return advertisementType;
    }

    @Override
    public int getPagerSize() {
        return 1;
    }

    @Override
    public int getPagerNum() {
        return 0;
    }

    @Override
    public void showData(BaseDataResult result) {
        data = (AdvertResultBean) result;
        AppUtils.loadPic(getContext(), ivContent, Constants.PHP_URL + data.getItems().get(0).getBanner(), drawableRequestListener);
        MainAdvertisementLayout.this.setVisibility(VISIBLE);
    }

    @Override
    public void showMsg(String msg) {

    }

    /**
     * 图片加载监听
     */
    RequestListener<String, GlideDrawable> drawableRequestListener = new RequestListener<String, GlideDrawable>() {
        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            MainAdvertisementLayout.this.setVisibility(VISIBLE);
            return false;
        }
    };

    @OnClick({R.id.iv_content, R.id.bt_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_content:
                new IntentUtils.Build(getContext(), WebActivity.class)
                        .setData(IntentUtils.INTENT_URL, data.getItems().get(0).getUrl())
                        .start();
                break;
            case R.id.bt_cancel:
                this.setVisibility(GONE);
                break;
        }
    }
}
