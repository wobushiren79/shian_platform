package com.shianlife.shian_platform.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shianlife.shian_platform.utils.AppUtils;

/**
 * Created by zm.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public BaseViewHolder(Context context, View itemView, ViewGroup parent) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    public static BaseViewHolder get(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        BaseViewHolder holder = new BaseViewHolder(context, itemView, parent);
        return holder;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


    public BaseViewHolder setImageResource(Context context, ImageView imageView, String imgPath) {
        AppUtils.loadPic(context, imageView, imgPath);
        return this;
    }

    public BaseViewHolder setImageResource(Context context, ImageView imageView, String imgPath, int placeholderId) {
        AppUtils.loadPic(context, imageView, imgPath, placeholderId);
        return this;
    }
}
