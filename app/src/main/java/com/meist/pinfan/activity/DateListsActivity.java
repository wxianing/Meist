package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.adapter.DateSelectAdapter;
import com.meist.pinfan.model.ProductDetails;
import com.meist.pinfan.utils.Constant;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_date_lists)
public class DateListsActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @ViewInject(R.id.title_tv)
    private TextView title;

    private ProductDetails productDetails;
    @ViewInject(R.id.mlist_view)
    private ListView mListView;
    private List<ProductDetails.OrderDateListBean> mDatas;
    private DateSelectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("请选择预定日期");
        mDatas = new ArrayList<>();
        productDetails = (ProductDetails) getIntent().getSerializableExtra("PRODUCTDETAILS");
        Log.e(">>", ">>>>" + productDetails.getOrderDateList().size());
        mDatas.addAll(productDetails.getOrderDateList());
        mAdapter = new DateSelectAdapter(mDatas, this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onInitEvent() {
        super.onInitEvent();
        mListView.setOnItemClickListener(this);
    }

    @Event(value = {R.id.back_arrows})
    private void click(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("result", mDatas.get(position).getDate());
        setResult(Constant.ENUMCODE, intent);
        finish();
    }
}
