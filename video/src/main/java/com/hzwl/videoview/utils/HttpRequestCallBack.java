package com.hzwl.videoview.utils;

import android.content.Context;
import android.widget.Toast;

import com.hzwl.videoview.model.ResultInfo;


public abstract class HttpRequestCallBack<T> {

    public abstract void onSuccess(T t, int requestCode);

    public void onFailure(Context context, ResultInfo info, int requestCode) {
        Toast.makeText(context, info.toString(), Toast.LENGTH_SHORT).show();
    }

    public void onLoading(long total, long current,
                          boolean isUploading, int requestCode) {

    }

    public void onReponse(String result) {

    }
}
