package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meist.pinfan.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_select)
public class SelectActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.sex_layout)
    private LinearLayout sexLayout;
    @ViewInject(R.id.hunyin_layout)
    private LinearLayout hunyinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        int type = getIntent().getIntExtra("TYPE", 0);
        switch (type) {
            case 1:
                title.setText("请选择性别");
                sexLayout.setVisibility(View.VISIBLE);
                hunyinLayout.setVisibility(View.GONE);
                break;
            case 2:
                title.setText("请选择婚姻状况");
                sexLayout.setVisibility(View.GONE);
                hunyinLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Event(value = {R.id.sex_man, R.id.sex_woman, R.id.hunyin_married, R.id.hunyin_spinsterhood, R.id.hunyin_divorced, R.id.back_arrows})
    private void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.sex_man:
                intent.putExtra("VALUE", "男");
                setResult(1, intent);
                finish();

                break;
            case R.id.sex_woman:
                intent.putExtra("VALUE", "女");
                setResult(1, intent);
                finish();
                break;
            case R.id.hunyin_married:
                intent.putExtra("VALUE", "已婚");
                setResult(2, intent);
                finish();
                break;
            case R.id.hunyin_spinsterhood:
                intent.putExtra("VALUE", "未婚");
                setResult(2, intent);
                finish();
                break;
            case R.id.hunyin_divorced:
                intent.putExtra("VALUE", "离异");
                setResult(2, intent);
                finish();
                break;
            case R.id.back_arrows:
                finish();
                break;
        }

    }
}
