package com.shianlife.shian_platform.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2017/4/7.
 */

public class SharePerfrenceUtils {
    private static final String C_sShare_Login_F = "Login_Share_f";

    private static final String C_sShareLogin_username = "share_username";
    private static final String C_sShareLogin_password = "share_password";
    private static final String C_sShareLogin_isAutoLogin = "share_isAutoLogin";
    private static final String C_sShareLogin_isRemeberPassword = "share_isRePassword";


    /**
     * 設置自動登陸狀態
     *
     * @param c
     * @param isAuto
     */
    public static void setShareAutoLogin(Context c, boolean isAuto) {
        SharedPreferences.Editor editor = c.getSharedPreferences(C_sShare_Login_F, MODE_PRIVATE).edit();
        editor.putBoolean(C_sShareLogin_isAutoLogin, isAuto);
        editor.commit();
    }

    /**
     * 保存账号信息
     *
     * @param context
     * @param username
     * @param password
     * @param isRemeber
     * @param isAuto
     */
    public static void setLoginShare(Context context, String username, String password, boolean isRemeber, boolean isAuto) {
        SharedPreferences.Editor editor = context.getSharedPreferences(C_sShare_Login_F, MODE_PRIVATE).edit();
        editor.putString(C_sShareLogin_username, username);
        editor.putString(C_sShareLogin_password, password);
        editor.putBoolean(C_sShareLogin_isRemeberPassword, isRemeber);
        editor.putBoolean(C_sShareLogin_isAutoLogin, isAuto);
        editor.commit();
    }


    /**
     * 获取账号信息
     *
     * @param content
     * @return
     */
    public static UserLoginConfig getLoginShare(Context content) {
        SharedPreferences share = content.getSharedPreferences(C_sShare_Login_F, MODE_PRIVATE);
        String username = share.getString(C_sShareLogin_username, "");
        String password = share.getString(C_sShareLogin_password, "");
        boolean isRember = share.getBoolean(C_sShareLogin_isRemeberPassword,
                false);
        boolean isAuto = share.getBoolean(C_sShareLogin_isAutoLogin, false);
        UserLoginConfig loginS = new UserLoginConfig();
        loginS.setUserName(username);
        loginS.setPassWord(password);
        loginS.setKeepAccount(isRember);
        loginS.setAutoLogin(isAuto);
        return loginS;
    }

}
