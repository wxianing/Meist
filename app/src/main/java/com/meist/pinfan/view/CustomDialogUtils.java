package com.meist.pinfan.view;

import android.content.Context;

/**
 * Package com.meten.plantbox.view
 * 创 建 人：wxianing
 * 作 用：
 * 时 间：2016/5/22
 * 修 改 人：
 * 时 间：
 */
public class CustomDialogUtils {

    private static CustomProgressDialog progressDialog = null;

    public static void showProgressDialog(Context context) {
        if (progressDialog == null) {
            progressDialog = CustomProgressDialog.createDialog(context);
        }
        progressDialog.show();
    }

    public static void cannelProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog.cancel();
            }
            progressDialog = null;
        }
    }
}
