package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.model.AppBean;
import com.meist.pinfan.model.User;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.NullUtils;
import com.meist.pinfan.utils.SharedPreferencesUtils;
import com.meist.pinfan.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;

/**
 * Package：com.meist.pinfan.activity
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    public static LoginActivity loginActivity;
    private HttpCallBack mCallBack;
    @ViewInject(R.id.username_edittext)
    private EditText userNameEt;
    @ViewInject(R.id.password_edittext)
    private EditText passWordEt;
    private String TAG = "LoginActivity";
    private String userName;
    private String passWord;
    private String user;
    private String pwd;
    @ViewInject(R.id.checked_img)
    private CheckBox checkBox;
    private boolean isRmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        loginActivity = this;
        initView();
        initEvent();
    }

    private void initEvent() {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferencesUtils.savebooleanData(LoginActivity.this, "isRmb", true);

                } else {
                    SharedPreferencesUtils.savebooleanData(LoginActivity.this, "isRmb", false);
                }
            }
        });
    }

    private void initView() {
        mCallBack = new HttpCallBack();
        //自动登录
        boolean isLogin = SharedPreferencesUtils.getLoginTag(this);
        if (false) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        //记住密码
        isRmb = SharedPreferencesUtils.getbooleanData(LoginActivity.this, "isRmb", false);
        if (isRmb) {
            user = SharedPreferencesUtils.getStringData(this, "USERNAME", null);
            pwd = SharedPreferencesUtils.getStringData(this, "PASSWORD", null);
            checkBox.setChecked(true);
            if (NullUtils.isNull(user)) {
                userNameEt.setText(user);
            }
            if (NullUtils.isNull(pwd)) {
                passWordEt.setText(pwd);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * 记住密码
         */

    }

    /**
     * 登录点击事件
     *
     * @param v
     */
    @Event(value = {R.id.login_btn, R.id.register_tv, R.id.forget_pwd}, type = View.OnClickListener.class)
    private void click(View v) {

        switch (v.getId()) {
            case R.id.login_btn:
                userName = userNameEt.getText().toString().trim();
                passWord = passWordEt.getText().toString().trim();

                HashMap params = new HashMap();
                params.put("UserName", userName);
                params.put("Password", passWord);

                if (NullUtils.isNull(userName) && NullUtils.isNull(passWord)) {
                    HttpRequestUtils.getmInstance().send(LoginActivity.this, Constant.LOGIN_URL, params, mCallBack);
                } else {
                    ToastUtils.show(this, "用户名或密码不能为空!");
                }
                break;
            case R.id.register_tv:
                startActivity(new Intent(this, RegisterFirstActivity.class));
                break;
            case R.id.forget_pwd:
                startActivity(new Intent(this, ForgetFirstActivity.class));
                break;
        }
    }

    class HttpCallBack extends HttpRequestListener {

        @Override
        public void onSuccess(String resutl) {
            AppBean<User> appBean = JSONObject.parseObject(resutl, new TypeReference<AppBean<User>>() {
            });
            if (appBean != null && appBean.getEnumcode() == 0) {
                SharedPreferencesUtils.saveStringData(LoginActivity.this, "NICKNAME", appBean.getData().getCnName());
                SharedPreferencesUtils.saveStringData(LoginActivity.this, "PHONE", appBean.getData().getMobile());
                SharedPreferencesUtils.saveIntData(LoginActivity.this, "SEX", appBean.getData().getSex());
                SharedPreferencesUtils.saveIntData(LoginActivity.this, "HUNYIN", appBean.getData().getHunYin());

                SharedPreferencesUtils.saveStringData(LoginActivity.this, "USERNAME", userName);
                SharedPreferencesUtils.saveStringData(LoginActivity.this, "PASSWORD", passWord);

                SharedPreferencesUtils.saveUser(LoginActivity.this, appBean.getData());
                SharedPreferencesUtils.save(LoginActivity.this, "CODE", appBean.getData().getCode());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                SharedPreferencesUtils.setLoginTag(LoginActivity.this, true);
                finish();
            } else {
                ToastUtils.show(LoginActivity.this, "登录失败！");
            }
        }
    }
}
