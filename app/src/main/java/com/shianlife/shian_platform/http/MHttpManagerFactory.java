package com.shianlife.shian_platform.http;


import com.shianlife.shian_platform.http.imp.FileManager;
import com.shianlife.shian_platform.http.imp.MAccountManager;
import com.shianlife.shian_platform.http.imp.PHPManager;
import com.shianlife.shian_platform.http.imp.impl.FileManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.MAccountManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.PHPManagerImpl;

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
}
