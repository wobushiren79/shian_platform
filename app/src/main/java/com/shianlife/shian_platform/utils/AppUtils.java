package com.shianlife.shian_platform.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.yongchun.library.view.ImageSelectorActivity;

import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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


    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "没有找到版本号";
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号代码
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            int versioncode = info.versionCode;
            return versioncode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 打电话
     *
     * @param v
     * @param phone
     */
    public static void call(final View v, final String phone) {
        if (!TextUtils.isEmpty(phone)) {
            v.setVisibility(View.VISIBLE);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vv) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                    if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    v.getContext().startActivity(intent);
                }
            });
        } else {
            v.setVisibility(View.GONE);
        }
    }


    /**
     * 调用地图导航
     *
     * @param context
     * @param startLatLng
     * @param endLatLng
     * @param nameStart
     * @param nameEnd
     */
    public static void intentOtherMap(Context context, LatLng startLatLng, LatLng endLatLng, String nameStart, String nameEnd) {
        Intent intent = new Intent();
        if (CheckUtils.isInstalled(context, "com.baidu.BaiduMap")) {
            try {
                intent = Intent.parseUri("intent://map/direction?" +
                        "origin=latlng:" + startLatLng.latitude + "," + startLatLng.longitude +
                        "|name:" + nameStart +
                        "&destination=latlng:" + endLatLng.latitude + "," + endLatLng.longitude +
                        "|name:" + nameEnd +
                        "&mode=driving" +
                        "&src=Name|AppName" +
                        "#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end", 0);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            context.startActivity(intent);
        } else if (CheckUtils.isInstalled(context, "com.autonavi.minimap")) {
            intent.setData(Uri
                    .parse("androidamap://route?" +
                            "sourceApplication=softname" +
                            "&slat=" + startLatLng.latitude +
                            "&slon=" + startLatLng.longitude +
                            "&dlat=" + endLatLng.latitude +
                            "&dlon=" + endLatLng.longitude +
                            "&dev=0" +
                            "&m=0" +
                            "&t=2"));
            context.startActivity(intent);
        } else {
            ToastUtils.showToastShort(context, "请先下载百度地图或高德地图");
        }
    }


    /**
     * 時間戳轉換
     *
     * @param time
     * @return
     */
    public static String formatTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return format.format(new Date(time));
    }

    public static String formatTime(long time, String data) {
        SimpleDateFormat format = new SimpleDateFormat(data, Locale.CHINA);
        return format.format(new Date(time));
    }


    /**
     * drawerLayout設置全屏滑动
     *
     * @param activity
     * @param drawerLayout
     * @param displayWidthPercentage
     */
    public static void setDrawerLeftEdgeSize(Activity activity, DrawerLayout drawerLayout, float displayWidthPercentage) {
        if (activity == null || drawerLayout == null) return;
        try {
            // 找到 ViewDragHelper 并设置 Accessible 为true
            Field leftDraggerField =
                    drawerLayout.getClass().getDeclaredField("mLeftDragger");//Right
            leftDraggerField.setAccessible(true);
            ViewDragHelper leftDragger = (ViewDragHelper) leftDraggerField.get(drawerLayout);

            // 找到 edgeSizeField 并设置 Accessible 为true
            Field edgeSizeField = leftDragger.getClass().getDeclaredField("mEdgeSize");
            edgeSizeField.setAccessible(true);
            int edgeSize = edgeSizeField.getInt(leftDragger);

            // 设置新的边缘大小
            Point displaySize = new Point();
            activity.getWindowManager().getDefaultDisplay().getSize(displaySize);
            edgeSizeField.setInt(leftDragger, Math.max(edgeSize, (int) (displaySize.x *
                    displayWidthPercentage)));
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
