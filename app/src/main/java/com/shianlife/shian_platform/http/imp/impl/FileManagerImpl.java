package com.shianlife.shian_platform.http.imp.impl;

import android.content.Context;

import com.shianlife.shian_platform.http.base.FileHttpResponseHandler;
import com.shianlife.shian_platform.http.imp.FileManager;
import com.shianlife.shian_platform.http.result.HrUploadFile;

import java.util.HashMap;
import java.util.Map;


public class FileManagerImpl implements FileManager {
    private static FileManager manager;
    Map<String, String> header = new HashMap<>();


    private FileManagerImpl() {
        header.put("systemType", "2");
    }

    public void setCookie(String cookie) {
        header.put("Cookie", "sid=" + cookie);
    }

    public static FileManager getInstance() {
        if (manager == null) {
            manager = new FileManagerImpl();
        }
        return manager;
    }


    @Override
    public void upLoadFile(Context context, String file, String path, FileHttpResponseHandler<HrUploadFile> handler) {

    }
}
