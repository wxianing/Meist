package com.meist.pinfan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.TypeReference;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.meist.pinfan.R;
import com.meist.pinfan.activity.CaixiListActivity;
import com.meist.pinfan.activity.ProductDetailsActivity;
import com.meist.pinfan.adapter.HomeHotAdapter;
import com.meist.pinfan.adapter.ImagePagerAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBeans;
import com.meist.pinfan.model.Banner;
import com.meist.pinfan.model.HotLists;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.widget.AutoScrollViewPager;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment implements View.OnClickListener, PullToRefreshBase.OnRefreshListener2<ListView>, AdapterView.OnItemClickListener {

    private static final String TAG = "HomeFragment";

    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;

    private CallBack mCallBack;
    /**
     * 头部广告
     */
    protected AutoScrollViewPager mViewPager;
    protected LinearLayout dotLL;
    private List<Banner> imageUrls;
    private ImagePagerAdapter pagerAdapter;
    /**
     * 中间导航栏
     */
    private LinearLayout makeFriends;
    private LinearLayout makeFoods;
    private LinearLayout makeActivity;

    /**
     * 热门列表
     */
    @ViewInject(R.id.mlist_view)
    private PullToRefreshListView mListView;

    private List<HotLists> mDatas;
    private HomeHotAdapter mAdapter;

    public HomeFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onInitView() {
        title.setText("首页");
        backImg.setVisibility(View.GONE);
        mCallBack = new CallBack();
        imageUrls = new ArrayList<>();
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.home_header_listveiw, null);
//        x.view().inject(getActivity(), headerView);
        mListView.getRefreshableView().addHeaderView(headerView);

        mViewPager = (AutoScrollViewPager) headerView.findViewById(R.id.home_banner_viewpager);
        dotLL = (LinearLayout) headerView.findViewById(R.id.home_dot_ll);
        makeFriends = (LinearLayout) headerView.findViewById(R.id.make_friends);
        makeFoods = (LinearLayout) headerView.findViewById(R.id.make_foods);
        makeActivity = (LinearLayout) headerView.findViewById(R.id.make_activity);
        /**
         * 热门列表
         */
        mDatas = new ArrayList<>();
        mAdapter = new HomeHotAdapter(mDatas, getActivity());
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onInitEvent() {
        super.onInitEvent();
        makeFriends.setOnClickListener(this);
        makeFoods.setOnClickListener(this);
        makeActivity.setOnClickListener(this);
        mListView.getRefreshableView().setOnItemClickListener(this);
        mListView.setOnRefreshListener(this);
    }

    @Override
    public void onInitData() {
        HashMap bannerParams = new HashMap();
        HttpRequestUtils.getmInstance().send(getActivity(), Constant.BANNER_URL, bannerParams, mCallBack);
        initData();
    }

    private void initData() {
        HashMap hotParams = new HashMap();
        hotParams.put("ResourceType", 1);
        HttpRequestUtils.getmInstance().send(getActivity(), Constant.HOME_HOTS_URL, hotParams, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                AppBeans<HotLists> appBean = com.alibaba.fastjson.JSONObject.parseObject(result, new TypeReference<AppBeans<HotLists>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    mDatas.addAll(appBean.getData());
                    mAdapter.notifyDataSetChanged();
                    mListView.onRefreshComplete();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), CaixiListActivity.class);
        switch (v.getId()) {
            case R.id.make_friends://拼交友
                intent.putExtra("sType", 1);
                break;
            case R.id.make_foods://拼美食
                intent.putExtra("sType", 3);
                break;
            case R.id.make_activity://拼活动
                intent.putExtra("sType", 2);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        mDatas.clear();
        initData();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("position", ">>>>" + position);
        int oid = mDatas.get(position - 2).getId();
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        intent.putExtra("OID", oid);
        startActivity(intent);
    }

    /**
     * 广告数据接口回调
     */
    class CallBack extends HttpRequestListener {
        @Override
        public void onSuccess(String result) {
            Log.e("Banner", result.toString());
            AppBeans<Banner> appBeans = com.alibaba.fastjson.JSONObject.parseObject(result, new TypeReference<AppBeans<Banner>>() {
            });
            if (appBeans != null && appBeans.getEnumcode() == 0) {
                imageUrls.addAll(appBeans.getData());
                pagerAdapter = new ImagePagerAdapter(getActivity(), imageUrls, dotLL);
                mViewPager.setAdapter(pagerAdapter);
                mViewPager.setOnPageChangeListener(pagerAdapter);
                pagerAdapter.refreshData(true);
                mListView.onRefreshComplete();
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
