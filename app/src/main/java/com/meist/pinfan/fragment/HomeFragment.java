package com.meist.pinfan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.alibaba.fastjson.TypeReference;
import com.android.volley.VolleyError;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.ImagePagerAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBeans;
import com.meist.pinfan.model.Banner;
import com.meist.pinfan.model.User;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.SharedPreferencesUtils;
import com.meist.pinfan.widget.AutoScrollViewPager;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;

    private CallBack mCallBack;
    /**
     * 头部广告
     */
    @ViewInject(R.id.home_banner_viewpager)
    protected AutoScrollViewPager mViewPager;
    @ViewInject(R.id.home_dot_ll)
    protected LinearLayout dotLL;

    private List<Banner> imageUrls;
    private ImagePagerAdapter pagerAdapter;

    public HomeFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        title.setText("首页");
        backImg.setVisibility(View.GONE);
        mCallBack = new CallBack();
        imageUrls = new ArrayList<>();
        pagerAdapter = new ImagePagerAdapter(getActivity(), imageUrls, dotLL);

    }

    private void initData() {
        HashMap params = new HashMap();
        HttpRequestUtils.send(Constant.BANNER_URL, params, mCallBack);
    }

    /**
     * 广告数据接口回调
     */
    class CallBack extends HttpRequestListener {
        @Override
        public void onSuccess(JSONObject jsonObject) {
            Log.e("Banner", jsonObject.toString());
            AppBeans<Banner> appBeans = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBeans<Banner>>() {
            });
            int enumcode = appBeans.getEnumcode();
            if (enumcode == 0) {
                imageUrls.addAll(appBeans.getData());
                pagerAdapter = new ImagePagerAdapter(getActivity(), imageUrls, dotLL);
                mViewPager.setAdapter(pagerAdapter);
                mViewPager.setOnPageChangeListener(pagerAdapter);
                pagerAdapter.refreshData(true);
            }
        }

        @Override
        public void onFail(VolleyError volleyError) {
            super.onFail(volleyError);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewPager.startAutoScroll();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewPager.stopAutoScroll();
    }
}
