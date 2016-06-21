package com.meist.pinfan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.meist.pinfan.R;
import com.meist.pinfan.http.HttpRequestListener;
import com.meist.pinfan.http.HttpRequestUtils;
import com.meist.pinfan.utils.Constant;
import com.meist.pinfan.utils.NullUtils;
import com.meist.pinfan.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

@ContentView(R.layout.activity_reset_pwd)
public class ResetPwdActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "ResetPwdActivity";
    @ViewInject(R.id.title_tv)
    private TextView title;//标题
    @ViewInject(R.id.back_arrows)
    private ImageView backImg;

    @ViewInject(R.id.oid_password)
    private EditText oidEt;//旧密码
    @ViewInject(R.id.new_password)
    private EditText newEt;//新密码
    @ViewInject(R.id.affirm_btn)
    private Button affirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        title.setText("修改密码");
    }

    @Override
    public void onInitData() {
        super.onInitData();

    }

    @Override
    public void onInitEvent() {
        super.onInitEvent();
        backImg.setOnClickListener(this);
        affirmBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.affirm_btn:
                String oidPwd = oidEt.getText().toString().trim();
                String newPwd = newEt.getText().toString().trim();
                if (NullUtils.isNull(oidPwd) && NullUtils.isNull(newPwd)) {
                    HashMap params = new HashMap();
                    params.put("OldPassword", oidPwd);
                    params.put("NewPassword", newPwd);
                    HttpRequestUtils.getmInstance().send(Constant.UPDATE_PWD_URL, params, new HttpRequestListener() {
                        @Override
                        public void onSuccess(JSONObject jsonObject) {
                            Log.e(TAG, jsonObject.toString());
                            try {
                                JSONObject obj = new JSONObject(jsonObject.toString());
                                int enumcode = obj.getInt("enumcode");
                                if (enumcode == 0) {
                                    ToastUtils.show(ResetPwdActivity.this, "密码修改成功");
                                    ResetPwdActivity.this.finish();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

                break;
            case R.id.back_arrows:
                finish();
                break;
        }

    }
}
