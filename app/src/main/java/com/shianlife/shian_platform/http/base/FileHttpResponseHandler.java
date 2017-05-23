package com.shianlife.shian_platform.http.base;

public interface FileHttpResponseHandler<T>
{
    public void onStart();

    public void onSuccess(T t);

    public void onError(String message);

    public void onProgress(long total, float progress);
}
