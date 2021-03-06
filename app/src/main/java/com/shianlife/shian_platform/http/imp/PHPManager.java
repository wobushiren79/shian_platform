package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseHttpParams;
import com.shianlife.shian_platform.http.base.HttpManager;
import com.shianlife.shian_platform.http.base.HttpResponseHandler;
import com.shianlife.shian_platform.http.phpresult.PHPHrGetHotIssue;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateBean;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;


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
    public void getAdvertisement(Context context, BaseHttpParams params, HttpResponseHandler<AdvertResultBean> handler);

    /**
     * 获取重要通知
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getDynamicInfo(Context context, BaseHttpParams params, HttpResponseHandler<DynamicResultBean> handler);


    /**
     * 获取收藏列表
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getSiftListData(Context context, BaseHttpParams params, HttpResponseHandler<FindResultBean> handler);


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
     *
     * @param context
     * @param params
     * @param handler
     */
    public void getVersion(Context context, AppUpDateBean params, HttpResponseHandler<AppUpDateResultBean> handler, boolean isDialog);
}
