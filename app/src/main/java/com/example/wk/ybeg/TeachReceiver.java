package com.example.wk.ybeg;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * 用户自定义的广播接受者
 *
 * 广播的生命周期非常短，只有在收到广播的时候onreceive方法会调用
 * onreceive不能进行耗时操作
 * onreceive中的代码如果超过10秒，会引发Android系统的ARR
 */
public class TeachReceiver extends BroadcastReceiver {
    private static final String TAG = "sss";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " );
        //广播中的信息
        Bundle extras = intent.getExtras();

        //匹配广播中的动作
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Log.e(TAG, "onReceive: "+extras.getString(JPushInterface.EXTRA_MESSAGE) );
            Log.e(TAG, "onReceive: "+extras.getString(JPushInterface.EXTRA_EXTRA) );
            String extra = extras.getString(JPushInterface.EXTRA_EXTRA);
            try {
                JSONObject jsonObject = new JSONObject(extra);
                String game = jsonObject.getString("game");

                Notification notification = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentText(game)
                        .build();
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,notification);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
