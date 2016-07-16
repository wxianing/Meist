package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package： com.meist.pinfan.adapter
 * Author： wxianing
 * 作  用：
 * 时  间： 2016/7/16
 */
public class RecommendAdapter extends BasicAdapter<String> {
    public RecommendAdapter(List<String> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_recommend_list, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(mData.get(position), vh.img, MyApplication.options);
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.img)
        private ImageView img;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
