package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.model.FriendLists;
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
public class FriendListAdapter extends BasicAdapter<FriendLists> {
    public FriendListAdapter(List<FriendLists> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_friend_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(mData.get(position).getPhoto(),vh.img, MyApplication.options);
        vh.userName.setText(mData.get(position).getUserName());


        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.img)
        private ImageView img;
        @ViewInject(R.id.user_name)
        private TextView userName;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
