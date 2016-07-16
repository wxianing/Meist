package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.model.ShopLists;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package com.meist.pinfan.adapter
 * 作  用:
 * Author: wxianing
 * 时  间: 16/6/22
 */
public class ShopListAdapter extends BasicAdapter<ShopLists.DataListBean> {
    public ShopListAdapter(List<ShopLists.DataListBean> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_shop_list_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(mData.get(position).getPhoto(), vh.img, MyApplication.options);
        vh.address.setText(mData.get(position).getAreaName() + "  " + mData.get(position).getAddress());
        vh.shopName.setText(mData.get(position).getStructureName());

        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.img)
        private ImageView img;
        @ViewInject(R.id.shop_name)
        private TextView shopName;
        @ViewInject(R.id.address_tv)
        private TextView address;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
