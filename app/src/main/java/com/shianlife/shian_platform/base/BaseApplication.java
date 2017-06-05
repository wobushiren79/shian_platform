package com.shianlife.shian_platform.base;

import android.app.Activity;
import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by zm.
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication = null;
    List<Activity> listActivity = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttp();
    }

    /**
     * 单例
     *
     * @return
     */
    public static BaseApplication getApplication() {
        if (baseApplication == null) {
            baseApplication = new BaseApplication();
        }
        return baseApplication;
    }

    /**
     * 初始化Okhttp
     */
    private void initOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    /**
     * acitivity关闭时候，删除activity列表中的activity对象
     */
    public void removeActivity(Activity a) {
        listActivity.remove(a);
    }

    /**
     * 向activiy列表中添加对象
     */
    public void addActivity(Activity a) {
        listActivity.add(a);
    }

    /**
     * 退出APP
     */
    public void exitAPP() {
        for (int i = 0; i < listActivity.size(); i++) {
            listActivity.get(i).finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
