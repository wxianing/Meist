package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.GiftsAdapter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.Bean;
import com.meist.pinfan.model.Gifts;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_gift_lists)
public class GiftListsActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.listView)
    private ListView mListView;
    private int userId;
    private int pageIndex = 1;

    private List<Gifts.DataListBean> mDatas;
    private GiftsAdapter mAdapter;
    private int checkNum;
    private int produceId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("请选择赠送的礼物");
        userId = getIntent().getIntExtra("userId", 0);
        mDatas = new ArrayList<>();
        mAdapter = new GiftsAdapter(mDatas, this);
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
        HashMap params = new HashMap();
        params.put("Keyword", "");
        params.put("sType", 0);
        params.put("PageIndex", pageIndex);
        params.put("PageSize", 8);
        HttpRequestUtils.getmInstance(GiftListsActivity.this).send(Constant.GIFT_LISTS_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                AppBean<Gifts> appBean = JSONObject.parseObject(result, new TypeReference<AppBean<Gifts>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    mDatas.addAll(appBean.getData().getDataList());
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Event(value = {R.id.back_arrows, R.id.pay_btn})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.pay_btn:
                HashMap params = new HashMap();
                params.put("Id", 0);
                params.put("ProductId", produceId);
                params.put("GiveToUserId", userId);
                HttpRequestUtils.getmInstance(GiftListsActivity.this).send(Constant.SEND_GIFT_URL, params, new HttpRequestListener() {
                    @Override
                    public void onSuccess(String result) {
                        Bean bean = JSON.parseObject(result, Bean.class);
                        if (bean != null && bean.getEnumcode() == 0) {
                            ToastUtils.show(GiftListsActivity.this, "发送礼物成功");
                            Intent intent = new Intent(GiftListsActivity.this, PresentActivity.class);
                            intent.putExtra("sType", 2);
                            startActivity(intent);
                            finish();
                        } else {
                            ToastUtils.show(GiftListsActivity.this, "发送失败");
                        }
                    }
                });
                break;
        }
    }

    private int count = -1;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        produceId = mDatas.get(position).getId();

        Log.e("produceId", ">>>>" + produceId);

        GiftsAdapter.ViewHolder vh = (GiftsAdapter.ViewHolder) view.getTag();

        vh.checkBox.toggle();
        GiftsAdapter.getIsSelected().put(Integer.valueOf(position), Boolean.valueOf(true));

        if (vh.checkBox.isChecked() == true) {
            checkNum++;
            vh.checkBox.setVisibility(View.VISIBLE);
        } else {
            checkNum--;
            vh.checkBox.setVisibility(View.GONE);
        }
        mAdapter.notifyDataSetChanged();
    }

}
