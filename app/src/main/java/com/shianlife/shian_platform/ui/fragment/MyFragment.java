package com.shianlife.shian_platform.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.FindDataEnum;
import com.shianlife.shian_platform.appenum.UserCenterEnum;
import com.shianlife.shian_platform.base.BaseFragment;
import com.shianlife.shian_platform.ui.activity.CustomerHelpActivity;
import com.shianlife.shian_platform.ui.activity.FindListActivity;
import com.shianlife.shian_platform.ui.activity.IdeaFeedbackActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by zm.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.tv_name)
    TextView mTVName;
    @BindView(R.id.tv_phone)
    TextView mTVPhone;
    @BindView(R.id.iv_infoin)
    ImageView mIVInfoIn;
    @BindView(R.id.iv_icon)
    ImageView mIVIcon;

    @BindView(R.id.ll_edit)
    LinearLayout mLLEdit;
    @BindView(R.id.layout_help)
    LinearLayout mLLHelp;
    @BindView(R.id.layout_collection)
    LinearLayout mLLCollection;
    @BindView(R.id.layout_idea)
    LinearLayout mLLIdea;
    @BindView(R.id.layout_setting)
    LinearLayout mLLSetting;
    @BindView(R.id.layout_platform)
    LinearLayout mLLPlatform;
    @BindView(R.id.layout_vsersion)
    LinearLayout mLLVersion;
    Unbinder unbinder;

    View view;
    UserCenterEnum[] layoutEnum;
    List<LinearLayout> listLayout = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {
        listLayout.clear();
        listLayout.add(mLLHelp);
        listLayout.add(mLLCollection);
        listLayout.add(mLLIdea);
        listLayout.add(mLLSetting);
        listLayout.add(mLLPlatform);
        listLayout.add(mLLVersion);
    }

    @Override
    protected void initData() {
        layoutEnum = new UserCenterEnum[]{
                UserCenterEnum.HELP,
                UserCenterEnum.COLLECTION,
                UserCenterEnum.IDEA,
                UserCenterEnum.SETTING,
                UserCenterEnum.PLATFORM,
                UserCenterEnum.VERSION
        };

        for (int i = 0; i < layoutEnum.length; i++) {
            LinearLayout layout = listLayout.get(i);
            ImageView ivIcon = (ImageView) layout.findViewById(R.id.iv_icon);
            TextView tvTitle = (TextView) layout.findViewById(R.id.tv_name);
            ivIcon.setImageResource(layoutEnum[i].getPicId());
            tvTitle.setText(layoutEnum[i].getName());
            if (layoutEnum[i].getName().contains("版本号")) {
                tvTitle.append(AppUtils.getVersion(getContext()));
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.ll_edit, R.id.layout_help, R.id.layout_collection, R.id.layout_idea, R.id.layout_setting, R.id.layout_platform, R.id.layout_vsersion})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_edit:
                break;
            case R.id.layout_help:
                customerHelp();
                break;
            case R.id.layout_collection:
                myCollection();
                break;
            case R.id.layout_idea:
                ideaBack();
                break;
            case R.id.layout_setting:
                break;
            case R.id.layout_platform:
                break;
            case R.id.layout_vsersion:
                break;
        }
    }

    /**
     * 用户帮助
     */
    private void customerHelp() {
        new IntentUtils
                .Build(getContext(), CustomerHelpActivity.class)
                .start();
    }

    /**
     * 意见反馈
     */
    private void ideaBack() {
        new IntentUtils
                .Build(getContext(), IdeaFeedbackActivity.class)
                .start();
    }

    /**
     * 我的收藏
     */
    private void myCollection() {
        new IntentUtils
                .Build(getContext(), FindListActivity.class)
                .start();
    }
}
