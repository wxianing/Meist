package com.meist.pinfan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.activity.CaixiListActivity;
import com.meist.pinfan.activity.ShopDetailsActivity;
import com.meist.pinfan.adapter.ClassifyAdapter;
import com.meist.pinfan.adapter.ShopListAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.Classify;
import com.meist.pinfan.model.ShopLists;
import com.meist.pinfan.utils.Constant;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.widget.AdapterView.*;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.fragment_shop)
public class ShopFragment extends BaseFragment implements OnItemClickListener {

    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;
    @ViewInject(R.id.listView)
    private ListView mListView;

    private List<ShopLists.DataListBean> mDatas;
    private ShopListAdapter mAdapter;

    public ShopFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }


    private void initView() {
        title.setText("商家");
        backImg.setVisibility(View.GONE);
        mDatas = new ArrayList<>();
        mAdapter = new ShopListAdapter(mDatas, getActivity());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    private void initData() {
        HashMap params = new HashMap();
        params.put("Keyword", "");
        params.put("sType", 1);
        params.put("PageIndex", 1);
        params.put("PageSize", 10);
        HttpRequestUtils.getmInstance().send(Constant.SHOP_LIST_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.e("json>>>>>", jsonObject.toString());
                AppBean<ShopLists> appBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBean<ShopLists>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    mDatas.addAll(appBean.getData().getDataList());
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int oid = mDatas.get(position).getStructureId();
        Intent intent = new Intent(getActivity(), ShopDetailsActivity.class);
        intent.putExtra("OID", oid);
        startActivity(intent);
    }
}
