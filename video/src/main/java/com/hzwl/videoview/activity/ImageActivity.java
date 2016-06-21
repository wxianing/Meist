package com.hzwl.videoview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.alibaba.fastjson.TypeReference;
import com.hzwl.videoview.R;
import com.hzwl.videoview.adapter.ImagePagerAdapter;
import com.hzwl.videoview.model.AppBeans;
import com.hzwl.videoview.model.Banner;
import com.hzwl.videoview.utils.Constant;
import com.hzwl.videoview.utils.HttpRequestListener;
import com.hzwl.videoview.utils.HttpRequestUtils;
import com.hzwl.videoview.widget.AutoScrollViewPager;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    /**
     * 头部广告
     */
    protected AutoScrollViewPager mViewPager;
    protected LinearLayout dotLL;

    private List<Banner> imageUrls;
    private ImagePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initView();
        initData();
    }

    private void initView() {
        imageUrls = new ArrayList<>();
        mViewPager = (AutoScrollViewPager) this.findViewById(R.id.banner_viewpager);
        dotLL = (LinearLayout) this.findViewById(R.id.dot_ll);
    }

    private void initData() {
        HashMap params = new HashMap();
        HttpRequestUtils.create(this).send(Constant.BANNER_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                AppBeans<Banner> appBeans = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBeans<Banner>>() {
                });
                if (appBeans != null && appBeans.getEnumcode() == 0) {
                    imageUrls.addAll(appBeans.getData());
                    pagerAdapter = new ImagePagerAdapter(ImageActivity.this, imageUrls, dotLL);
                    mViewPager.setAdapter(pagerAdapter);
                    mViewPager.setOnPageChangeListener(pagerAdapter);
                    pagerAdapter.refreshData(true);
                }
            }
        });
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
