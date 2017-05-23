package com.shianlife.shian_platform.custom.title;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;


/**
 * Created by Administrator on 2017/4/6.
 */

public class BackNormalTitle extends LinearLayout {
    View view;
    TextView mTVTitle;
    RelativeLayout mRLBack;

    public BackNormalTitle(Context context) {
        super(context);
        view = View.inflate(context, R.layout.view_title_back_normal, this);
        initView();
    }


    private void initView() {
        mTVTitle = (TextView) view.findViewById(R.id.tv_title);
        mRLBack = (RelativeLayout) view.findViewById(R.id.rl_back);

        mRLBack.setOnClickListener(onClickListener);
    }

    public void setTitle(String name) {
        mTVTitle.setText(name);
    }

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mRLBack) {
                ((Activity) getContext()).finish();
            }
        }
    };
}
