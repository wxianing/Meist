package com.hzwl.videoview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Package：com.hzwl.videoview.view
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
public class MarqueeTextView extends TextView {

    public MarqueeTextView(Context context) {
        super(context);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
