package com.meist.pinfan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.meist.pinfan.utils.Utility;

import org.xutils.x;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Utility.setActionBar(this);
        x.view().inject(this);
    }
}