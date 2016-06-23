package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.model.GiftLists;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package com.meist.pinfan.adapter
 * 作  用:
 * Author: wxianing
 * 时  间: 16/6/23
 */
public class GiftListsAdapter extends BasicAdapter<GiftLists.DataListBean> {
    private int sType;

    public GiftListsAdapter(List<GiftLists.DataListBean> mData, int sType, Context context) {
        super(mData, context);
        this.sType = sType;
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        GiftLists.DataListBean data = mData.get(position);

        ViewHolder vh = null;


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gift_list_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(data.getThumbImg(), vh.img, MyApplication.options);

        vh.produceName.setText(data.getProductName());
        vh.sendTime.setText(data.getCreateTime());

        switch (sType) {
            case 1:
                vh.fromPerson.setText("赠送人:" + data.getFromUserName());
                break;
            case 2:
                vh.fromPerson.setText("发送至:" + data.getToUserName());
                break;
        }

        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.img)
        private ImageView img;
        @ViewInject(R.id.from_person)
        private TextView fromPerson;
        @ViewInject(R.id.produce_name)
        private TextView produceName;
        @ViewInject(R.id.send_time)
        private TextView sendTime;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
