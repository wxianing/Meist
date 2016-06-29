package com.meist.pinfan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.OrderDetails;
import com.meist.pinfan.utils.Constant;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

@ContentView(R.layout.activity_order_details)
public class OrderDetailsActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;
    private int oid;
    private AppBean<OrderDetails> appBean;

    @ViewInject(R.id.produce_name)
    private TextView produceName;
    @ViewInject(R.id.order_num)
    private TextView orderNum;
    @ViewInject(R.id.create_order_time)
    private TextView createOrderDate;
    @ViewInject(R.id.report_date)
    private TextView repostDate;
    @ViewInject(R.id.total_money)
    private TextView totalMoney;
    @ViewInject(R.id.pay_btn)
    private Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("订单详情");
        oid = getIntent().getIntExtra("OID", 0);
    }

    @Override
    public void onInitData() {
        super.onInitData();
        HashMap params = new HashMap();
        params.put("Id", oid);
        HttpRequestUtils.getmInstance().send(OrderDetailsActivity.this,Constant.ORDER_DETAILS_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                appBean = JSONObject.parseObject(result, new TypeReference<AppBean<OrderDetails>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    sendDataView(appBean);
                }
            }
        });
    }

    private void sendDataView(AppBean<OrderDetails> data) {
        produceName.setText("商品名: " + data.getData().getOrderdetails().get(0).getProductName());
        orderNum.setText(" 订单号: " + data.getData().getOrderNo());
        createOrderDate.setText("下单时间: " + data.getData().getOrderDate());
        repostDate.setText("预定时间: " + data.getData().getReportDateTime());
        totalMoney.setText("总价: ￥" + data.getData().getTotalMoney());

        int payState = data.getData().getPayState();
        switch (payState){
            case 0:
                payBtn.setText("立即支付");
                break;
            case 1:
                payBtn.setText("支付完成");

                break;
        }
    }

    @Event(value = {R.id.back_arrows})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }
}
