package com.meist.pinfan.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.meist.pinfan.R;
import com.meist.pinfan.fragment.ShopFragment;

import org.xutils.view.annotation.ContentView;

@ContentView(R.layout.activity_resort_shop)
public class ResortShopActivity extends BaseActivity {

    @Override
    public void onInitView() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.layout, new ShopFragment());
        ft.commit();
    }
}
