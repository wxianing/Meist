package com.meist.pinfan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meist.pinfan.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_present)
public class PresentActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        int sType = getIntent().getIntExtra("sType", 0);
        switch (sType) {
            case 1:
                title.setText("收到礼物");
                break;
            case 2:
                title.setText("发出礼物");
                break;
        }

    }

    @Event(R.id.back_arrows)
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }
}
