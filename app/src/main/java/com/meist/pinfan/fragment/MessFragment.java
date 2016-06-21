package com.meist.pinfan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.utils.Constant;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.fragment_message)
public class MessFragment extends BaseFragment {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;

    public MessFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        title.setText("我的评价");
        backImg.setVisibility(View.GONE);
    }

    private void initData() {

        HashMap params = new HashMap();
        params.put("Keyword", "");
        params.put("sType", 0);
        params.put("PageIndex", 1);
        params.put("PageSize", 10);

        HttpRequestUtils.getmInstance().send(Constant.VIDEO_LIST_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.e("jsonObject", jsonObject.toString());
            }
        });
    }
}
