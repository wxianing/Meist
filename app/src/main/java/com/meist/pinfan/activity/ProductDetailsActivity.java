package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.CaixiDetailAdapter;
import com.meist.pinfan.adapter.ImageAadpter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.ProductDetails;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.ToastUtils;
import com.meist.pinfan.view.AutoAdjustHeightImageView;
import com.meist.pinfan.view.MeasureListView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_product_details)
public class ProductDetailsActivity extends BaseActivity {

    private int oid;
    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.banner_img)
    private AutoAdjustHeightImageView bannerImg;//头部图片
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
    //图片列表
    @ViewInject(R.id.img_list)
    private MeasureListView imgListView;
    private List<String> imageUrls;
    private ImageAadpter imageAadpter;
    @ViewInject(R.id.data_time)
    private TextView datatime;
    private AppBean<ProductDetails> appBean;
    @ViewInject(R.id.collect_btn)
    private Button collectBtn;

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
        imageUrls = new ArrayList<>();
        imageAadpter = new ImageAadpter(imageUrls, this);
        imgListView.setAdapter(imageAadpter);
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
    @Event(value = {R.id.back_arrows, R.id.select_data, R.id.submit_order, R.id.collect_btn})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_data:
                Intent intent = new Intent(this, DateListsActivity.class);
                intent.putExtra("PRODUCTDETAILS", (Serializable) appBean.getData());
                startActivityForResult(intent, Constant.ENUMCODE);
                break;
            case R.id.back_arrows:
                finish();
                break;
            case R.id.collect_btn:
                sendCollectMsg();
                break;
            case R.id.submit_order:

                break;
        }
    }

    private void sendCollectMsg() {
        int isCollect = 0;
        HashMap params = new HashMap();
        params.put("FKId", appBean.getData().getID());//商品Id
        params.put("FKType", 3);//
        final String value = collectBtn.getText().toString().trim();
        if (value.equals("立即收藏")) {
            params.put("IsCollect", 1);//1.收藏
        } else {
            params.put("IsCollect", 0);//0.取消
        }
        HttpRequestUtils.getmInstance().send(Constant.COLLECT_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    JSONObject obj = new JSONObject(jsonObject.toString());
                    int enumcode = obj.getInt("enumcode");
                    if (enumcode == 0) {
                        if (value.equals("立即收藏")) {
                            collectBtn.setText("已收藏");
                            ToastUtils.show(ProductDetailsActivity.this, "收藏成功");
                        }
                        if (value.equals("已收藏")) {
                            collectBtn.setText("立即收藏");
                            ToastUtils.show(ProductDetailsActivity.this, "取消收藏成功");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initData() {
        HashMap params = new HashMap();
        params.put("id", oid);
        HttpRequestUtils.getmInstance().send(Constant.CAIXI_DETAILS_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                appBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBean<ProductDetails>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    sendDataView(appBean);
                    mDatas.addAll(appBean.getData().getCaiXiDetail());
                    mAdapter.notifyDataSetChanged();
                    imageUrls.addAll(appBean.getData().getPictures());
                    imageAadpter.notifyDataSetChanged();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data.getExtras().getString("result");
        datatime.setText(result);
    }
}
