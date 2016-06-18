package com.meist.pinfan.http;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/5/11 0011.
 */

public abstract class HttpRequestListener {

    public abstract void onSuccess(JSONObject jsonObject);

    public void onFail(VolleyError volleyError) {
    }
}