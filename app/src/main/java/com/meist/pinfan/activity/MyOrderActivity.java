package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.MyOrderAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.Order;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.LogUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_my_order)
public class MyOrderActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2<ListView>, AdapterView.OnItemClickListener {

    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.listView)
    private PullToRefreshListView mListView;
    private List<Order.DataListBean> mDatas;

    private MyOrderAdapter mAdapter;

    private int pageIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("我的订单");
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mDatas = new ArrayList<>();
        mAdapter = new MyOrderAdapter(mDatas, this);
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void onInitEvent() {
        super.onInitEvent();
        mListView.setOnRefreshListener(this);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onInitData() {
        super.onInitData();
        initData(pageIndex);
    }

    private void initData(int pageIndex) {
        HashMap params = new HashMap();

        params.put("status", 0);
        params.put("Keyword", "");
        params.put("sType", 0);
        params.put("PageIndex", pageIndex);
        params.put("PageSize", 10);

        HttpRequestUtils.getmInstance(MyOrderActivity.this).send(Constant.ORDER_LIST_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                AppBean<Order> appBean = JSONObject.parseObject(result, new TypeReference<AppBean<Order>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    mDatas.addAll(appBean.getData().getDataList());
                    mAdapter.notifyDataSetChanged();
                    mListView.onRefreshComplete();
                }
            }
        });
    }

    @Event(R.id.back_arrows)
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        pageIndex = 1;
        mDatas.clear();
        initData(pageIndex);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        pageIndex++;
        initData(pageIndex);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra("OID", mDatas.get(position - 1).getId());
        startActivity(intent);
    }
}
