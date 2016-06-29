package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.FriendListAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBeans;
import com.meist.pinfan.model.FriendLists;
import com.meist.pinfan.utils.Constant;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_friends)
public class FriendsActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.listView)
    private ListView mListView;

    private List<FriendLists> mDatas;
    private FriendListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("请选择联系人");
        mDatas = new ArrayList<>();
        mAdapter = new FriendListAdapter(mDatas, this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onInitEvent() {
        super.onInitEvent();
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onInitData() {
        super.onInitData();
        HttpRequestUtils.getmInstance().send(FriendsActivity.this,Constant.FRIENDS_LIST_URL, null, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                AppBeans<FriendLists> appBeans = JSONObject.parseObject(result, new TypeReference<AppBeans<FriendLists>>() {
                });
                if (appBeans != null && appBeans.getEnumcode() == 0) {
                    mDatas.addAll(appBeans.getData());
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Event(value = {R.id.back_arrows})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int userId = mDatas.get(position).getUserId();
        Log.e("userId", ">>>" + userId);
        Intent intent = new Intent(this, GiftListsActivity.class);
        intent.putExtra("userId", userId);
        startActivity(intent);
    }
}
