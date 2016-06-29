package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.Bean;
import com.meist.pinfan.model.User;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.SharedPreferencesUtils;
import com.meist.pinfan.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

@ContentView(R.layout.activity_person_center)
public class PersonCenterActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.title_right)
    private TextView titleRight;

    @ViewInject(R.id.sex_tv)
    private TextView sex_tv;
    @ViewInject(R.id.hunyin_tv)
    private TextView hunyin_tv;

    @ViewInject(R.id.nick_name)
    private EditText nickName;
    @ViewInject(R.id.phone_num)
    private EditText phoneNum;
    @ViewInject(R.id.age_tv)
    private EditText age_tv;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("个人资料");
        titleRight.setText("保存");
        titleRight.setVisibility(View.VISIBLE);
        User user = SharedPreferencesUtils.getUser(PersonCenterActivity.this);
        nickName.setText(SharedPreferencesUtils.getStringData(this, "NICKNAME", null));

        int sexType = SharedPreferencesUtils.getIntData(this, "SEX", 0);
        ;//性别1男2女
        switch (sexType) {
            case 1:
                sex_tv.setText("男");
                break;
            case 2:
                sex_tv.setText("女");
                break;
        }

        int hunyinType = SharedPreferencesUtils.getIntData(this, "HUNYIN", -1);
        switch (hunyinType) {
            case 0:
                hunyin_tv.setText("未婚");
                break;
            case 1:
                hunyin_tv.setText("已婚");
                break;
            case 2:
                hunyin_tv.setText("离异");
                break;
        }
        phoneNum.setText(SharedPreferencesUtils.getStringData(this, "PHONE", null));


    }

    int sexTy = 0;
    int hyType = -1;

    @Event(value = {R.id.back_arrows, R.id.sex_layout, R.id.hunyin_layout, R.id.title_right})
    private void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.sex_layout:
                intent = new Intent(PersonCenterActivity.this, SelectActivity.class);
                intent.putExtra("TYPE", 1);
                startActivityForResult(intent, 1);
                break;
            case R.id.hunyin_layout:
                intent = new Intent(PersonCenterActivity.this, SelectActivity.class);
                intent.putExtra("TYPE", 2);
                startActivityForResult(intent, 2);
                break;
            case R.id.title_right:
                ToastUtils.show(this, "正在保存");
                final String nickNames = nickName.getText().toString().trim();//昵称
                String sex = sex_tv.getText().toString().trim();
                String hunyin = hunyin_tv.getText().toString().trim();
                phone = phoneNum.getText().toString().trim();
                final String age = age_tv.getText().toString().trim();

                if (sex.equals("男"))
                    sexTy = 1;
                if (sex.equals("女"))
                    sexTy = 2;
                if (hunyin.equals("未婚"))
                    hyType = 0;
                if (hunyin.equals("已婚"))
                    hyType = 1;
                if (hunyin.equals("离异"))
                    hyType = 2;

                HashMap params = new HashMap();
                params.put("CnName", nickNames);
                params.put("Age", Integer.valueOf(age));
                params.put("Sex", sexTy);
                params.put("HunYin", hyType);
                params.put("Mobile", phone);

                HttpRequestUtils.getmInstance().send(PersonCenterActivity.this, Constant.UPDATE_MESSAGE, params, new HttpRequestListener() {
                    @Override
                    public void onSuccess(String result) {
                        Bean bean = JSON.parseObject(result, Bean.class);
                        if (bean != null && bean.getEnumcode() == 0) {
                            ToastUtils.show(PersonCenterActivity.this, "修改成功");
                            SharedPreferencesUtils.saveStringData(PersonCenterActivity.this, "NICKNAME", nickNames);
                            SharedPreferencesUtils.saveStringData(PersonCenterActivity.this, "PHONE", phone);
                            SharedPreferencesUtils.saveIntData(PersonCenterActivity.this, "SEX", sexTy);
                            SharedPreferencesUtils.saveIntData(PersonCenterActivity.this, "HUNYIN", hyType);
                            finish();
                        } else {
                            ToastUtils.show(PersonCenterActivity.this, "修改成功");
                        }
                    }
                });

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == resultCode) {
            switch (requestCode) {
                case 1:
                    sex_tv.setText(data.getStringExtra("VALUE"));
                    break;
                case 2:
                    hunyin_tv.setText(data.getStringExtra("VALUE"));
                    break;
            }
        }

    }
}
