package com.meist.pinfan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.meist.pinfan.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_comm_shop)
public class CommShopFragment extends BaseFragment {


    private String params;
    @ViewInject(R.id.tv)
    private TextView tv;

    public CommShopFragment() {
    }

    public static CommShopFragment newIstance(String params) {
        CommShopFragment fragment = new CommShopFragment();
        Bundle bundle = new Bundle();
        bundle.putString("PARAMS", params);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            params = getArguments().getString("PARAMS");
        }
    }

    @Override
    public void onInitView() {
        tv.setText(params);
    }
}
