package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseExpandableAdapter;
import com.shianlife.shian_platform.appenum.GoodsPerformStatusEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.order.bean.GoodsItemPerform;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrderItem;
import com.shianlife.shian_platform.mvp.order.bean.GoodsPerform;
import com.shianlife.shian_platform.utils.AppUtils;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class StoreOrderGoodsListAdapter extends BaseExpandableAdapter<String, GoodsItemPerform> {


    public StoreOrderGoodsListAdapter(Context context) {
        super(context, R.layout.store_order_expendlist_group, R.layout.store_order_expendlist_item);
    }

    @Override
    public void setGroupView(String groupData, View convertView, int groupPosition) {
        TextView content = (TextView) convertView.findViewById(R.id.tv_content);
        content.setText(groupData);
    }

    @Override
    public void setItemView(GoodsItemPerform itemData, View convertView, int groupPosition, int childPosition) {
        ImageView ivGoodsPic = (ImageView) convertView.findViewById(R.id.iv_goods_pic);
        TextView tvGoodsName = (TextView) convertView.findViewById(R.id.tv_goods_name);
        TextView tvGoodsSpecification = (TextView) convertView.findViewById(R.id.tv_goods_specification);
        TextView tvGoodsCustomerMoney = (TextView) convertView.findViewById(R.id.tv_goods_customer_money);
        TextView tvGoodsCounselorMoney = (TextView) convertView.findViewById(R.id.tv_goods_counselor_money);
        TextView tvGoodsNumb = (TextView) convertView.findViewById(R.id.tv_goods_numb);
        TextView tvPerformStatus = (TextView) convertView.findViewById(R.id.tv_perform_status);

        tvGoodsName.setText(itemData.getSpecOrderedVolume());
        tvGoodsSpecification.setText("规格：" + itemData.getSpecAlias());

        if (itemData.getEmentPrice() == null)
            tvGoodsCustomerMoney.setText("客户￥：" + "未知");
        else
            tvGoodsCustomerMoney.setText("客户￥：" + itemData.getEmentPrice() / 100);

        if (itemData.getAdviserPrice() == null)
            tvGoodsCounselorMoney.setText("顾问￥：" + "未知");
        else
            tvGoodsCounselorMoney.setText("顾问￥：" + itemData.getAdviserPrice() / 100);


        tvGoodsNumb.setText("x" + itemData.getSpecOrderedNum());
        AppUtils.loadPic(mContext, ivGoodsPic, Constants.Store_Pic_BaseUrl + itemData.getTitleImg());
        if(itemData.getGoodsPerform()!=null){
            GoodsPerform goodsPerform=itemData.getGoodsPerform();
            tvPerformStatus.setText(GoodsPerformStatusEnum.getValueText(goodsPerform.getPerformStatus()));
        }

    }
}
