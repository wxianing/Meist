package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.adapter.CaixiDetailAdapter;
import com.meist.pinfan.adapter.ImageAadpter;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.Bean;
import com.meist.pinfan.model.ProductDetails;
import com.meist.pinfan.model.ProductEntitys;
import com.meist.pinfan.model.User;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.LogUtils;
import com.meist.pinfan.utils.SharedPreferencesUtils;
import com.meist.pinfan.utils.ToastUtils;
import com.meist.pinfan.view.AutoAdjustHeightImageView;
import com.meist.pinfan.view.MeasureListView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_product_details)
public class ProductDetailsActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private int oid;
    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.banner_img)
    private AutoAdjustHeightImageView bannerImg;//头部图片
    @ViewInject(R.id.produce_name)
    private TextView produceName;
    @ViewInject(R.id.introduct_tv)
    private TextView introduct;//商品名称
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
    private double price;
    @ViewInject(R.id.total_comment)
    private TextView totalComment;//评论数


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {

        super.onInitView();
        title.setText("商品详情");
        oid = getIntent().getIntExtra("OID", 0);
        bannerImg.setFocusable(true);
        bannerImg.setFocusableInTouchMode(true);
        bannerImg.requestFocus();

        mDatas = new ArrayList<>();
        mAdapter = new CaixiDetailAdapter(mDatas, this);
        mListView.setAdapter(mAdapter);
        imageUrls = new ArrayList<>();
        imageAadpter = new ImageAadpter(imageUrls, this);
        imgListView.setAdapter(imageAadpter);
        imgListView.setOnItemClickListener(this);
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
    @Event(value = {R.id.back_arrows, R.id.select_data, R.id.submit_order, R.id.collect_btn, R.id.shop_layout, R.id.total_comment})
    private void onClick(View v) {

        Intent intent = null;
        switch (v.getId()) {
            case R.id.select_data:
                intent = new Intent(this, DateListsActivity.class);
                intent.putExtra("PRODUCTDETAILS", (Serializable) appBean.getData());
                startActivityForResult(intent, Constant.ENUMCODE);
                break;
            case R.id.back_arrows:
                finish();
                break;
            case R.id.collect_btn:
                sendCollectMsg();
                break;
            case R.id.shop_layout:
                intent = new Intent(this, ShopDetailsActivity.class);
                intent.putExtra("OID", appBean.getData().getPdt_SortOction().getStructureId());
                startActivity(intent);
                break;
            case R.id.submit_order:
                submitOrder();
                break;
            case R.id.total_comment:
                intent = new Intent(this, ProduceCommentActivity.class);
                startActivity(intent);
                break;

        }
    }

    //提交订单
    private void submitOrder() {
        User user = SharedPreferencesUtils.getUser(ProductDetailsActivity.this);
        String dateTime = datatime.getText().toString().trim();
        if (dateTime.equals("请选择预定日期")) {
            ToastUtils.show(ProductDetailsActivity.this, "请选择预定日期");
            return;
        }

        List<ProductEntitys> list = new ArrayList<>();

        HashMap params = new HashMap();

        params.put("ProductId", oid);
        params.put("ProductEntityId", oid);
        params.put("Qty", 1);
        params.put("Price", price);
        params.put("RedPacketId", 0);
        params.put("OrderTime", dateTime);
        params.put("TotalMoney", price);
        params.put("Mobile", user.getMobile());
        params.put("detaillist", list);

        HttpRequestUtils.getmInstance().send(ProductDetailsActivity.this, Constant.SAVE_ORDER_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("oerder" + result);
                Bean bean = JSON.parseObject(result, Bean.class);
                if (bean != null && bean.getEnumcode() == 0) {
                    Intent intent = new Intent(ProductDetailsActivity.this, SubmitOrderActivity.class);
                    intent.putExtra("PRODUCENAME", appBean.getData().getName());
                    intent.putExtra("ORDER", result);
                    startActivity(intent);
                }
            }
        });
    }

    //收藏
    private void sendCollectMsg() {
        int isCollect = 0;
        HashMap params = new HashMap();
        params.put("FKId", appBean.getData().getID());//商品Id
        params.put("FKType", 3);//
        final String value = collectBtn.getText().toString().trim();
        if (value.equals("立即收藏")) {
            params.put("IsCollect", 1);//1.收藏
        }

        if (value.equals("已收藏")) {
            params.put("IsCollect", 0);//0.取消
        }
        HttpRequestUtils.getmInstance().send(ProductDetailsActivity.this, Constant.COLLECT_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                Bean bean = JSON.parseObject(result, Bean.class);

                if (bean != null && bean.getEnumcode() == 0) {
                    if (value.equals("立即收藏")) {
                        collectBtn.setText("已收藏");
                        ToastUtils.show(ProductDetailsActivity.this, "收藏成功");
                    }
                    if (value.equals("已收藏")) {
                        collectBtn.setText("立即收藏");
                        ToastUtils.show(ProductDetailsActivity.this, "取消收藏成功");
                    }
                } else {
                    ToastUtils.show(ProductDetailsActivity.this, bean.getMsg());
                }
            }
        });
    }

    //请求数据
    private void initData() {
        HashMap params = new HashMap();
        params.put("id", oid);
        HttpRequestUtils.getmInstance().send(ProductDetailsActivity.this, Constant.CAIXI_DETAILS_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                appBean = JSONObject.parseObject(result, new TypeReference<AppBean<ProductDetails>>() {
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

    //给控件赋值
    private void sendDataView(AppBean<ProductDetails> appBean) {
        int sexType = SharedPreferencesUtils.getIntData(this, "SEX", 0);
        ImageLoader.getInstance().displayImage(appBean.getData().getIcon(), bannerImg, MyApplication.options);
        introduct.setText(appBean.getData().getIntroduct());
        produceName.setText(appBean.getData().getName());
        price = -1;
        switch (sexType) {
            case 1:
                price = appBean.getData().getManprice();
                break;
            case 2:
                price = appBean.getData().getFemaleprice();
                break;

        }
        producePrice.setText("￥" + price);//男女价格不同

        joinCount.setText("报名人数(男：" + appBean.getData().getMansum() + "人/女：" + appBean.getData().getFemalesum() + "人)");
        shopName.setText(appBean.getData().getPdt_SortOction().getStructureName());
        phoneNum.setText(appBean.getData().getPdt_SortOction().getPhone());
        linkMan.setText(appBean.getData().getPdt_SortOction().getLinkMan());
        totalComment.setText("共有" + appBean.getData().getTotalComment() + "人评价");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.ENUMCODE) {
            if (data != null) {
                String result = data.getExtras().getString("result");
                datatime.setText(result);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String imageUrl = imageUrls.get(position);
        Intent intent = new Intent(ProductDetailsActivity.this, ScanImgActivity.class);
        intent.putExtra("IMAGEURL", imageUrl);
        startActivity(intent);
    }
}
