package com.shianlife.shian_platform.mvp.main.presenter.impl;

import com.shianlife.shian_platform.appenum.MainChangeItemEnum;
import com.shianlife.shian_platform.appenum.RoleEnum;
import com.shianlife.shian_platform.mvp.main.model.IChangeItemModel;
import com.shianlife.shian_platform.mvp.main.model.impl.ChangeItemModel;
import com.shianlife.shian_platform.mvp.main.presenter.IChangeItemPresenter;
import com.shianlife.shian_platform.mvp.main.view.IChangeItemView;

import java.util.List;

/**
 * Created by zm.
 */

public class ChangeItemPresenter implements IChangeItemPresenter {

    IChangeItemView changeItemView;
    IChangeItemModel changeItemModel;

    public ChangeItemPresenter(IChangeItemView changeItemView) {
        this.changeItemView = changeItemView;
        changeItemModel = new ChangeItemModel();
    }

    @Override
    public void setChangeItemData() {
        RoleEnum role = RoleEnum.DRIVER;
        List<MainChangeItemEnum> listData = changeItemModel.getChangeItemData(role);
        changeItemView.setItemData(listData);
    }
}
