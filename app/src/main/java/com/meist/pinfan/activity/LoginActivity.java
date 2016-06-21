package com.meist.pinfan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initView();

    }

    private void initView() {
        mCallBack = new HttpCallBack();
        //自动登录
        boolean isLogin = SharedPreferencesUtils.getLoginTag(this);
        if (isLogin) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        user = SharedPreferencesUtils.getStringData(this, "USERNAME", null);
        pwd = SharedPreferencesUtils.getStringData(this, "PASSWORD", null);
        if (NullUtils.isNull(user)) {
            userNameEt.setText(user);
        }
        if (NullUtils.isNull(pwd)) {
            passWordEt.setText(pwd);
        }

    }

    /**
     * 登录点击事件
     *
     * @param v
     */
    @Event(value = {R.id.login_btn}, type = View.OnClickListener.class)
    private void loginBtn(View v) {

        userName = userNameEt.getText().toString().trim();
        passWord = passWordEt.getText().toString().trim();

        HashMap params = new HashMap();
        params.put("UserName", userName);
        params.put("Password", passWord);

        if (NullUtils.isNull(userName) && NullUtils.isNull(passWord)) {
            HttpRequestUtils.getmInstance().send(Constant.LOGIN_URL, params, mCallBack);
        } else {
            ToastUtils.show(this, "用户名或密码不能为空!");
        }
    }

    class HttpCallBack extends HttpRequestListener {

        @Override
        public void onSuccess(org.json.JSONObject jsonObject) {
            AppBean<User> appBean = JSONObject.parseObject(jsonObject.toString(), new TypeReference<AppBean<User>>() {
            });
            int enumcode = appBean.getEnumcode();
            if (enumcode == 0) {
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
