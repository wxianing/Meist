package com.meist.pinfan.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.meist.pinfan.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_personal_show)
public class PersonalShowActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;

    @Override
    public void onInitView() {
        title.setText("个人秀场");
    }

    @Event(value = {R.id.back_arrows, R.id.person_dynamic, R.id.always_shop})
    private void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.person_dynamic:
                intent = new Intent(this, PersonDynamicActivity.class);
                startActivity(intent);
                break;
            case R.id.always_shop:
                intent = new Intent(this, ResortShopActivity.class);
                startActivity(intent);
                break;
        }
    }

}
