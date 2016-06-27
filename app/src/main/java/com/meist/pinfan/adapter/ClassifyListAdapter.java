package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meist.pinfan.MyApplication;
import com.meist.pinfan.R;
import com.meist.pinfan.model.ClassifyLists;
import com.meist.pinfan.utils.SharedPreferencesUtils;
import com.meist.pinfan.view.AutoAdjustHeightImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package：com.meist.pinfan.adapter
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/16
 */
public class ClassifyListAdapter extends BasicAdapter<ClassifyLists.DataListBean> {
    private int sexType;
    private int myPrice;

    public ClassifyListAdapter(List<ClassifyLists.DataListBean> mData, Context context) {
        super(mData, context);
        sexType = SharedPreferencesUtils.getIntData(context, "SEX", 0);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ClassifyLists.DataListBean data = mData.get(position);
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_classifylists_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(data.getIcon(), vh.imageView, MyApplication.options);
        vh.name.setText(data.getName());
        vh.count.setText("已参加人数：" + Integer.toString(data.getFemaleSum() + data.getManSum()) + "人");
        switch (sexType) {
            case 1:
                myPrice = data.getManPric();
                break;
            case 2:
                myPrice = data.getFemalePrice();
                break;
        }
        vh.price.setText("￥" + myPrice);
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.imageView)
        private AutoAdjustHeightImageView imageView;
        @ViewInject(R.id.food_name)
        private TextView name;
        @ViewInject(R.id.count_tv)
        private TextView count;
        @ViewInject(R.id.price_tv)
        private TextView price;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
