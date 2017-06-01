package com.shianlife.shian_platform.adapter;

import android.content.Context;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCSAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;

/**
 * Created by zm.
 */

public class WaitServiceListAdapter extends BaseRCSAdapter<WaitServiceListResultBean.WaitServiceItemData> {
    /**
     * 多布局初始化
     *
     * @param context
     */
    public WaitServiceListAdapter(Context context) {
        super(context);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_waitgetorder);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_waitgetcar);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_waitgo);
    }

    @Override
    public void convert(BaseViewHolder holder, WaitServiceListResultBean.WaitServiceItemData waitServiceItemData, int index) {

    }


    @Override
    public int getItemViewType(int position) {
        WaitServiceListResultBean.WaitServiceItemData waitServiceItemData = mDatas.get(position);
        if (position % 3 == 0) {
            return 0;
        } else if (position % 3 == 1) {
            return 1;
        } else if (position % 3 == 2) {
            return 2;
        }
        return 4;
    }
}
