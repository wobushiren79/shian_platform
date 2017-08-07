package com.shianlife.shian_platform.adapter;

import android.content.Context;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;

/**
 * Created by zm.
 */

public class StoreAuditPerformListApdapter extends BaseRCAdapter<StoreAuditPerformListResultBean.Content> {
    private CallBack callBack;

    /**
     * 单布局初始化
     *
     * @param context
     */
    public StoreAuditPerformListApdapter(Context context) {
        super(context, R.layout.layout_store_audit_perform_list_item);
    }

    @Override
    public void convert(BaseViewHolder holder, StoreAuditPerformListResultBean.Content content, int index) {

    }


    public interface CallBack {
        void refresh();

        void refreshAll();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
