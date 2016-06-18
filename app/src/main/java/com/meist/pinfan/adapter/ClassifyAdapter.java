package com.meist.pinfan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meist.pinfan.R;
import com.meist.pinfan.model.Classify;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Package：com.meist.pinfan.adapter
 * 作  用：菜系分类
 * Author：wxianing
 * 时  间：2016/6/16
 */
public class ClassifyAdapter extends BasicAdapter<Classify> {
    public ClassifyAdapter(List<Classify> mData, Context context) {
        super(mData, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_classify_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.mTextView.setText(mData.get(position).getSortName());
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.classify_name)
        private TextView mTextView;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
