package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.ideaback.bean.IdeaFeedBackResultBean;
import com.shianlife.shian_platform.mvp.ideaback.presenter.IIdeaFeedBackPresenter;
import com.shianlife.shian_platform.mvp.ideaback.presenter.impl.IdeaFeedBackPresenterImpl;
import com.shianlife.shian_platform.mvp.ideaback.view.IIdeaFeedBackView;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;


public class IdeaFeedbackActivity extends BaseActivity implements IIdeaFeedBackView {

    @BindView(R.id.edit)
    EditText etContent;
    @BindView(R.id.tv_textnum)
    TextView tvTextnum;
    @BindView(R.id.bt_submit)
    TextView btSubmit;

    private IIdeaFeedBackPresenter ideaFeedBackPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_feedback);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_ideaback), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        etContent.addTextChangedListener(textWatcher);
    }

    @Override
    protected void initData() {
        ideaFeedBackPresenter = new IdeaFeedBackPresenterImpl(this);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            changeNum(s.length());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void changeNum(int num) {
        tvTextnum.setText(num + "/" + 100);
    }

    @OnClick(R.id.bt_submit)
    public void onViewClicked() {
        if (etContent.getText().toString().equals("")) {
            ToastUtils.showToastShort(IdeaFeedbackActivity.this, "还没有填写反馈信息");
            return;
        }
        ideaFeedBackPresenter.saveIdeaFeedBackData();
    }

    @Override
    public Context getContent() {
        return this;
    }

    @Override
    public void showData(IdeaFeedBackResultBean result) {
        ToastUtils.showToastShort(this, getString(R.string.ideaback_save_success));
        finish();
    }

    @Override
    public void showMsg(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public String getEdContent() {
        return etContent.getText().toString();
    }

    @Override
    public String getUserName() {
        if (Constants.systemUser != null && Constants.systemUser.getUserObj() != null) {
            return Constants.systemUser.getUserObj().getName();
        }
        return "";
    }

    @Override
    public String getUserPhone() {
        if (Constants.systemUser != null && Constants.systemUser.getUserObj() != null) {
            return Constants.systemUser.getUserObj().getPhone();
        }
        return "";
    }
}
