package com.shianlife.shian_platform.http;


import com.shianlife.shian_platform.http.imp.CarManager;
import com.shianlife.shian_platform.http.imp.FileManager;
import com.shianlife.shian_platform.http.imp.OrderCenterManager;
import com.shianlife.shian_platform.http.imp.SystemManager;
import com.shianlife.shian_platform.http.imp.PHPManager;
import com.shianlife.shian_platform.http.imp.StoreManager;
import com.shianlife.shian_platform.http.imp.impl.CarManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.FileManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.OrderCenterManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.SystemManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.PHPManagerImpl;
import com.shianlife.shian_platform.http.imp.impl.StoreManagerImpl;

/**
 * 接口工厂
 *
 * @author Administrator
 */
public class MHttpManagerFactory {

    public static FileManager getFileManager() {
        return FileManagerImpl.getInstance();
    }

    public static PHPManager getPHPManager() {
        return PHPManagerImpl.getInstance();
    }

    public static CarManager getCarManager() {
        return CarManagerImpl.getInstance();
    }

    public static StoreManager getStoreManger() {
        return StoreManagerImpl.getInstance();
    }

    public static SystemManager getSystemManager() {
        return SystemManagerImpl.getInstance();
    }

    public static OrderCenterManager getOrderCenterManager() {
        return OrderCenterManagerImpl.getInstance();
    }

}
