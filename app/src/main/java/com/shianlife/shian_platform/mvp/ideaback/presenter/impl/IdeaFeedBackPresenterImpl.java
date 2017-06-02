package com.shianlife.shian_platform.mvp.ideaback.presenter.impl;

import com.shianlife.shian_platform.appenum.SystemTypeEnum;
import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.ideaback.bean.IdeaFeedBackBean;
import com.shianlife.shian_platform.mvp.ideaback.bean.IdeaFeedBackResultBean;
import com.shianlife.shian_platform.mvp.ideaback.model.IIdeaFeedBackModel;
import com.shianlife.shian_platform.mvp.ideaback.model.impl.IdeaFeedBackModelImpl;
import com.shianlife.shian_platform.mvp.ideaback.presenter.IIdeaFeedBackPresenter;
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
        params.setUserType(SystemTypeEnum.platform.getCode());
        ideaFeedBackModel.saveIdeaFeedBackData(ideaFeedBackView.getContent(), params, new OnGetDataListener<IdeaFeedBackResultBean>() {
            @Override
            public void getDataSuccess(IdeaFeedBackResultBean result) {
                ideaFeedBackView.showData(result);
            }

            @Override
            public void getDataFail(String msg) {
                ideaFeedBackView.showMsg(msg);
            }
        });
    }
}
