package com.meist.pinfan.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.adapter.SectionsPagerAdapter;
import com.meist.pinfan.fragment.CommShopFragment;
import com.meist.pinfan.model.Fragments;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_most_on_sale)
public class MostOnSaleActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView title;

    @ViewInject(R.id.tab_layout)
    private TabLayout tabLayout;
    @ViewInject(R.id.container)
    private ViewPager mViewPager;
    private List<Fragments> fragments;
    private SectionsPagerAdapter mAdapter;

    @Override
    public void onInitView() {
        title.setText("更多优惠");
        fragments = new ArrayList<>();
        fragments.add(new Fragments(CommShopFragment.newIstance("门店团购"), "门店团购"));
        fragments.add(new Fragments(CommShopFragment.newIstance("私人定制"), "私人定制"));
        fragments.add(new Fragments(CommShopFragment.newIstance("商务洽谈"), "商务洽谈"));
        mAdapter = new SectionsPagerAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Event(value = {R.id.back_arrows})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrows:
                finish();
                break;
        }
    }
}
