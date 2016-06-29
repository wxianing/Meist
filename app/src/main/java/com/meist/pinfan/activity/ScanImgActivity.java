package com.meist.pinfan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_scan_img)
public class ScanImgActivity extends BaseActivity {
    @ViewInject(R.id.img)
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() {
        super.onInitView();
        String imageUrl = getIntent().getStringExtra("IMAGEURL");
        if (imageUrl != null && !"".equals(imageUrl)) {
            ImageLoader.getInstance().displayImage(imageUrl, mImageView, MyApplication.options);
        }
    }

    @Event(R.id.img)
    private void onClick(View v) {
        finish();
    }
}
