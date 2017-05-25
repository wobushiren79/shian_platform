package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.FindDataEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.find.presenter.IFindDataPresenter;
import com.shianlife.shian_platform.mvp.find.presenter.impl.FindDataPresenterImpl;
import com.shianlife.shian_platform.mvp.find.view.IFindDataView;
import com.shianlife.shian_platform.utils.IntentUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class WebActivity extends BaseActivity implements IFindDataView {

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.iv_cancel)
    ImageView ivCancel;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.myProgressBar)
    ProgressBar myProgressBar;
    @BindView(R.id.web)
    WebView webView;
    @BindView(R.id.iv_collection)
    ImageView ivCollection;


    String url = "";
    boolean isCollection;
    FindResultBean.SiftListData data;
    IFindDataPresenter dataPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initWebView();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        url = getIntent().getStringExtra(IntentUtils.INTENT_URL);
        dataPresenter = new FindDataPresenterImpl(this);
        openCollection();
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setGeolocationDatabasePath(getFilesDir().getPath());
        webSettings.setDomStorageEnabled(true);//允许DCOM

        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    myProgressBar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == myProgressBar.getVisibility()) {
                        myProgressBar.setVisibility(View.VISIBLE);
                    }
                    myProgressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                tvTitle.setText(title);
            }


            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                view.loadUrl(url);
                return true;
            }
        });
    }

    @OnClick({R.id.tv_back, R.id.iv_cancel, R.id.iv_share, R.id.iv_collection})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                webView.goBack();
                break;
            case R.id.iv_cancel:
                finish();
                break;
            case R.id.iv_share:
                share();
                break;
            case R.id.iv_collection:
                ivCollection.setImageResource(R.drawable.zhy_find_collection_2);
                ivCollection.setClickable(false);
                dataPresenter.saveData(FindDataEnum.COLLECTION.getCode(), data.getId());
                break;
        }
    }


    private void share() {
        // intent.setType("text/plain"); //纯文本
            /*
             * 图片分享 it.setType("image/png"); 　//添加图片 File f = new
             * File(Environment.getExternalStorageDirectory()+"/name.png");
             *
             * Uri uri = Uri.fromFile(f); intent.putExtra(Intent.EXTRA_STREAM,
             * uri); 　
             */
//        if (data == null) {
//            return;
//        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void changeSuccess() {

    }

    @Override
    public void changeFail(String msg) {

    }

    @Override
    public int getChangeType() {
        return 0;
    }

    @Override
    public int getSiftid() {
        return 0;
    }

    /**
     * 是否要开启收藏功能
     */
    private void openCollection() {
        isCollection = getIntent().getBooleanExtra(IntentUtils.INTENT_ISCOLLECTION, false);
        if (isCollection) {
            ivCollection.setVisibility(View.VISIBLE);
            data = (FindResultBean.SiftListData) getIntent().getSerializableExtra(IntentUtils.INTENT_SHAREDATA);
            if (data.getIsCollection() == 0) {
                ivCollection.setImageResource(R.drawable.zhy_find_collection_1);
            } else {
                ivCollection.setImageResource(R.drawable.zhy_find_collection_2);
                ivCollection.setClickable(false);
            }
        } else {
            ivCollection.setVisibility(View.GONE);
        }
    }
}
