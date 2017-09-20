package com.shianlife.shian_platform.base;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.common.local.LocationService;
import com.shianlife.shian_platform.http.base.SSLSocketFactoryCompat;
import com.zhy.http.okhttp.OkHttpUtils;

import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
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
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            builder.sslSocketFactory(sslSocketFactory, trustAllCert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        OkHttpClient okHttpClient = builder.connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .followRedirects(true)
                .followSslRedirects(true)
                .cookieJar(new LocalCookieJar())
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    //CookieJar是用于保存Cookie的
    class LocalCookieJar implements CookieJar {
        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            String tempUrl = getBaseUrl(url.toString());
            Constants.cookieStore.put(tempUrl, cookies);
            //新增添加子系统KEY
            if (tempUrl.contains(Constants.Login_BaseUrl) && cookies.size() >= 2) {
                String setCookies = cookies.get(1).toString();
                String[] cookiesList = setCookies.split(";");
                for (String cookie : cookiesList) {
                    if (cookie.contains("KI4SO_SERVER_EC")) {
                        Constants.System_Ki4so_Client_Ec = cookie;
                    }
                }
            }
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            String tempUrl = getBaseUrl(url.toString());
            List<Cookie> cookies = Constants.cookieStore.get(tempUrl);
            return cookies != null ? cookies : new ArrayList<Cookie>();
        }

        private String getBaseUrl(String url) {
            String temp = "";
            if (url.contains("https") || url.contains("http://prd")) {
                int hostLocation = url.indexOf("/", 8);
                temp = url.substring(0, hostLocation);
            } else {
                int hostLocation = url.indexOf("/", 8);
                int urlLocation = url.indexOf("/", hostLocation + 1);
                if (urlLocation != -1)
                    temp = url.substring(0, urlLocation);
            }
            return temp;
        }
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
