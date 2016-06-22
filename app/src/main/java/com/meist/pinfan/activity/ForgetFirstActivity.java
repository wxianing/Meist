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

@ContentView(R.layout.activity_forget_first)
public class ForgetFirstActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.phone_tv)
    private EditText phoneEt;//手机号码
    @ViewInject(R.id.auth_code)
    private EditText authCoreEt;//验证码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("忘记密码1/2");
    }

    @Event(value = {R.id.back_arrows})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
            case R.id.next_btn:
                String phoneNum = phoneEt.getText().toString().trim();
                String authCore = authCoreEt.getText().toString().trim();
                if (NullUtils.isNull(phoneNum)) {
                    if (phoneNum.length() == 11) {
                        if (NullUtils.isNull(authCore)) {
                            Intent intent = new Intent(this, ForgetSecondActivity.class);
                            intent.putExtra("PHONE", phoneNum);
                            intent.putExtra("CODE", authCore);
                            startActivity(intent);
                        } else {
                            ToastUtils.show(this, "验证码不能为空");
                        }
                    } else {
                        ToastUtils.show(this, "您输入的手机号码有误");
                    }
                } else {
                    ToastUtils.show(this, "请输入手机号码");
                }
                break;
        }
    }
}
