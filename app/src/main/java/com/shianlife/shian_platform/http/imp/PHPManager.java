package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.HttpManager;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.phpparams.HpGetVersion;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetAdvertisement;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetDynamic;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetHotIssue;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetSiftListData;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetVersion;


/**
 * Created by Administrator on 2017/3/4.
 */

public interface PHPManager extends HttpManager {


    /**
     * 获取广告
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getAdvertisement(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetAdvertisement> handler);

    /**
     * 获取重要通知
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getDynamicInfo(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetDynamic> handler);


    /**
     * 获取收藏列表
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getSiftListData(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetSiftListData> handler);


    /**
     * 点赞与收藏接口
     *
     * @param context
     * @param params
     */
    public void setSiftData(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler);

    /**
     * 获取热门问题
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getHotIssue(Context context, BaseHttpParams params, HttpResponseHandler<PHPHrGetHotIssue> handler);


    /**
     * 用户意见接口
     *
     * @param context
     * @param params
     * @param handler
     */
    public void setOpinion(Context context, BaseHttpParams params, HttpResponseHandler<Object> handler, boolean isDialog);

    /**
     * 获取版本号
     * @param context
     * @param params
     * @param handler
     */
    public void getVersion(Context context, HpGetVersion params, HttpResponseHandler<PHPHrGetVersion> handler, boolean isDialog);
}
