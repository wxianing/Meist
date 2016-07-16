package com.meist.pinfan.activity;

import android.view.View;
import android.widget.TextView;

import com.meist.pinfan.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * 个人动态
 */
@ContentView(R.layout.activity_person_dynamic)
public class PersonDynamicActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView title;


    @Override
    public void onInitView() {
        title.setText("个人秀场");
    }

    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }
}
