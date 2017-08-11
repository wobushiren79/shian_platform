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
        BaseUrl = Constants.PHP_BaseUrl;
    }

    public static PHPManager getInstance() {
        if (manager == null) {
            manager = new PHPManagerImpl();
        }
        return manager;
    }

    @Override
    protected <T> void requestPost(Context context,
                                   String method,
                                   Class<T> cls,
                                   BaseHttpParams params,
                                   HttpResponseHandler<T> response) {
        excutor.requestGet(context, method, cls, params, response, false, BaseUrl, null);
    }

    @Override
    protected <T> void requestPost(Context context,
                                   String method,
                                   Class<T> cls,
                                   BaseHttpParams params,
                                   HttpResponseHandler<T> response,
                                   boolean isDialog) {
        excutor.requestGet(context, method, cls, params, response, isDialog, BaseUrl, null);
    }

    @Override
    public void getAdvertisement(Context context, BaseHttpParams params, HttpResponseHandler<AdvertResultBean> handler) {
        requestPost(context, "Home/index/advertising", AdvertResultBean.class,
                params, handler, false);
    }

    @Override
    public void getDynamicInfo(Context context, BaseHttpParams params, HttpResponseHandler<DynamicResultBean> handler) {
        requestPost(context, "Home/index/dynamic", DynamicResultBean.class,
                params, handler, false);
    }

    @Override
    public void getSiftListData(Context context, BaseHttpParams params, HttpResponseHandler<FindResultBean> handler) {
        requestPost(context, "Home/index/sift", FindResultBean.class,
                params, handler, false);
    }

    @Override
    public void setSiftData(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler) {
        requestPost(context, "Home/index/siftuser", Object.class,
                params, handler, false);
    }

    @Override
    public void getHotIssue(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetHotIssue> handler) {
        requestPost(context, "Home/index/help", PHPHrGetHotIssue.class,
                params, handler, false);
    }

    @Override
    public void setOpinion(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler, boolean isDialog) {
        requestPost(context, "Home/index/opinion", Object.class,
                params, handler, isDialog);
    }

    @Override
    public void getVersion(Context context, AppUpDateBean params, HttpResponseHandler<AppUpDateResultBean> handler, boolean isDialog) {
        requestPost(context, "Home/index/edition", AppUpDateResultBean.class,
                params, handler, isDialog);
    }

}
