package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.mvp.store.bean.GoodsInvoiceDetailsItem;


/**
 * Created by zm.
 */

public class StoreOrderInvoiceDetailsAdapter extends BaseRCAdapter<GoodsInvoiceDetailsItem> {

    /**
     * 单布局初始化
     *
     * @param context
     */
    public StoreOrderInvoiceDetailsAdapter(Context context) {
        super(context, R.layout.layout_store_order_invoice_item);
    }


    @Override
    public void convert(BaseViewHolder holder, GoodsInvoiceDetailsItem data, int index) {
        TextView tvTitle = holder.getView(R.id.tv_title);
        TextView tvContent = holder.getView(R.id.tv_content);
        tvTitle.setText(data.getTitle());
        tvContent.setText(data.getContent());
    }

}
