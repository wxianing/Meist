package com.meist.pinfan.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meist.pinfan.R;

public class ToastUtils {

    public static void show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context, int info) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    }

//    private static ToastUtils toastCommom;
//
//    private static Toast toast;
//
//    private ToastUtils() {
//    }
//
//    public static ToastUtils createToastConfig() {
//        if (toastCommom == null) {
//            toastCommom = new ToastUtils();
//        }
//        return toastCommom;
//    }
//
//    /**
//     * 显示Toast
//     *
//     * @param context
//     * @param msg
//     */
//
//    public static void shows(Context context, String msg) {
//        View layout = LayoutInflater.from(context).inflate(R.layout.toast_xml, null);
//        TextView text = (TextView) layout.findViewById(R.id.text);
//        text.setText(msg);
//        toast = new Toast(context);
//        toast.setGravity(Gravity.BOTTOM, 0, 120);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setView(layout);
//        toast.show();
//    }
//
//    public static void showl(Context context, String msg) {
//        View layout = LayoutInflater.from(context).inflate(R.layout.toast_xml, null);
//        TextView text = (TextView) layout.findViewById(R.id.text);
//        text.setText(msg);
//        toast = new Toast(context);
//        toast.setGravity(Gravity.BOTTOM, 0, 120);
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setView(layout);
//        toast.show();
//    }

}
