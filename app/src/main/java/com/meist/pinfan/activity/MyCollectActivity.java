package com.meist.pinfan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.MyCollectsAdater;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.Collects;
import com.meist.pinfan.utils.Constant;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_my_collect)
public class MyCollectActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.mlist_view)
    private ListView mListView;

    private List<Collects.DataListBean> mDatas;
    private MyCollectsAdater mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("我的收藏");
        mDatas = new ArrayList<>();
        mAdapter = new MyCollectsAdater(mDatas, this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onInitData() {
        super.onInitData();
        loadData();
    }

    private void loadData() {
        HashMap params = new HashMap();
        HttpRequestUtils.getmInstance().send(Constant.GET_COLLECT_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                AppBean<Collects> appBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBean<Collects>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    mDatas.addAll(appBean.getData().getDataList());
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Event(value = {R.id.back_arrows})
    private void click(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }
}
