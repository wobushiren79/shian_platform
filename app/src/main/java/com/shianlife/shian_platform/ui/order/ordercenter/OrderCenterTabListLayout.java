package com.shianlife.shian_platform.ui.order.ordercenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.shianlife.shian_platform.appenum.OrderCenterAuditListEnum;
import com.shianlife.shian_platform.custom.view.tablist.BaseTabListView;

import java.util.LinkedHashMap;

/**
 * Created by zm.
 */
public class OrderCenterTabListLayout extends BaseTabListView {

    public OrderCenterTabListLayout(Context context) {
        this(context, null);
    }

    public OrderCenterTabListLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LinkedHashMap<String, View> listView = new LinkedHashMap<>();

        listView.put(OrderCenterAuditListEnum.wait_audit.getName(),
                new OrderCenterAuditList(getContext(), OrderCenterAuditListEnum.wait_audit.getCode()));

        listView.put(OrderCenterAuditListEnum.audit_complete.getName(),
                new OrderCenterAuditList(getContext(), OrderCenterAuditListEnum.audit_complete.getCode()));

        setListView(listView);
    }
}
