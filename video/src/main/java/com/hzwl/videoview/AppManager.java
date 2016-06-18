package com.hzwl.videoview;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * Created by Administrator on 2016/6/15.
 */
public class AppManager {
    public static int getAppVersionCode(Context context) {
        int versionCode = 0;
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            versionCode = info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
