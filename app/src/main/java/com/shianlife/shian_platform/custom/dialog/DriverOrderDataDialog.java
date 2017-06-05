package com.shianlife.shian_platform.custom.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseDialog;

/**
 * Created by zm.
 */

public class DriverOrderDataDialog extends BaseDialog {
    private int styleType = -1;
    //没有图片的布局
    public final static int STYLE_NOPIC = 1;
    //有图片的布局
    public final static int STYLE_PIC = 2;

    public DriverOrderDataDialog(Context context, int styleType) {
        super(context);
        this.styleType = styleType;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewItem = LayoutInflater.from(getContext()).inflate(R.layout.dialog_driverorderdata, null);
        setView(mViewItem);
    }


}
