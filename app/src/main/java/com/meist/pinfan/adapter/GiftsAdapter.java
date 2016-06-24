package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.model.Gifts;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package：com.meist.pinfan.adapter
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/24
 */
public class GiftsAdapter extends BasicAdapter<Gifts.DataListBean> {
    public static Map<Integer, Boolean> isSelected;

    public GiftsAdapter(List<Gifts.DataListBean> mData, Context context) {
        super(mData, context);
        initDate();
    }

    private void initDate() {

        if (isSelected != null)
            isSelected = null;
        isSelected = new HashMap<Integer, Boolean>();

        for (int i = 0; i < mData.size(); i++) {
            getIsSelected().put(i, true);
        }
    }

    public static Map<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(Map<Integer, Boolean> isSelected) {
        GiftsAdapter.isSelected = isSelected;
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        Gifts.DataListBean data = mData.get(position);
        ViewHolder vh = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gifts_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(data.getThumbImg(), vh.img, MyApplication.options);
        vh.giftName.setText(data.getProductName());

//        vh.checkBox.setChecked(getIsSelected().get(position));

        return convertView;
    }

    public static class ViewHolder {
        @ViewInject(R.id.img)
        private ImageView img;
        @ViewInject(R.id.gift_name)
        private TextView giftName;

        @ViewInject(R.id.checkbox)
        public CheckBox checkBox;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
