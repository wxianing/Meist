package com.meist.pinfan.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Package：com.meist.pinfan.view
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/20
 */
public class MeasureListView extends ListView {
    public MeasureListView(Context context) {
        super(context);
    }

    public MeasureListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, height);
    }
}
