package com.shianlife.shian_platform.receiver;

import android.content.Context;

import com.baidu.android.pushservice.PushMessageReceiver;
import com.shianlife.shian_platform.common.Constants;

import java.util.List;

/**
 * Created by zm.
 */

public class PushReceiver extends PushMessageReceiver {

    @Override
    public void onBind(Context context, int errorCode, String appid, String userId, String channelId, String requestId) {
        Constants.ChannelId=channelId;
    }

    @Override
    public void onUnbind(Context context, int i, String s) {

    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {

    }

    //透传消息
    @Override
    public void onMessage(Context context, String message, String customContentString) {

    }

    //通知点击事件
    @Override
    public void onNotificationClicked(Context context, String title, String description, String customContentString) {

    }

    //通知
    @Override
    public void onNotificationArrived(Context context, String title, String description, String customContentString) {

    }
}
