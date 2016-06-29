package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.ClassifyListAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.ClassifyLists;
import com.meist.pinfan.utils.Constant;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Package：com.meist.pinfan.activity
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.activity_caixi_list)
public class CaixiListActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2<ListView>, AdapterView.OnItemClickListener {

    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.listView)
    private PullToRefreshListView mListView;
    private List<ClassifyLists.DataListBean> mData;
    private ClassifyListAdapter mAdapter;
    private int pageIndex = 1;
    private int sType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(pageIndex);
        initEvent();
    }

    @Override
    public void onInitView() {
        title.setText("商品列表");
        sType = getIntent().getIntExtra("sType", 0);
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mData = new ArrayList<>();
        mAdapter = new ClassifyListAdapter(mData, this);
        mListView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mListView.setOnRefreshListener(this);
        mListView.setOnItemClickListener(this);
    }

    private void initData(int pageIndex) {
        HashMap params = new HashMap();
        params.put("Keyword", "");
        params.put("sType", sType);
        params.put("PageIndex", pageIndex);
        params.put("PageSize", 10);
        HttpRequestUtils.getmInstance().send(CaixiListActivity.this,Constant.CLASSIFY_LIST_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                AppBean<ClassifyLists> appBean = JSONObject.parseObject(result, new TypeReference<AppBean<ClassifyLists>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    mData.addAll(appBean.getData().getDataList());
                    mAdapter.notifyDataSetChanged();
                    mListView.onRefreshComplete();
                }
            }
        });
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Event(value = {R.id.back_arrows})
    private void getClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        pageIndex = 1;
        mData.clear();
        initData(pageIndex);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        pageIndex++;
        initData(pageIndex);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int oid = mData.get(position - 1).getId();
        Intent intent = new Intent(CaixiListActivity.this, ProductDetailsActivity.class);
        intent.putExtra("OID", oid);
        startActivity(intent);
    }
}
