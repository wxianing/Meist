package com.meist.pinfan.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_caixi_list)
public class CaixiListActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2<ListView> {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.listView)
    private PullToRefreshListView mListView;
    private List<ClassifyLists.DataListBean> mData;
    private ClassifyListAdapter mAdapter;
    private int pageIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData(pageIndex);
        initEvent();
    }

    private void initView() {
        title.setText("商品列表");
//        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mData = new ArrayList<>();
        mAdapter = new ClassifyListAdapter(mData, this);
        mListView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mListView.setOnRefreshListener(this);
    }

    private void initData(int pageIndex) {
        HashMap params = new HashMap();
        params.put("Keyword", "");
        params.put("sType", 0);
        params.put("PageIndex", pageIndex);
        params.put("PageSize", 10);
        HttpRequestUtils.send(Constant.CLASSIFY_LIST_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                AppBean<ClassifyLists> appBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBean<ClassifyLists>>() {
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

    }
}
