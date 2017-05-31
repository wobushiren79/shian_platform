package com.shianlife.shian_platform.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.UpDataImportantEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;
import com.shianlife.shian_platform.service.UpDataService;
import com.shianlife.shian_platform.ui.activity.MainActivity;

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
                        intent.putExtra(IntentUtils.INTENT_APPUPDATE, Constants.PHP_URL + result.getItems().get(0).getAppDownLoadUrl());
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


}
