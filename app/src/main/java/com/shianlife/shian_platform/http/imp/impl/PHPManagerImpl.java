package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.HttpRequestExecutor;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.imp.PHPManager;
import com.shianlife.shian_platform.http.phpparams.HpGetVersion;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetAdvertisement;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetDynamic;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetHotIssue;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetSiftListData;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetVersion;


/**
 * Created by Administrator on 2017/3/4.
 */

public class PHPManagerImpl implements PHPManager {
    public HttpRequestExecutor excutor = new HttpRequestExecutor();
    private static PHPManager manager;

    private PHPManagerImpl() {
    }

    public static PHPManager getInstance() {
        if (manager == null) {
            manager = new PHPManagerImpl();
        }
        return manager;
    }


    @Override
    public void getAdvertisement(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetAdvertisement> handler) {
        excutor.requestPHPGet(context, "Home/index/advertising", PHPHrGetAdvertisement.class,
                params, handler, false);
    }

    @Override
    public void getDynamicInfo(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetDynamic> handler) {
        excutor.requestPHPGet(context, "Home/index/dynamic", PHPHrGetDynamic.class,
                params, handler, false);
    }

    @Override
    public void getSiftListData(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetSiftListData> handler) {
        excutor.requestPHPGet(context, "Home/index/sift", PHPHrGetSiftListData.class,
                params, handler, false);
    }

    @Override
    public void setSiftData(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler) {
        excutor.requestPHPGet(context, "Home/index/siftuser", Object.class,
                params, handler, false);
    }

    @Override
    public void getHotIssue(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetHotIssue> handler) {
        excutor.requestPHPGet(context, "Home/index/help", PHPHrGetHotIssue.class,
                params, handler, false);
    }

    @Override
    public void setOpinion(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler, boolean isDialog) {
        excutor.requestPHPGet(context, "Home/index/opinion", Object.class,
                params, handler, isDialog);
    }

    @Override
    public void getVersion(Context context, HpGetVersion params, HttpResponseHandler<PHPHrGetVersion> handler, boolean isDialog) {
        excutor.requestPHPGet(context, "Home/index/edition", PHPHrGetVersion.class,
                params, handler, isDialog);
    }

}
