package com.shianlife.shian_platform.mvp.ideaback.presenter.impl;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.ideaback.bean.IdeaFeedBackBean;
import com.shianlife.shian_platform.mvp.ideaback.model.IIdeaFeedBackModel;
import com.shianlife.shian_platform.mvp.ideaback.model.impl.IdeaFeedBackModelImpl;
import com.shianlife.shian_platform.mvp.ideaback.presenter.IIdeaFeedBackPresenter;
import com.shianlife.shian_platform.mvp.ideaback.presenter.OnIdeaFeedBackListener;
import com.shianlife.shian_platform.mvp.ideaback.view.IIdeaFeedBackView;

/**
 * Created by zm.
 */

public class IdeaFeedBackPresenterImpl implements IIdeaFeedBackPresenter {
    IIdeaFeedBackView ideaFeedBackView;
    IIdeaFeedBackModel ideaFeedBackModel;

    public IdeaFeedBackPresenterImpl(IIdeaFeedBackView ideaFeedBackView) {
        this.ideaFeedBackView = ideaFeedBackView;
        ideaFeedBackModel = new IdeaFeedBackModelImpl();
    }

    @Override
    public void saveIdeaFeedBackData() {
        IdeaFeedBackBean params = new IdeaFeedBackBean();
        params.setContent(ideaFeedBackView.getEdContent());
        params.setTel(ideaFeedBackView.getUserPhone());
        params.setUser(ideaFeedBackView.getUserName());
        ideaFeedBackModel.saveIdeaFeedBackData(ideaFeedBackView.getContent(), params, new OnIdeaFeedBackListener() {
            @Override
            public void saveIdeaFeedBackSuccess(BaseDataResult result) {
                ideaFeedBackView.showData(result);
            }

            @Override
            public void saveIdeaFeedBackFail(String msg) {
                ideaFeedBackView.showMsg(msg);
            }
        });
    }
}
