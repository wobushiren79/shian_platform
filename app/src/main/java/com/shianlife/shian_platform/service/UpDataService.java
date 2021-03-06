package com.shianlife.shian_platform.service;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;


import com.shianlife.shian_platform.appenum.APPTypeEnum;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.io.File;

/**
 * Created by zm on 2017/2/13.
 */

public class UpDataService extends Service {
    String downloadURL = null;
    String downloadName = APPTypeEnum.PLATFORM.getName() + ".apk";

    boolean isDown = false;

    private String DOWNLOADPATH = "/download/";//下载路径，如果不定义自己的路径，6.0的手机不自动安装

    public UpDataService() {

    }

    /**
     * 安卓系统下载类
     **/
    DownloadManager manager;
    /**
     * 接收下载完的广播
     **/
    DownloadCompleteReceiver receiver;

    /**
     * 初始化下载器
     **/
    private void initDownManager() {
        try {
            delFile(DOWNLOADPATH + downloadName);
            isDown = true;
            manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            receiver = new DownloadCompleteReceiver();
            //设置下载地址
            DownloadManager.Request down = new DownloadManager.Request(Uri.parse(downloadURL));
            // 设置允许使用的网络类型，这里是移动网络和wifi都可以
            down.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
            // 下载时，通知栏显示途中
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                down.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            }
            // 显示下载界面
            down.setVisibleInDownloadsUi(true);
            // 设置下载后文件存放的位置
            down.setDestinationInExternalPublicDir(DOWNLOADPATH, downloadName);
            // 将下载请求放入队列
            manager.enqueue(down);
            //注册下载广播
            registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        } catch (SecurityException e) {
            ToastUtils.showToastShort(getApplicationContext(), "更新没有文件操作权限,请打开权限后重试");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 调用下载
        try {
            downloadURL = intent.getStringExtra(IntentUtils.INTENT_APPUPDATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!isDown && downloadURL != null) {
            initDownManager();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        // 注销下载广播
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
        super.onDestroy();
    }

    // 接受下载完成后的intent
    class DownloadCompleteReceiver extends BroadcastReceiver {
        File targetApkFile = null;

        @Override
        public void onReceive(Context context, Intent intent) {
            //判断是否下载完成的广播
            isDown = false;
            DownloadManager.Query query = new DownloadManager.Query();
            long downId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            query.setFilterById(downId);
            Cursor c = manager.query(query);

            if (c.moveToFirst()) {
                int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                switch (status) {
                    case DownloadManager.STATUS_PAUSED:
                        Log.v("this", "STATUS_PAUSED");
                    case DownloadManager.STATUS_PENDING:
                        Log.v("this", "STATUS_PENDING");
                    case DownloadManager.STATUS_RUNNING:
                        //正在下载，不做任何事情
                        Log.v("this", "STATUS_RUNNING");
                        break;
                    case DownloadManager.STATUS_SUCCESSFUL:
                        //完成
                        Log.v("this", "下载完成");
                        //自动安装apk
//                        String uriString = c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
//                        if (!TextUtils.isEmpty(uriString)) {
//                            targetApkFile = new File(Uri.parse(uriString).getPath());
//                        }
//                        if (targetApkFile != null) {
//                            openFile(targetApkFile, context);
//                        }
                        //获取下载的文件id
                        if (manager.getUriForDownloadedFile(downId) != null) {
                            //自动安装apk
                            installAPK(manager.getUriForDownloadedFile(downId), context);
                            //installAPK(context);
                        } else {
                            Toast.makeText(context, "下载失败", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case DownloadManager.STATUS_FAILED:
                        //清除已下载的内容，重新下载
                        Log.v("this", "STATUS_FAILED");
                        manager.remove(downId);
                        break;
                }
            }
            //停止服务并关闭广播
            UpDataService.this.stopSelf();
        }

        private void installAPK(Uri apk, Context context) {
            Log.v("this", "installAPK");
            if (Build.VERSION.SDK_INT < 23) {
                Intent intents = new Intent();
                intents.setAction("android.intent.action.VIEW");
                intents.addCategory("android.intent.category.DEFAULT");
                intents.setType("application/vnd.android.package-archive");
                intents.setData(apk);
                intents.setDataAndType(apk, "application/vnd.android.package-archive");
                intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intents);
            } else {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + DOWNLOADPATH + downloadName);
                if (file.exists()) {
                    openFile(file, context);
                }
            }
        }


        //安装apk
        protected void installApkNew(Uri uri) {
            Intent intent = new Intent();
            //执行动作
            intent.setAction(Intent.ACTION_VIEW);
            //执行的数据类型
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            //不加下面这句话是可以的，查考的里面说如果不加上这句的话在apk安装完成之后点击单开会崩溃
            android.os.Process.killProcess(android.os.Process.myPid());
            startActivity(intent);
        }

        public void openFile(File file, Context context) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            String type = getMIMEType(file);
            intent.setDataAndType(Uri.fromFile(file), type);
            try {
                context.startActivity(intent);
            } catch (Exception var5) {
                var5.printStackTrace();
                Toast.makeText(context, "没有找到打开此类文件的程序", Toast.LENGTH_SHORT).show();
            }

        }

        private String getMIMEType(File var0) {
            String var1 = "";
            String var2 = var0.getName();
            String var3 = var2.substring(var2.lastIndexOf(".") + 1, var2.length()).toLowerCase();
            var1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var3);
            return var1;
        }
    }

    //删除文件
    public static void delFile(String fileName) {
        Log.v("down", "Environment.getExternalStorageDirectory():" + Environment.getExternalStorageDirectory());
        File file = new File(Environment.getExternalStorageDirectory() + fileName);
        if (file.isFile()) {
            file.delete();
        }
        file.exists();
    }
}
