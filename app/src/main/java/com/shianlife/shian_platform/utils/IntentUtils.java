package com.shianlife.shian_platform.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by zm.
 */

public class IntentUtils {
    public static void IntentStart(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }
}
