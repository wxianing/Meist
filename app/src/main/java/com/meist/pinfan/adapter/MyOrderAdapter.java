package com.meist.pinfan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.activity.PublishCommentActivity;
import com.meist.pinfan.model.Order;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package：com.meist.pinfan.adapter
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/23
 */
public class MyOrderAdapter extends BasicAdapter<Order.DataListBean> {
    public MyOrderAdapter(List<Order.DataListBean> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        Order.DataListBean data = mData.get(position);
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_order_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(data.getThumbImg(), vh.img, MyApplication.options);
        vh.produceName.setText(data.getProductName());
        vh.orderTime.setText(data.getCreateTime());
        vh.totalMoney.setText("￥" + data.getTotalMoney());
        int payState = data.getPayState();
        switch (payState) {
            case 0:
                vh.payStateTv.setText("待付款");
                break;
            case 1:
                vh.payStateTv.setText("已付款");
                break;
        }

        int status = data.getStatus();
        switch (status) {
            case 1:

                break;
            case 2:
                vh.payStateTv.setText("待退款");
                break;
            case 3:
                vh.payStateTv.setText("已取消");
                vh.commentBtn.setVisibility(View.VISIBLE);
                break;
            case 4:
                vh.payStateTv.setText("已完成");
                vh.commentBtn.setVisibility(View.VISIBLE);
                break;
            case 6:
                vh.payStateTv.setText("退款成功");
                break;
        }
        vh.commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PublishCommentActivity.class);
                context.startActivity(intent);
            }
        });


        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.img)
        private ImageView img;
        @ViewInject(R.id.produce_name)
        private TextView produceName;
        @ViewInject(R.id.order_time)
        private TextView orderTime;
        @ViewInject(R.id.total_money)
        private TextView totalMoney;
        @ViewInject(R.id.pay_state)
        private TextView payStateTv;
        @ViewInject(R.id.comment_btn)
        private Button commentBtn;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
