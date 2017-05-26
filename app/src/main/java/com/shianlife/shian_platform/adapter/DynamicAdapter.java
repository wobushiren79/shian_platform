package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;
import com.shianlife.shian_platform.ui.activity.WebActivity;
import com.shianlife.shian_platform.utils.IntentUtils;


/**
 * Created by zm.
 */

public class DynamicAdapter extends BaseRCAdapter<DynamicResultBean.DynamicItemsInfo> {

    public DynamicAdapter(Context context) {
        super(context, R.layout.view_main_dynamic_layout_items);
    }


    @Override
    public void convert(BaseViewHolder holder, final DynamicResultBean.DynamicItemsInfo data, final int index) {
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, mContext.getResources().getDimensionPixelOffset(R.dimen.dimen_72dp));
        holder.itemView.setLayoutParams(layoutParams);
        TextView tvTime = holder.getView(R.id.tv_time);
        TextView tvContent = holder.getView(R.id.tv_content);
        TextView tvTop = holder.getView(R.id.tv_top);
        if (index == 0) {
            tvTop.setVisibility(View.VISIBLE);
        } else {
            tvTop.setVisibility(View.GONE);
        }
        tvTime.setText(data.getTime());
        tvContent.setText(data.getTitle());
        checkItem(holder, data);
    }

    private void checkItem(BaseViewHolder holder, final DynamicResultBean.DynamicItemsInfo data) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentUtils.Build(mContext, WebActivity.class)
                        .setString(IntentUtils.INTENT_URL, Constants.dynamicsPHPURL + "?id=" + data.getId())
                        .start();
            }
        });
    }


}
