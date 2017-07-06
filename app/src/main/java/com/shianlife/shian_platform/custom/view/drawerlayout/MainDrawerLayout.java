package com.shianlife.shian_platform.custom.view.drawerlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.shianlife.shian_platform.R;

/**
 * Created by zm.
 */

public class MainDrawerLayout extends LinearLayout {
    View mLayoutView;

    public MainDrawerLayout(Context context) {
        this(context, null);
    }

    public MainDrawerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mLayoutView = View.inflate(getContext(), R.layout.layout_main_drawer, this);
    }
}
