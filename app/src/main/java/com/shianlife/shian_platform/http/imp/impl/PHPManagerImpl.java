package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.BaseManagerImpl;
import com.shianlife.shian_platform.http.base.HttpRequestExecutor;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.PHPManager;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetHotIssue;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateBean;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;


/**
 * Created by Administrator on 2017/3/4.
 */

public class PHPManagerImpl extends BaseManagerImpl implements PHPManager {
    private static PHPManager manager;

    private PHPManagerImpl() {
        super();
        baseUrl = Constants.PHP_BaseUrl;
    }

    public static PHPManager getInstance() {
        if (manager == null) {
            manager = new PHPManagerImpl();
        }
        return manager;
    }



    @Override
    public void getAdvertisement(Context context, BaseHttpParams params, HttpResponseHandler<AdvertResultBean> handler) {
        requestGet(context, "Home/index/advertising", AdvertResultBean.class,
                params, handler, false);
    }

    @Override
    public void getDynamicInfo(Context context, BaseHttpParams params, HttpResponseHandler<DynamicResultBean> handler) {
        requestGet(context, "Home/index/dynamic", DynamicResultBean.class,
                params, handler, false);
    }

    @Override
    public void getSiftListData(Context context, BaseHttpParams params, HttpResponseHandler<FindResultBean> handler) {
        requestGet(context, "Home/index/sift", FindResultBean.class,
                params, handler, false);
    }

    @Override
    public void setSiftData(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler) {
        requestGet(context, "Home/index/siftuser", Object.class,
                params, handler, false);
    }

    @Override
    public void getHotIssue(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetHotIssue> handler) {
        requestGet(context, "Home/index/help", PHPHrGetHotIssue.class,
                params, handler, false);
    }

    @Override
    public void setOpinion(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler, boolean isDialog) {
        requestGet(context, "Home/index/opinion", Object.class,
                params, handler, isDialog);
    }

    @Override
    public void getVersion(Context context, AppUpDateBean params, HttpResponseHandler<AppUpDateResultBean> handler, boolean isDialog) {
        requestGet(context, "Home/index/edition", AppUpDateResultBean.class,
                params, handler, isDialog);
    }

}
