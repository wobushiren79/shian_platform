package com.shianlife.shian_platform.utils;

import android.util.Log;

/**
 * Created by zm.
 */

public class LogUtils {
    public static String TAG = "tag";

    public static void LogTagV(String msg) {
        Log.v(TAG, msg);
    }

    public static void LogTagE(String msg) {
        Log.e(TAG, msg);
    }

    public static void LogTagI(String msg) {
        Log.i(TAG, msg);
    }
}
