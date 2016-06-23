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
import com.meist.pinfan.activity.MyCollectActivity;
import com.meist.pinfan.activity.MyOrderActivity;
import com.meist.pinfan.activity.MyRedpacketActivity;
import com.meist.pinfan.activity.PresentActivity;
import com.meist.pinfan.activity.ResetPwdActivity;
import com.meist.pinfan.utils.SharedPreferencesUtils;
import com.meist.pinfan.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Package：com.meist.pinfan.fragment
 * 作  用：个人中心
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.fragment_my)
public class MyFragment extends BaseFragment {

    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;

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


    @Event(value = {R.id.mypurse_layout, R.id.mycollect_layout, R.id.my_order, R.id.get_present, R.id.send_present, R.id.logout, R.id.reset_password})
    private void click(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.mypurse_layout://我的红包
//                ToastUtils.show(getActivity(), "我的红包");
                intent = new Intent(getActivity(), MyRedpacketActivity.class);
                startActivity(intent);
                break;

            case R.id.mycollect_layout://我的收藏
                startActivity(new Intent(getActivity(), MyCollectActivity.class));
                break;

            case R.id.my_order://查看订单
//                ToastUtils.show(getActivity(), "查看订单");
                intent = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intent);
                break;

            case R.id.get_present:
                ToastUtils.show(getActivity(), "收到礼物");
                intent = new Intent(getActivity(), PresentActivity.class);
                intent.putExtra("sType", 1);
                startActivity(intent);
                break;

            case R.id.send_present:
                ToastUtils.show(getActivity(), "发出礼物");
                intent = new Intent(getActivity(), PresentActivity.class);
                intent.putExtra("sType", 2);
                startActivity(intent);
                break;

            case R.id.reset_password://修改密码
                startActivity(new Intent(getActivity(), ResetPwdActivity.class));
                break;

            case R.id.logout://退出登录
                SharedPreferencesUtils.setLoginTag(getActivity(), false);//取消默认登录
                intent = new Intent(getActivity(), LoginActivity.class);
                if (MainActivity.mainActivity != null) {
                    MainActivity.mainActivity.finish();
                    MainActivity.mainActivity = null;
                }
                startActivity(intent);
                break;
        }
    }

}
