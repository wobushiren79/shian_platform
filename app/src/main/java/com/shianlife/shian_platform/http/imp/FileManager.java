package com.shianlife.shian_platform.http.imp;

import android.content.Context;

import com.shianlife.shian_platform.http.base.FileHttpResponseHandler;
import com.shianlife.shian_platform.http.base.HttpManager;
import com.shianlife.shian_platform.http.result.HrUploadFile;


public interface FileManager extends HttpManager {
	public void upLoadFile(Context context, String file, String path, FileHttpResponseHandler<HrUploadFile> handler);
}
