package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
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
public class ImageAadpter extends BaseAdapter {
    private List<String> mDatas;
    private Context context;
    private LayoutInflater inflater;

    public ImageAadpter(List<String> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_img_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(mDatas.get(position), vh.img, MyApplication.options);
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
