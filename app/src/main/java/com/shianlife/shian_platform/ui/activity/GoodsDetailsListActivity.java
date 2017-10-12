package com.shianlife.shian_platform.ui.activity;

import android.os.Bundle;
import android.widget.ExpandableListView;


import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.StoreOrderGoodsListAdapter;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.mvp.order.bean.GoodsItemPerform;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.DataUtils;
import com.shianlife.shian_platform.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class GoodsDetailsListActivity extends BaseActivity {

    @BindView(R.id.goods_expand_list_view)
    ExpandableListView goodsExpandListView;

    private StoreOrderGoodsListAdapter goodsListAdapter;
    private List<GoodsItemPerform> selectGoods;//選中的商品

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details_list);
    }

    @Override
    protected void initView() {
        setTitle("商品列表", BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {
        selectGoods = (ArrayList<GoodsItemPerform>) getIntent().getSerializableExtra(IntentUtils.INTENT_LIST_DATA);
        Map<String, List<GoodsItemPerform>> mapGoodsData = DataUtils.getMapForGoodsItemPerform(selectGoods);
        goodsListAdapter = new StoreOrderGoodsListAdapter(this, false);
        if (selectGoods != null)
            goodsListAdapter.setData(mapGoodsData);
        goodsExpandListView.setAdapter(goodsListAdapter);
        //默认展开
        AppUtils.expandGroup(goodsExpandListView, goodsListAdapter);
    }
}
