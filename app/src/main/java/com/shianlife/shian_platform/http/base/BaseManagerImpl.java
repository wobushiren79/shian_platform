package com.shianlife.shian_platform.http.base;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.imp.impl.CarManagerImpl;

/**
 * Created by zm.
 */

public class BaseManagerImpl {
    protected HttpRequestExecutor excutor = new HttpRequestExecutor();
    protected String BaseUrl;

    protected BaseManagerImpl() {
    }

    protected <T> void requestPost(Context context,
                                   String method,
                                   Class<T> cls,
                                   BaseHttpParams params,
                                   HttpResponseHandler<T> response) {
        excutor.requestPost(context, method, cls, params, response, false, BaseUrl, null);
    }

    protected <T> void requestPost(Context context,
                                   String method,
                                   Class<T> cls,
                                   BaseHttpParams params,
                                   HttpResponseHandler<T> response,
                                   boolean isDialog) {
        excutor.requestPost(context, method, cls, params, response, isDialog, BaseUrl, null);
    }
}
