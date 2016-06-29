package com.meist.pinfan.http;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.meist.pinfan.MyApplication;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.NetworkUtils;
import com.meist.pinfan.utils.ToastUtils;
import com.meist.pinfan.view.CustomDialogUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
public class HttpRequestUtils {

    private static HttpRequestUtils mInstance;

    public HttpRequestUtils() {
    }

    public static synchronized HttpRequestUtils getmInstance() {
        if (mInstance == null) {
            synchronized (HttpRequestUtils.class) {
                if (mInstance == null) {
                    mInstance = new HttpRequestUtils();
                }
            }
        }
        return mInstance;
    }

    public void send(Context mContext, String url, HashMap params, final HttpRequestListener listener) {
            CustomDialogUtils.showProgressDialog(mContext);
            Log.e("addParams:", JSON.toJSONString(params));
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, JSON.toJSONString(params), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.e("response", response.toString());
                    listener.onSuccess(response.toString());
                    CustomDialogUtils.cannelProgressDialog();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    listener.onFail(volleyError);
                    CustomDialogUtils.cannelProgressDialog();
                }
            }) {
                public Map<String, String> getHeaders() {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("_appId", Constant.APPID);
                    headers.put("_code", Constant.CODE);
                    return headers;
                }
            };
            request.setRetryPolicy(new DefaultRetryPolicy(5000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            MyApplication.getmInstance().addToRequestQueue(request);
    }
}
