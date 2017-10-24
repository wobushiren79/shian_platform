package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseExpandableAdapter;
import com.shianlife.shian_platform.appenum.GoodsPerformStatusEnum;
import com.shianlife.shian_platform.appenum.GoodsPerformWayEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.dialog.DataShowDialog;
import com.shianlife.shian_platform.mvp.store.bean.GoodsItemPerform;
import com.shianlife.shian_platform.mvp.store.bean.GoodsPerform;
import com.shianlife.shian_platform.mvp.store.bean.StoreOrderGetPerformResultBean;
import com.shianlife.shian_platform.mvp.store.presenter.IStoreOrderGetPerformPresenter;
import com.shianlife.shian_platform.mvp.store.presenter.impl.StoreOrderGetPerformPresenterImpl;
import com.shianlife.shian_platform.mvp.store.view.IStoreOrderGetPerformView;
import com.shianlife.shian_platform.ui.activity.GoodsDetailsListActivity;
import com.shianlife.shian_platform.ui.activity.ImagePreviewActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderGoodsListAdapter extends BaseExpandableAdapter<String, GoodsItemPerform> implements IStoreOrderGetPerformView {

    private IStoreOrderGetPerformPresenter storeOrderGetPerformPresenter;
    private boolean isShowMode = false;

    public StoreOrderGoodsListAdapter(Context context, boolean isShowMode) {
        super(context, R.layout.store_order_expendlist_group, R.layout.store_order_expendlist_item);
        storeOrderGetPerformPresenter = new StoreOrderGetPerformPresenterImpl(this);
        this.isShowMode = isShowMode;
    }

    @Override
    public void setGroupView(String groupData, View convertView, int groupPosition) {
        TextView content = (TextView) convertView.findViewById(R.id.tv_content);
        content.setText(groupData);
    }

    @Override
    public void setItemView(final GoodsItemPerform itemData, View convertView, int groupPosition, final int childPosition) {
        ImageView ivGoodsPic = (ImageView) convertView.findViewById(R.id.iv_goods_pic);
        ImageView ivPackage = (ImageView) convertView.findViewById(R.id.iv_package);
        TextView tvGoodsName = (TextView) convertView.findViewById(R.id.tv_goods_name);
        TextView tvGoodsSpecification = (TextView) convertView.findViewById(R.id.tv_goods_specification);
        TextView tvGoodsCustomerMoney = (TextView) convertView.findViewById(R.id.tv_goods_customer_money);
        TextView tvGoodsCounselorMoney = (TextView) convertView.findViewById(R.id.tv_goods_counselor_money);
        TextView tvGoodsNumb = (TextView) convertView.findViewById(R.id.tv_goods_numb);
        TextView tvPerformStatus = (TextView) convertView.findViewById(R.id.tv_perform_status);

        tvGoodsName.setText(itemData.getSpecOrderedVolume());
        tvGoodsSpecification.setText(itemData.getSpecAlias() + "：" + itemData.getSpecName());

        if (itemData.getSpecOrderedPrice() == null)
            tvGoodsCustomerMoney.setText("");
        else
            tvGoodsCustomerMoney.setText("客户￥" + (float) itemData.getSpecOrderedPrice() / 100f);

        if (isShowMode) {
            if (itemData.getAdviserPrice() == null)
                tvGoodsCounselorMoney.setText("");
            else
                tvGoodsCounselorMoney.setText("顾问￥" + (float) itemData.getAdviserPrice() / 100f);
        }

        View.OnClickListener onPackageDetailsClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GoodsDetailsListActivity.class);
                if (itemData.getGoodsOrderItems() != null)
                    intent.putExtra(IntentUtils.INTENT_LIST_DATA, (Serializable) itemData.getGoodsOrderItems());
                if (itemData.getGoodsItemPerforms() != null)
                    intent.putExtra(IntentUtils.INTENT_LIST_DATA, (Serializable) itemData.getGoodsItemPerforms());
                getContext().startActivity(intent);
            }
        };

        //数据设置
        if (itemData.getGoodsOrderItems() == null && itemData.getGoodsItemPerforms() == null) {
            ivPackage.setVisibility(View.GONE);
            convertView.setOnClickListener(null);
        } else {
            ivPackage.setVisibility(View.VISIBLE);
            convertView.setOnClickListener(onPackageDetailsClick);
        }

        tvGoodsNumb.setText("x" + itemData.getSpecOrderedNum());
        //图片设置
        AppUtils.loadPic(mContext, ivGoodsPic, Constants.Goods_PicUrl + "/" + itemData.getTitleImg());
        ivGoodsPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(), ImagePreviewActivity.class);
                in.putExtra(IntentUtils.INTENT_URL, Constants.Goods_PicUrl + "/" + itemData.getTitleImg());
                getContext().startActivity(in);
            }
        });
        if (itemData.getGoodsPerform() != null) {
            final GoodsPerform goodsPerform = itemData.getGoodsPerform();
            tvPerformStatus.setText(GoodsPerformStatusEnum.getValueText(goodsPerform.getPerformStatus()));
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    storeOrderGetPerformPresenter.getPerformInfo(goodsPerform.getId());
                }
            });
        }
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void getPerformInfoSuccess(StoreOrderGetPerformResultBean resultBean) {
        List<DataShowDialog.DataShowDialogResultBean> listData = new ArrayList<>();
        if (resultBean.getGoodsPerform() != null) {
            StoreOrderGetPerformResultBean.GoodsPerform goodsPerform = resultBean.getGoodsPerform();
            listData.add(new DataShowDialog.DataShowDialogResultBean("执行方式", GoodsPerformWayEnum.getValueText(goodsPerform.getPerformWay())));
            listData.add(new DataShowDialog.DataShowDialogResultBean("执行人姓名", goodsPerform.getPerformUserName()));
            listData.add(new DataShowDialog.DataShowDialogResultBean("执行人电话", goodsPerform.getPerformUserPhone()));
            listData.add(new DataShowDialog.DataShowDialogResultBean("备注", goodsPerform.getPerformComment()));
        }
        if (resultBean.getGoodsExpress() != null) {
            StoreOrderGetPerformResultBean.GoodsExpress goodsExpress = resultBean.getGoodsExpress();
            listData.add(new DataShowDialog.DataShowDialogResultBean("快递公司", goodsExpress.getExpressName()));
            listData.add(new DataShowDialog.DataShowDialogResultBean("快递单号", goodsExpress.getDeliveryNumber()));
        }
        DataShowDialog dataShowDialog = new DataShowDialog(mContext);
        dataShowDialog.setTitle("执行信息");
        dataShowDialog.setData(listData);
        dataShowDialog.setCancelOnClick(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dataShowDialog.show();
    }

    @Override
    public void getPerformInfoFail(String msg) {
        ToastUtils.showToastShort(mContext, msg);
    }

}
