package com.shianlife.shian_platform.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;

/**
 * Created by zm.
 */

public class AppUtils {

    /**
     * 加载图片
     *
     * @param context
     * @param imageView
     * @param imgPath
     */
    public static void loadPic(Context context, ImageView imageView, String imgPath) {
        Glide.with(context).load(imgPath).crossFade().into(imageView);
    }

    public static void loadPic(Context context, ImageView imageView, String imgPath, int placeholderId) {
        Glide.with(context).load(imgPath).crossFade().placeholder(placeholderId).into(imageView);
    }

    public static void loadPic(Context context, ImageView imageView, String imgPath, RequestListener<String, GlideDrawable> listener) {
        Glide.with(context).load(imgPath).crossFade().listener(listener).into(imageView);
    }

    /**
     * 状态栏相关工具类
     */
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));
                //底部导航栏
                window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
