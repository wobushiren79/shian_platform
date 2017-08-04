package com.shianlife.shian_platform.base;

import android.app.Activity;
import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.shianlife.shian_platform.common.local.LocationService;
import com.shianlife.shian_platform.http.base.CustomCookieStore;
import com.shianlife.shian_platform.http.base.SSLSocketFactoryCompat;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.net.CookieManager;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * Created by zm.
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication = null;
    List<Activity> listActivity = new ArrayList<>();
    public LocationService locationService;

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttp();
        initMap();
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
     * 初始化地图
     */
    private void initMap() {
        /***
         * 初始化定位sdk，建议在Application中创建
         */        //百度地图初始化
        locationService = new LocationService(getApplicationContext());
        SDKInitializer.initialize(getApplicationContext());
    }

    /**
     * 初始化Okhttp
     */
    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                .addInterceptor(new LoggerInterceptor("TAG"));
        try {
            // 自定义一个信任所有证书的TrustManager，添加SSLSocketFactory的时候要用到
            final X509TrustManager trustAllCert =
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    };
            final SSLSocketFactory sslSocketFactory = new SSLSocketFactoryCompat(trustAllCert);
            builder.sslSocketFactory(sslSocketFactory, trustAllCert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CookieJarImpl cookieJar = new CookieJarImpl(new CustomCookieStore(getApplicationContext()));
        OkHttpClient okHttpClient = builder.connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .followRedirects(true)
                .followSslRedirects(true)
                .cookieJar(cookieJar)
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
