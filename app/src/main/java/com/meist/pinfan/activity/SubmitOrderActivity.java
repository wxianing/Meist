package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.OrderEntitys;
import com.meist.pinfan.model.User;
import com.meist.pinfan.utils.SharedPreferencesUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_submit_order)
public class SubmitOrderActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.produce_name)
    private TextView produceNames;
    @ViewInject(R.id.phone_tv)
    private TextView phoneTv;
    @ViewInject(R.id.total_money)
    private TextView totalMoney;
    @ViewInject(R.id.need_pay)
    private TextView needPay;

    private String produceName;
    private AppBean<OrderEntitys> appBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("提交订单");

        produceName = getIntent().getStringExtra("PRODUCENAME");
        String result = getIntent().getStringExtra("ORDER");
        appBean = JSONObject.parseObject(result, new TypeReference<AppBean<OrderEntitys>>() {
        });
        if (appBean != null && appBean.getEnumcode() == 0) {
            totalMoney.setText("总价: " + appBean.getData().getTotalMoney());
            needPay.setText("还需支付： " + appBean.getData().getTotalMoney());
        }

        produceNames.setText("商品： " + produceName);
        phoneTv.setText("手机号:" + SharedPreferencesUtils.getStringData(this, "PHONE", null));

    }

    @Event(value = {R.id.back_arrows, R.id.red_package})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.red_package:
                Intent intent = new Intent(this, RedPackageActivity.class);
                intent.putExtra("TOTALMONEY", appBean.getData().getTotalMoney());
                startActivity(intent);
                break;
        }
    }
}
