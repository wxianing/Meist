package com.meist.pinfan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.activity.CaixiListActivity;
import com.meist.pinfan.adapter.ClassifyAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBeans;
import com.meist.pinfan.model.Classify;
import com.meist.pinfan.utils.Constant;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.*;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_classify)
public class ClassifyFragment extends BaseFragment implements OnItemClickListener {

    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;
    @ViewInject(R.id.listView)
    private ListView mListView;

    private List<Classify> mDatas;
    private ClassifyAdapter mAdapter;

    public ClassifyFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }


    private void initView() {
        title.setText("全部分类");
        backImg.setVisibility(View.GONE);
        mDatas = new ArrayList<>();
        mAdapter = new ClassifyAdapter(mDatas, getActivity());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    private void initData() {
        HttpRequestUtils.send(Constant.CLASSIFY_UTL, null, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                AppBeans<Classify> appBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBeans<Classify>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    mDatas.addAll(appBean.getData());
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), CaixiListActivity.class);
        startActivity(intent);
    }
}
