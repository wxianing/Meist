package com.meist.pinfan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.activity.LoginActivity;
import com.meist.pinfan.activity.MainActivity;
import com.meist.pinfan.activity.ResetPwdActivity;
import com.meist.pinfan.utils.SharedPreferencesUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：个人中心
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.fragment_my)
public class MyFragment extends BaseFragment implements View.OnClickListener {


    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;

    @ViewInject(R.id.logout)
    private LinearLayout logout;//退出登录
    @ViewInject(R.id.reset_password)
    private LinearLayout resetPwd;//修改密码


    public MyFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("个人中心");
        backImg.setVisibility(View.GONE);
    }

    @Override
    public void onInitEvent() {
        super.onInitEvent();
        logout.setOnClickListener(this);
        resetPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_password://修改密码
                startActivity(new Intent(getActivity(), ResetPwdActivity.class));
                break;
            case R.id.logout:
                SharedPreferencesUtils.setLoginTag(getActivity(), false);//取消默认登录
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                if (MainActivity.mainActivity != null) {
                    MainActivity.mainActivity.finish();
                    MainActivity.mainActivity = null;
                }
                startActivity(intent);
                break;
        }
    }
}
