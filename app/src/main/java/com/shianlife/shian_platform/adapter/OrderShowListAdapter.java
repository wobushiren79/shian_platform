package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.mvp.store.bean.OrderShowResultBean;
import com.shianlife.shian_platform.utils.AnimUtils;


/**
 * Created by zm.
 */

public class OrderShowListAdapter extends BaseRCAdapter<OrderShowResultBean.Item> {

    /**
     * 单布局初始化
     *
     * @param context
     */
    public OrderShowListAdapter(Context context) {
        super(context, R.layout.layout_order_show);
    }


    @Override
    public void convert(BaseViewHolder holder, final OrderShowResultBean.Item orderShowItemBean, int index) {
        TextView tvTitle = holder.getView(R.id.tv_title);
        ImageView ivIcon = holder.getView(R.id.iv_icon);
        LinearLayout llContent = holder.getView(R.id.ll_content);
        if (orderShowItemBean.getName() != null)
            tvTitle.setText(orderShowItemBean.getName());
        if (orderShowItemBean.getPicId() != 0)
            ivIcon.setImageResource(orderShowItemBean.getPicId());
        llContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimUtils.startScaleToSelf(v, 100, 1f, 0.95f, 1f, 0.95f, new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(mContext, orderShowItemBean.getIntentClass());
                        mContext.startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}
