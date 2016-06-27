package com.meist.pinfan.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.RedEntity;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.List;

@ContentView(R.layout.activity_red_package)
public class RedPackageActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView title;
    private int totalMoney;

    private List<RedEntity.DataListBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("可用红包");
        totalMoney = getIntent().getIntExtra("TOTALMONEY", 0);
    }

    @Override
    public void onInitData() {
        super.onInitData();
        HashMap params = new HashMap();
        params.put("", totalMoney);
        HttpRequestUtils.getmInstance(RedPackageActivity.this).send(Constant.RED_PACKAGE_LIST, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                List<RedEntity.DataListBean> list = null;
                AppBean<RedEntity> appBean = JSONObject.parseObject(result, new TypeReference<AppBean<RedEntity>>() {
                });
                if (appBean != null && appBean.getEnumcode() == 0) {
                    list = appBean.getData().getDataList();
                    if (!list.isEmpty()) {
                        ToastUtils.show(RedPackageActivity.this, "暂无可用红包");
                    }
                }
            }
        });
    }
}
