package com.shianlife.shian_platform.ui.order.ordercenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.OrderCenterAuditListAdapter;
import com.shianlife.shian_platform.adapter.OrderCenterHistoryAdapter;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollRecyclerView;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterRecord;
import com.shianlife.shian_platform.utils.AnimUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class OrderCenterHistoryList extends BaseLayout implements View.OnClickListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.iv_expandable)
    ImageView ivExpandable;
    @BindView(R.id.list_view)
    ScrollRecyclerView listView;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    private boolean isExpandable = false;
    private OrderCenterHistoryAdapter listAdapter;

    public OrderCenterHistoryList(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_order_center_history, attrs);
        initView();
        initData();
    }

    public OrderCenterHistoryList(Context context) {
        this(context, null);
    }

    @Override
    protected void initView() {
        llContent.setOnClickListener(this);
        tvTitle.setText(titleName);
    }

    @Override
    protected void initData() {
        listAdapter = new OrderCenterHistoryAdapter(getContext());
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.setAdapter(listAdapter);
    }

    public void setListData(List<OrderCenterRecord> listData) {
        if (listData == null || listData.size() == 0) {
            ivExpandable.setVisibility(GONE);
            tvContent.setText("无记录");
            llContent.setOnClickListener(null);
        } else {
            listAdapter.setData(listData);
            ivExpandable.setVisibility(VISIBLE);
        }

    }

    public void setExpandable(boolean isExpandable) {
        this.isExpandable = !isExpandable;
        startExpandable();
    }

    private void startExpandable() {
        if (isExpandable) {
            isExpandable = false;
            AnimUtils.startRotateToSelf(ivExpandable, 200, 90, 0, null);
            listView.setVisibility(GONE);
        } else {
            isExpandable = true;
            AnimUtils.startRotateToSelf(ivExpandable, 200, 0, 90, null);
            listView.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        startExpandable();
    }
}
