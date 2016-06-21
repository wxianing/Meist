package com.meist.pinfan.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.adapter.BasicAdapter;
import com.meist.pinfan.model.ProductDetails;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package：com.meist.pinfan.activity
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
public class CaixiDetailAdapter extends BasicAdapter<ProductDetails.CaiXiDetailBean> {
    public CaixiDetailAdapter(List<ProductDetails.CaiXiDetailBean> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ProductDetails.CaiXiDetailBean data = mData.get(position);
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_caixi_details_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.produceName.setText(data.getPdt_product().getProductName());
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.produce_name)
        private TextView produceName;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
