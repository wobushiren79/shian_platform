package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.FindDataEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.find.presenter.IFindDataPresenter;
import com.shianlife.shian_platform.mvp.find.presenter.impl.FindDataPresenterImpl;
import com.shianlife.shian_platform.mvp.find.view.IFindDataView;
import com.shianlife.shian_platform.ui.activity.WebActivity;
import com.shianlife.shian_platform.utils.IntentUtils;

/**
 * Created by zm.
 */

public class FindAdapter extends BaseRCAdapter<FindResultBean.SiftListData> implements IFindDataView {

    private IFindDataPresenter findDataPresenter;

    public FindAdapter(Context context) {
        super(context, R.layout.layout_find_items);
        findDataPresenter = new FindDataPresenterImpl(this);
    }

    @Override
    public void convert(final BaseViewHolder holder, final FindResultBean.SiftListData data, int index) {
        TextView tvTitle = holder.getView(R.id.tv_title);
        TextView tvTime = holder.getView(R.id.tv_time);
        TextView tvCollection = holder.getView(R.id.tv_collection);
        TextView tvPraise = holder.getView(R.id.tv_praise);

        ImageView ivPic = holder.getView(R.id.iv_pic);
        final ImageView ivCollection = holder.getView(R.id.iv_collection);
        final ImageView ivPraise = holder.getView(R.id.iv_praise);

        LinearLayout llCollection = holder.getView(R.id.ll_collection);
        LinearLayout llPraise = holder.getView(R.id.ll_praise);


        tvTitle.setText(data.getTitle());
        tvTime.setText(data.getTime());
        tvCollection.setText(data.getCollectionNum() + "");
        tvPraise.setText(data.getPraiseNum() + "");

        holder.setImageResource(mContext, ivPic, Constants.PHP_URL + data.getImg(), R.drawable.zhy_find_default_icon);

        ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentUtils
                        .Build(getContext(), WebActivity.class)
                        .setString(IntentUtils.INTENT_URL, Constants.siftsPHPURL + "?id=" + data.getId())
                        .setBoolean(IntentUtils.INTENT_ISCOLLECTION, true)
                        .setData(IntentUtils.INTENT_SHAREDATA, data)
                        .start();
            }
        });

        if (data.getIsCollection() == 0) {
            ivCollection.setImageResource(R.drawable.zhy_find_collection_1);
            llCollection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int collectionNum = data.getCollectionNum();
                    data.setIsCollection(1);
                    data.setCollectionNum(++collectionNum);
                    ivCollection.setImageResource(R.drawable.zhy_find_collection_2);
                    ivCollection.setOnClickListener(null);
                    findDataPresenter.saveData(FindDataEnum.COLLECTION.getCode(), data.getId());
                    notifyDataSetChanged();
                }
            });
        } else {
            ivCollection.setImageResource(R.drawable.zhy_find_collection_2);
            llCollection.setOnClickListener(null);
        }

        if (data.getIsPraise() == 0) {
            ivPraise.setImageResource(R.drawable.zhy_find_praise_1);
            llPraise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int praiseNum = data.getPraiseNum();
                    data.setPraiseNum(++praiseNum);
                    data.setIsPraise(1);
                    ivPraise.setImageResource(R.drawable.zhy_find_praise_2);
                    ivPraise.setOnClickListener(null);
                    findDataPresenter.saveData(FindDataEnum.PRAISE.getCode(), data.getId());
                    notifyDataSetChanged();
                }
            });
        } else {
            ivPraise.setImageResource(R.drawable.zhy_find_praise_2);
            llPraise.setOnClickListener(null);
        }
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void changeSuccess() {

    }

    @Override
    public void changeFail(String msg) {

    }

    @Override
    public int getChangeType() {
        return 0;
    }

    @Override
    public int getSiftid() {
        return 0;
    }
}
