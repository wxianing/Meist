package com.meist.pinfan.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.meist.pinfan.R;
import com.meist.pinfan.widget.SystemBarTintManager;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/16
 */
public class Utility {
    /**
     * 改变通知栏颜色
     */
    public static void setActionBar(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(context, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager((Activity) context);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.action_bar);
    }

    public static void setTranslucentStatus(Context context, boolean on) {
        Window win = ((Activity) context).getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
