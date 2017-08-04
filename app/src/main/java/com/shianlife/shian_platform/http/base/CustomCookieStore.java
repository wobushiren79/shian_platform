package com.shianlife.shian_platform.http.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.CookieStore;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.cookie.store.SerializableHttpCookie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by zm.
 */

public class CustomCookieStore extends PersistentCookieStore {

    private final HashMap<String, ConcurrentHashMap<String, Cookie>> cookies;
    private final SharedPreferences cookiePrefs;

    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_PREFS = "CookiePrefsFile";


    /**
     * Construct a persistent cookie store.
     *
     * @param context Context to attach cookie store to
     */
    public CustomCookieStore(Context context) {
        super(context);
        cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
        cookies = new HashMap<String, ConcurrentHashMap<String, Cookie>>();

        // Load any previously stored cookies into the store
        Map<String, ?> prefsMap = cookiePrefs.getAll();
        for (Map.Entry<String, ?> entry : prefsMap.entrySet()) {
            if (((String) entry.getValue()) != null && !((String) entry.getValue()).startsWith(COOKIE_NAME_PREFIX)) {
                String[] cookieNames = TextUtils.split((String) entry.getValue(), ",");
                for (String name : cookieNames) {
                    String encodedCookie = cookiePrefs.getString(COOKIE_NAME_PREFIX + name, null);
                    if (encodedCookie != null) {
                        Cookie decodedCookie = decodeCookie(encodedCookie);
                        if (decodedCookie != null) {
                            if (!cookies.containsKey(entry.getKey()))
                                cookies.put(entry.getKey(), new ConcurrentHashMap<String, Cookie>());
                            cookies.get(entry.getKey()).put(name, decodedCookie);
                        }
                    }
                }

            }
        }
    }

    @Override
    public void add(HttpUrl uri, List<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            add(uri, cookie);
        }
    }


    protected void add(HttpUrl uri, Cookie cookie) {
        String name = getCookieToken(cookie);

        if (!cookie.persistent()) {
            if (!cookies.containsKey(getCustomUrl(uri.toString()))) {
                cookies.put(getCustomUrl(uri.toString()), new ConcurrentHashMap<String, Cookie>());
            }
            cookies.get(getCustomUrl(uri.toString())).put(name, cookie);
        } else {
            if (cookies.containsKey(getCustomUrl(uri.toString()))) {
                cookies.get(getCustomUrl(uri.toString())).remove(name);
            } else {
                return;
            }
        }

        // Save cookie into persistent store
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        prefsWriter.putString(getCustomUrl(uri.toString()), TextUtils.join(",", cookies.get(getCustomUrl(uri.toString())).keySet()));
        prefsWriter.putString(COOKIE_NAME_PREFIX + name, encodeCookie(new SerializableHttpCookie(cookie)));
        prefsWriter.apply();
    }

    @Override
    public List<Cookie> get(HttpUrl uri) {
        ArrayList<Cookie> ret = new ArrayList<Cookie>();
        if (cookies.containsKey(getCustomUrl(uri.toString()))) {
            Collection<Cookie> cookies = this.cookies.get(getCustomUrl(uri.toString())).values();
            for (Cookie cookie : cookies) {
                if (isCookieExpired(cookie)) {
                    remove(uri, cookie);
                } else {
                    ret.add(cookie);
                }
            }
        }

        return ret;
    }

    private static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }


    public String getCustomUrl(String url) {
        if (url.contains("192.168.0.199:8299/goods/")) {
            return "http://192.168.0.199:8299/goods";
        } else {
            return "http://192.168.0.199:8080/ki4so-web";
        }

    }
}
