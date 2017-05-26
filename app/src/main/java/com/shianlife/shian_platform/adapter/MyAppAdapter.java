package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.APPEnum;
import com.shianlife.shian_platform.custom.view.myapp.MainAPPItems;

/**
 * Created by zm.
 */

public class MyAppAdapter extends BaseRCAdapter<APPEnum> {

    public MyAppAdapter(Context context) {
        super(context, R.layout.view_mainapp_layout);
    }

    @Override
    public void convert(BaseViewHolder holder, APPEnum appEnum, int index) {
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, mContext.getResources().getDimensionPixelOffset(R.dimen.dimen_132dp));
        MainAPPItems items = new MainAPPItems(mContext);
        items.setLayoutParams(layoutParams);
        items.setData(appEnum.getName(), appEnum.getPicId(), appEnum.getUrl());

        LinearLayout llContent = holder.getView(R.id.ll_content);
        llContent.addView(items);
    }
}
