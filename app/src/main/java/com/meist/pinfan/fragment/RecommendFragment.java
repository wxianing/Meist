package com.meist.pinfan.fragment;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.adapter.RecommendAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_recommend)
public class RecommendFragment extends BaseFragment {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;
    @ViewInject(R.id.listview)
    private ListView mListView;
    private List<String> mDatas;
    private RecommendAdapter mAdapter;

    public RecommendFragment() {

    }

    @Override
    public void onInitView() {
        backImg.setVisibility(View.GONE);
        title.setText("推荐");
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.imageview_layout,null);
        mListView.addHeaderView(headView);
        mDatas = new ArrayList<>();
        mDatas.add("http://p2.pccoo.cn/bendi/20141226/2014122611131128667836.png");
        mDatas.add("http://qcyn.sinaimg.cn/2011/0531/U5200P1032DT20110531151848.jpg");
        mDatas.add("http://img699.ph.126.net/tPh79aHnnv7YQ2VkaIqmvw==/2840082515011744809.jpg");
        mAdapter = new RecommendAdapter(mDatas, getActivity());
        mListView.setAdapter(mAdapter);
    }
}
