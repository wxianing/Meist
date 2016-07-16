package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.model.HotLists;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package：com.meist.pinfan.adapter
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/21
 */
public class HomeHotAdapter extends BasicAdapter<HotLists> {

    public HomeHotAdapter(List<HotLists> mData, Context context) {
        super(mData, context);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        HotLists data = mData.get(position);
        ViewHolder vh = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_hotlist_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(data.getIcon(), vh.imageView, MyApplication.options);
        vh.contentTv.setText(data.getName());

        return convertView;
    }

    private static class ViewHolder {

        @ViewInject(R.id.imageView)
        private ImageView imageView;
        @ViewInject(R.id.content_tv)
        private TextView contentTv;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
