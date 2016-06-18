package com.hzwl.videoview.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.hzwl.videoview.MyApplication;
import com.hzwl.videoview.R;
import com.hzwl.videoview.model.ResultInfo;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.LogUtils;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/15.
 */

public class HttpRequestUtils {

    private static HttpRequestUtils utils;
    private Context context;

    private HttpRequestUtils(Context context) {
        this.context = context;

    }

    public static HttpRequestUtils create(Context context) {
        if (utils == null || !utils.getContext().equals(context)) {
            utils = new HttpRequestUtils(context);
        }
        return utils;
    }

    public Context getContext() {
        return context;
    }

    public static void send(String url, HashMap params, final HttpRequestListener listener) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("response", response.toString());
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onFail(volleyError);
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("_appId", "102");
                headers.put("_code", "");
                return headers;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(5000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.getmInstance().addToRequestQueue(request);
    }


    public void download(String url, String fileName, final int requestCode, final HttpRequestCallBack<File> callback) {

        HttpUtils httpUtils = new HttpUtils();
        File dir = new File(Constant.FILE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String target = Constant.FILE_DIR + fileName;
        httpUtils.download(url, target, false, true, new RequestCallBack<File>() {
            @Override
            public void onSuccess(ResponseInfo<File> responseInfo) {
                if (callback != null) {
                    callback.onSuccess(responseInfo.result, requestCode);
                }
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                if (callback != null) {
                    ResultInfo info = new ResultInfo(R.string.downloadError,
                            context.getString(R.string.downloadError));
                    callback.onFailure(context, info, requestCode);
                }
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                if (callback != null) {
                    Log.e("onLoading", "正在下载>>>>>" + current);
                    callback.onLoading(total, current, isUploading, requestCode);
                }
            }
        });
    }
}
