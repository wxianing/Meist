package com.hzwl.videoview.receiver;

/**
 * Created by Administrator on 2016/6/15.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.hzwl.videoview.MainActivity;

public class BootBroadcastReceiver extends BroadcastReceiver {

    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            Intent mIntent = new Intent(context, MainActivity.class);

            mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(mIntent);
        }
    }
}

