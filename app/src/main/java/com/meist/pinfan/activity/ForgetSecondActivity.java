package com.meist.pinfan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.NullUtils;
import com.meist.pinfan.utils.ToastUtils;

import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

@ContentView(R.layout.activity_forget_second)
public class ForgetSecondActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;
    private String phoneNum;
    private String authCore;

    @ViewInject(R.id.password_et)
    private EditText passWordEt;
    @ViewInject(R.id.affirm_pwd)
    private EditText affirmPwdEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("忘记密码2/2");
        phoneNum = getIntent().getStringExtra("PHONE");
        authCore = getIntent().getStringExtra("CODE");
    }

    @Event(value = {R.id.back_arrows, R.id.next_btn})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.next_btn:
                String passWord = passWordEt.getText().toString().trim();
                String affirmPwd = affirmPwdEt.getText().toString().trim();
                if (NullUtils.isNull(passWord) && NullUtils.isNull(affirmPwd)) {
                    if (passWord.equals(affirmPwd)) {
                        send(passWord);
                    } else {
                        ToastUtils.show(this, "两次密码不相同");
                    }
                } else {
                    ToastUtils.show(this, "密码或确认密码不能为空!");
                }
                break;
        }
    }

    private void send(String newPwd) {
        HashMap params = new HashMap();
        params.put("Mobile",phoneNum);
        params.put("Code",authCore);
        params.put("NewPassword",authCore);
        HttpRequestUtils.getmInstance().send(ForgetSecondActivity.this,Constant.FORGET_PASSWORD_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(String result) {

            }
        });
    }
}
