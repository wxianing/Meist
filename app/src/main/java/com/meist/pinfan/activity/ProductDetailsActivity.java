package com.meist.pinfan.activity;

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
import com.meist.pinfan.model.ProductDetails;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.view.MeasureListView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_product_details)
public class ProductDetailsActivity extends BaseActivity {

    private int oid;
    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.banner_img)
    private ImageView bannerImg;//头部图片
    @ViewInject(R.id.produce_name)
    private TextView produceName;//商品名称
    @ViewInject(R.id.produce_price)
    private TextView producePrice;//商品价格
    @ViewInject(R.id.join_count)
    private TextView joinCount;//参加人数
    @ViewInject(R.id.shop_name)
    private TextView shopName;//店铺名称
    @ViewInject(R.id.phone_num)
    private TextView phoneNum;//电话号码
    @ViewInject(R.id.link_name)
    private TextView linkMan;//联系人
    @ViewInject(R.id.mlist_view)
    private MeasureListView mListView;

    private List<ProductDetails.CaiXiDetailBean> mDatas;
    private CaixiDetailAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("商品详情");
        oid = getIntent().getIntExtra("OID", 0);
        mDatas = new ArrayList<>();
        mAdapter = new CaixiDetailAdapter(mDatas, this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onInitData() {
        super.onInitData();
        initData();
    }

    /**
     * 点击事件的处理
     *
     * @param v
     */
    @Event(value = {R.id.back_arrows})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }

    private void initData() {
        HashMap params = new HashMap();
        params.put("id", oid);
        HttpRequestUtils.getmInstance().send(Constant.CAIXI_DETAILS_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                AppBean<ProductDetails> appBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBean<ProductDetails>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    sendDataView(appBean);
                    mDatas.addAll(appBean.getData().getCaiXiDetail());
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void sendDataView(AppBean<ProductDetails> appBean) {
        ImageLoader.getInstance().displayImage(appBean.getData().getIcon(), bannerImg, MyApplication.options);
        produceName.setText(appBean.getData().getName());
        producePrice.setText("￥" + appBean.getData().getFemaleprice());//男女价格不同
        joinCount.setText("报名人数(男：" + appBean.getData().getMansum() + "人/女：" + appBean.getData().getFemalesum() + "人)");
        shopName.setText(appBean.getData().getPdt_SortOction().getStructureName());
        phoneNum.setText(appBean.getData().getPdt_SortOction().getPhone());
        linkMan.setText(appBean.getData().getPdt_SortOction().getLinkMan());
    }
}
