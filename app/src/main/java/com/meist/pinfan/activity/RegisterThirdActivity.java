package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.SharedPreferencesUtils;
import com.meist.pinfan.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

@ContentView(R.layout.activity_register_third)
public class RegisterThirdActivity extends BaseActivity {
    private static final String TAG = "RegisterThirdActivity";
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.sex_rg)
    private RadioGroup sexRg;
    @ViewInject(R.id.hunyin_rg)
    private RadioGroup hunyinRg;
    private String sex;
    private String hunyin;
    @ViewInject(R.id.nicename_et)
    private EditText nicenameEt;
    private String password;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("注册3/3");

        password = getIntent().getStringExtra("PASSWORD");
        phone = getIntent().getStringExtra("PHONE");

        ((RadioButton) sexRg.getChildAt(0)).setChecked(true);
        ((RadioButton) hunyinRg.getChildAt(0)).setChecked(true);
        RadioButton sexRb = (RadioButton) findViewById(sexRg.getCheckedRadioButtonId());
        RadioButton hunyinRb = (RadioButton) findViewById(hunyinRg.getCheckedRadioButtonId());
        sex = sexRb.getText().toString();
        hunyin = hunyinRb.getText().toString();
    }

    @Override
    public void onInitEvent() {
        super.onInitEvent();
        sexRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioButtonId = group.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) RegisterThirdActivity.this.findViewById(radioButtonId);
                Log.e("性别:", ">>>>:" + rb.getText());
                sex = rb.getText().toString();
            }
        });
        hunyinRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioButtonId = group.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) RegisterThirdActivity.this.findViewById(radioButtonId);
                Log.e("婚姻状况:", ">>>>:" + rb.getText());
                hunyin = rb.getText().toString();
            }
        });
    }

    @Event(value = {R.id.back_arrows, R.id.next_btn})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.next_btn:
                Log.e(TAG, sex + ">>>" + hunyin);
                send();
                break;
        }
    }

    private void send() {
        String niceName = nicenameEt.getText().toString().trim();
        HashMap params = new HashMap();
        params.put("CnName", niceName);
        params.put("UserName", phone);
        params.put("Pwd", password);
        params.put("Code", "");
//        params.put("Age", 0);
        params.put("Sex", getsex(sex));
        params.put("HunYin", getHunyin(hunyin));
        params.put("Mobile", phone);
        HttpRequestUtils.getmInstance().send(RegisterThirdActivity.this,Constant.REGISTER_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject obj = new JSONObject(result);

                    int enumcode = obj.getInt("enumcode");
                    if (enumcode == 0) {
                        MyApplication.getmInstance().closeActivitys();
                        if (LoginActivity.loginActivity != null) {
                            LoginActivity.loginActivity.finish();
                            LoginActivity.loginActivity = null;
                        }

                        ToastUtils.show(RegisterThirdActivity.this, "注册成功");

                        SharedPreferencesUtils.saveStringData(RegisterThirdActivity.this, "USERNAME", phone);
                        SharedPreferencesUtils.saveStringData(RegisterThirdActivity.this, "PASSWORD", password);
                        Intent intent = new Intent(RegisterThirdActivity.this, LoginActivity.class);
                        startActivity(intent);

                        RegisterThirdActivity.this.finish();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private int getsex(String value) {
        if (value.equals("男")) {
            return 1;
        } else if (value.equals("女")) {
            return 0;
        } else {
            return 1;
        }
    }

    private int getHunyin(String value) {
        if (value.equals("未婚")) {
            return 0;
        } else if (value.equals("已婚")) {
            return 1;
        } else if (value.equals("离异")) {
            return 2;
        } else {
            return 0;
        }
    }
}
