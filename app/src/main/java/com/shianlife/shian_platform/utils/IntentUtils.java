package com.shianlife.shian_platform.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;

import java.io.Serializable;

/**
 * Created by zm.
 */

public class IntentUtils {

    public static final String INTENT_URL = "INTENT_URL";

    public static final String INTENT_APPUPDATE = "INTENT_APPUPDATE";//APP更新
    public static final String INTENT_ISCOLLECTION = "INTENT_ISCOLLECTION";
    public static final String INTENT_SHAREDATA = "INTENT_SHAREDATA";

    public static class Build {
        Context context;
        Intent intent;

        public Build(Context context, Class<?> cls) {
            this.context = context;
            intent = new Intent(context, cls);
        }

        public Build setString(String name, String content) {
            intent.putExtra(name, content);
            return this;
        }

        public Build setInt(String name, int content) {
            intent.putExtra(name, content);
            return this;
        }

        public Build setBoolean(String name, boolean content) {
            intent.putExtra(name, content);
            return this;
        }

        public Build setData(String name, Serializable content) {
            intent.putExtra(name, content);
            return this;
        }

        public void start() {
            context.startActivity(intent);
        }
    }
}
