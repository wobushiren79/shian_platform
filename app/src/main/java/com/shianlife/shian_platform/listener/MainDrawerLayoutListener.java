package com.shianlife.shian_platform.listener;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;

import com.shianlife.shian_platform.R;

/**
 * Created by zm.
 */

public class MainDrawerLayoutListener implements DrawerLayout.DrawerListener {
    private int windowW;
    private int windowH;
    private DrawerLayout mDrawerLayout;
    private Context context;

    public MainDrawerLayoutListener(Context context, DrawerLayout drawerLayout, int windowW, int windowH) {
        this.windowW = windowW;
        this.windowH = windowH;
        this.mDrawerLayout = drawerLayout;
        this.context = context;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        View mContent = mDrawerLayout.getChildAt(0);
        int dp200 = context.getResources().getDimensionPixelOffset(R.dimen.dimen_200dp);
        mContent.setTranslationX((windowW - dp200) * slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
