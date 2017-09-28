package com.shianlife.shian_platform.mvp.userinfo.presenter.impl;


import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.ChangePassWordSMSBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.ChangePassWordSMSResultBean;
import com.shianlife.shian_platform.mvp.userinfo.model.IChangePassWordSMSModel;
import com.shianlife.shian_platform.mvp.userinfo.model.impl.ChangePassWordSMSModel;
import com.shianlife.shian_platform.mvp.userinfo.presenter.IChangePassWordSMSPresenter;
import com.shianlife.shian_platform.mvp.userinfo.view.IChangePassWordSMSView;
import com.shianlife.shian_platform.utils.CheckUtils;

/**
 * Created by zm.
 */

public class ChangePassWordSMSPresenterImpl implements IChangePassWordSMSPresenter {
    private IChangePassWordSMSModel changePassWordSMSModel;
    private IChangePassWordSMSView changePassWordSMSView;

    public ChangePassWordSMSPresenterImpl(IChangePassWordSMSView changePassWordSMSView) {
        this.changePassWordSMSView = changePassWordSMSView;
        changePassWordSMSModel = new ChangePassWordSMSModel();
    }


    @Override
    public void changePassWordSMS() {
        if (changePassWordSMSView.getContext() == null) {
            changePassWordSMSView.showToast("数据错误");
            return;
        }
        if (changePassWordSMSView.getUserPhone().isEmpty()) {
            changePassWordSMSView.showToast("还未输入手机号码");
            return;
        }

        if (changePassWordSMSView.getNewPassWord().isEmpty()) {
            changePassWordSMSView.showToast("还未输入新密码");
            return;
        }
        int smsCode;
        try {
            if (changePassWordSMSView.getMsgCode().isEmpty()) {
                changePassWordSMSView.showToast("还未输入验证码");
                return;
            }
            smsCode = Integer.valueOf(changePassWordSMSView.getMsgCode());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ChangePassWordSMSBean params = new ChangePassWordSMSBean();
        params.setMobile(changePassWordSMSView.getUserPhone());
        params.setKeys(changePassWordSMSView.getNewPassWord());
        params.setMsgCode(smsCode);
        changePassWordSMSModel.passWordSMS(changePassWordSMSView.getContext(), params, new OnGetDataListener<ChangePassWordSMSResultBean>() {
            @Override
            public void getDataSuccess(ChangePassWordSMSResultBean result) {
                changePassWordSMSView.changePassWordSMSSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                changePassWordSMSView.changePassWordSMSFail(msg);
            }
        });
    }

    @Override
    public void getSMSCode() {
        if (changePassWordSMSView.getContext() == null) {
            changePassWordSMSView.showToast("数据错误");
            return;
        }
        if (changePassWordSMSView.getUserPhone().isEmpty()) {
            changePassWordSMSView.showToast("还未输入手机号码");
            return;
        }
        if (!CheckUtils.isPhoneNumber(changePassWordSMSView.getUserPhone())) {
            changePassWordSMSView.showToast("输入手机格式不对");
            return;
        }
        ChangePassWordSMSBean params = new ChangePassWordSMSBean();
        params.setMobile(changePassWordSMSView.getUserPhone());
        changePassWordSMSModel.passWordSMS(changePassWordSMSView.getContext(), params, new OnGetDataListener<ChangePassWordSMSResultBean>() {
            @Override
            public void getDataSuccess(ChangePassWordSMSResultBean result) {
                changePassWordSMSView.getSMSCodeSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                changePassWordSMSView.getSMSCodeFail(msg);
            }
        });
    }
}
