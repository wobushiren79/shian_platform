package com.shianlife.shian_platform.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zm.
 */

public class ToastUtils {

    public static void showToastShort(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
