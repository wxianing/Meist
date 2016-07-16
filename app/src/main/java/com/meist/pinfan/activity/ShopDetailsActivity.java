package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.ShopDetails;
import com.meist.pinfan.utils.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONObject;
import org.w3c.dom.Text;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

/**
 * 店铺详情
 */
@ContentView(R.layout.activity_shop_details)
public class ShopDetailsActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.title_right)
    private TextView titleRight;
    private int oid;
    @ViewInject(R.id.banner_img)
    private ImageView bannerImg;
    @ViewInject(R.id.shop_name)
    private TextView shopName;
    @ViewInject(R.id.link_man)
    private TextView linkMan;
    @ViewInject(R.id.link_phone)
    private TextView linkPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        titleRight.setText("更多优惠");
        titleRight.setVisibility(View.VISIBLE);
        title.setText("商家详情");
        oid = getIntent().getIntExtra("OID", 0);
    }

    @Override
    public void onInitData() {
        super.onInitData();
        HashMap params = new HashMap();
        params.put("Id", oid);
        HttpRequestUtils.getmInstance().send(ShopDetailsActivity.this, Constant.SHOP_DETAILS_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                AppBean<ShopDetails> appBean = com.alibaba.fastjson.JSONObject.parseObject(result, new TypeReference<AppBean<ShopDetails>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    sendDataView(appBean.getData());
                }
            }
        });
    }

    private void sendDataView(ShopDetails data) {
        ImageLoader.getInstance().displayImage(data.getPhoto(), bannerImg, MyApplication.options);
        shopName.setText(data.getStructureName());
        linkMan.setText("联系人:" + data.getLinkMan());
        linkPhone.setText("联系电话:" + data.getPhone());
    }

    @Event(value = {R.id.back_arrows, R.id.title_right})
    private void click(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.title_right:
                Intent intent = new Intent();
                intent.setClass(this, MostOnSaleActivity.class);
                startActivity(intent);
                break;
        }
    }
}
