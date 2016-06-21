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
    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_hotlist_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(mData.get(position).getIcon(), vh.imageView, MyApplication.options);
//        vh.name.setText(mData.get(position).getName());
        vh.price.setText("￥" + mData.get(position).getFemalePrice());
        vh.orderCount.setText("报名人数：" + mData.get(position).getFemaleSum() + mData.get(position).getManSum() + "人");
        return convertView;
    }

    private static class ViewHolder {

        @ViewInject(R.id.imageView)
        private ImageView imageView;
//        @ViewInject(R.id.name_tv)
//        private TextView name;
        @ViewInject(R.id.price_tv)
        private TextView price;
        @ViewInject(R.id.order_count)
        private TextView orderCount;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
