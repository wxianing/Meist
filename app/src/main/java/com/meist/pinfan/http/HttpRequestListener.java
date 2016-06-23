package com.meist.pinfan.http;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */

public abstract class HttpRequestListener {

    public abstract void onSuccess(String result);

    public void onFail(VolleyError volleyError) {
    }
}