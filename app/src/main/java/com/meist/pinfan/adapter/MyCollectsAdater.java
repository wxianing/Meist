package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.model.Collects;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package：com.meist.pinfan.adapter
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/22
 */
public class MyCollectsAdater extends BasicAdapter<Collects.DataListBean> {
    public MyCollectsAdater(List<Collects.DataListBean> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_mycollect_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(mData.get(position).getThumbImg(), vh.img, MyApplication.options);
        vh.titleName.setText(mData.get(position).getTitle());
        vh.createTime.setText(mData.get(position).getCreateTime());
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.img)
        private ImageView img;
        @ViewInject(R.id.title_name)
        private TextView titleName;
        @ViewInject(R.id.create_time)
        private TextView createTime;

        public ViewHolder(View v) {
            x.view().inject(this, v);
        }
    }
}
