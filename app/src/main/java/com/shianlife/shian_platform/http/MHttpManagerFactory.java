package com.shianlife.shian_platform.http;


import com.shianlife.shian_platform.http.imp.FileManager;
import com.shianlife.shian_platform.http.imp.LoginManager;
import com.shianlife.shian_platform.http.imp.MAccountManager;
import com.shianlife.shian_platform.http.imp.PHPManager;
import com.shianlife.shian_platform.http.imp.StoreManager;
import com.shianlife.shian_platform.http.imp.impl.FileManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.LoginManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.MAccountManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.PHPManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.StoreManagerImpl;

/**
 * 接口工厂
 *
 * @author Administrator
 */
public class MHttpManagerFactory {
    /**
     * 获取账户接口manager
     *
     * @return
     */
    public static MAccountManager getAccountManager() {
        return MAccountManagerImpl.getInstance();
    }

    public static FileManager getFileManager() {
        return FileManagerImpl.getInstance();
    }

    public static PHPManager getPHPManager() {
        return PHPManagerImpl.getInstance();
    }

    public static StoreManager getStoreManger() {
        return StoreManagerImpl.getInstance();
    }

    public static LoginManager getLoginManager() {
        return LoginManagerImpl.getInstance();
    }
}
