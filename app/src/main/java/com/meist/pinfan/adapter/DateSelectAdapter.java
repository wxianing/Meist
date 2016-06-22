package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.model.ProductDetails;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package：com.meist.pinfan.adapter
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/22
 */
public class DateSelectAdapter extends BasicAdapter<ProductDetails.OrderDateListBean> {
    public DateSelectAdapter(List<ProductDetails.OrderDateListBean> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_date_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.datetime.setText(mData.get(position).getDate());
        vh.leaveCount.setText("剩余：" + mData.get(position).getLeaveCount() + "/" + mData.get(position).getTotalCount());
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.data_time)
        private TextView datetime;
        @ViewInject(R.id.leave_count)
        private TextView leaveCount;

        public ViewHolder(View v) {
            x.view().inject(this, v);
        }
    }
}
