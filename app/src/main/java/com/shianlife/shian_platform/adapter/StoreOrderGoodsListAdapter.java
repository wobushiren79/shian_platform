package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseExpandableAdapter;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrderItem;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class StoreOrderGoodsListAdapter extends BaseExpandableAdapter<String, GoodsOrderItem> {


    public StoreOrderGoodsListAdapter(Context context) {
        super(context, R.layout.store_order_expendlist_group, R.layout.store_order_expendlist_item);
    }

    @Override
    public void setGroupView(String groupData, View convertView, int groupPosition) {
        TextView content = (TextView) convertView.findViewById(R.id.tv_content);
        content.setText(groupData);
    }

    @Override
    public void setitemView(GoodsOrderItem itemData, View convertView, int groupPosition, int childPosition) {
        ImageView ivGoodsPic = (ImageView) convertView.findViewById(R.id.iv_goods_pic);
        TextView tvGoodsName = (TextView) convertView.findViewById(R.id.tv_goods_name);
        TextView tvGoodsSpecification = (TextView) convertView.findViewById(R.id.tv_goods_specification);
        TextView tvGoodsMoney = (TextView) convertView.findViewById(R.id.tv_goods_money);
        TextView tvGoodsNumb = (TextView) convertView.findViewById(R.id.tv_goods_numb);

        tvGoodsName.setText(itemData.getSpecOrderedVolume());
    }
}
