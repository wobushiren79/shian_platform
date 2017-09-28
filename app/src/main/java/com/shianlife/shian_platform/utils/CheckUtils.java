package com.shianlife.shian_platform.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.UpDataImportantEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;
import com.shianlife.shian_platform.service.UpDataService;
import com.shianlife.shian_platform.ui.activity.MainActivity;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by zm.
 */

public class CheckUtils {
    /**
     * 判断是否有网络
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }


    /**
     * 根据获取的数据检测更新
     *
     * @param context
     */
    public static void checkAppUpDate(final Context context, final AppUpDateResultBean result, boolean isToast) {
        try {
            float versionOld = AppUtils.getVersionCode(context);
            float versionNew = Float.valueOf(result.getItems().get(0).getVersionNum());

            if (versionNew > versionOld) {
                TipsDialog dialog = new TipsDialog(context);
                dialog.setTop(context.getString(R.string.appupdate_text_1) + result.getItems().get(0).getUpdataTitle());
                dialog.setTitle("" + result.getItems().get(0).getUpdataContent());
                dialog.setBottomButton(context.getString(R.string.dialog_true_2), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, UpDataService.class);
                        intent.putExtra(IntentUtils.INTENT_APPUPDATE, Constants.PHP_BaseUrl + result.getItems().get(0).getAppDownLoadUrl());
                        context.startService(intent);
                        dialog.cancel();
                    }
                });
                if (Integer.valueOf(result.getItems().get(0).getIsImportant()) == UpDataImportantEnum.IMPORTANT.getCode()) {
                    dialog.setCancelable(false);
                } else {
                    dialog.setTopButton(context.getString(R.string.dialog_false_2), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                }
                dialog.show();
            } else {
                if (isToast) {
                    ToastUtils.showToastShort(context, context.getString(R.string.appupdate_text_2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showToastShort(context, context.getString(R.string.appupdate_text_3));
        }
    }

    /**
     * 檢測是否有獲取照片權限
     *
     * @param context
     * @param resultCode
     */
    public static boolean checkPhotoPermission(Context context, int resultCode, String whyText) {
        boolean hasPermission = CheckUtils.getPermissionToReadUserContacts(
                context,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                whyText,
                resultCode);
        return hasPermission;
    }

    /**
     * 权限检测
     */
    public static boolean getPermissionToReadUserContacts(Context context, String[] permissions, String toastContent, int requestCode) {
        /**
         * 1)使用ContextCompat.chefkSelfPermission(),因为Context.permission
         * 只在棒棒糖系统中使用
         * 2）总是检查权限（即使权限被授予）因为用户可能会在设置中移除你的权限*/
        boolean isPermission = true;
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                //权限为获取，检查用户是否被询问过并且拒绝了，如果是这样的话，给予更多
                //解释
                if (ActivityCompat.shouldShowRequestPermissionRationale(scanForActivity(context), permission)) {
                    //在界面上展示为什么需要該權限
                    Toast.makeText(context, toastContent, Toast.LENGTH_SHORT).show();
                }
                //发起请求获得用户许可,可以在此请求多个权限
                isPermission = false;
            }
        }
        if (isPermission) {
            return isPermission;
        } else {
            ActivityCompat.requestPermissions(scanForActivity(context), permissions, requestCode);
            return isPermission;
        }
    }


    /**
     * 判断能否转为Activity
     *
     * @param cont
     * @return
     */
    public static BaseActivity scanForActivity(Context cont) {
        if (cont == null)
            return null;
        else if (cont instanceof BaseActivity)
            return (BaseActivity) cont;
        else if (cont instanceof ContextWrapper)
            return scanForActivity(((ContextWrapper) cont).getBaseContext());
        return null;
    }

    /**
     * 检查手机上是否安装了指定的软件
     *
     * @param context
     * @param packageName：应用包名
     * @return
     */
    public static boolean isInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String pkName = packageInfos.get(i).packageName;
                if (pkName.equals(packageName)) return true;
            }
        }
        return false;
    }

    public static boolean isPhoneNumber(CharSequence input) {
        if (input == null) {
            return false;
        } else {
            String regex = "(\\+\\d+)?1[3458]\\d{9}$";
            return Pattern.matches(regex, input);
        }
    }
}
