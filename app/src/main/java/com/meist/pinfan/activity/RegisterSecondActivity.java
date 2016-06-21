package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.utils.NullUtils;
import com.meist.pinfan.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_register_second)
public class RegisterSecondActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;
    @ViewInject(R.id.password_et)
    private EditText passWordEt;
    @ViewInject(R.id.affirm_pwd)
    private EditText affirmPwdEt;
    private String phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("注册2/3");
        phoneNum = getIntent().getStringExtra("PHONE");
    }

    @Event(value = {R.id.back_arrows, R.id.next_btn})
    private void click(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.next_btn:
                String passWord = passWordEt.getText().toString().trim();
                String affirmPwd = affirmPwdEt.getText().toString().trim();
                if (NullUtils.isNull(passWord) && NullUtils.isNull(affirmPwd)) {
                    if (passWord.equals(affirmPwd)) {
                        Intent intent = new Intent(this, RegisterThirdActivity.class);
                        intent.putExtra("PASSWORD", passWord);
                        intent.putExtra("PHONE", phoneNum);
                        startActivity(intent);
                    } else {
                        ToastUtils.show(this, "两次密码不相同");
                    }
                } else {
                    ToastUtils.show(this, "密码或确认密码不能为空!");
                }
                break;
        }
    }
}
