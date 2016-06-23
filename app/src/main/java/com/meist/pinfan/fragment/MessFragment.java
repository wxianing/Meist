package com.meist.pinfan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.activity.CaixiCommentActivity;
import com.meist.pinfan.activity.MessNoticeActivity;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.utils.Constant;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
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
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("我的消息");
        backImg.setVisibility(View.GONE);
    }

    @Event(value = {R.id.caixi_comment, R.id.message_notice})
    private void onClck(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.caixi_comment:
                intent = new Intent(getActivity(), CaixiCommentActivity.class);
                startActivity(intent);
                break;
            case R.id.message_notice:
                intent = new Intent(getActivity(), MessNoticeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
