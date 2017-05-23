package com.shianlife.shian_platform.mvp.main.model.impl;

import com.shianlife.shian_platform.appenum.MainChangeItemEnum;
import com.shianlife.shian_platform.appenum.RoleEnum;
import com.shianlife.shian_platform.mvp.main.model.IChangeItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class ChangeItemModel implements IChangeItemModel {
    @Override
    public List<MainChangeItemEnum> getChangeItemData(RoleEnum role) {
        List<MainChangeItemEnum> listData = new ArrayList<>();
        listData.add(MainChangeItemEnum.MAIN);
        if (role.getCode() == RoleEnum.DRIVER.getCode()) {
            listData.add(MainChangeItemEnum.DIRVERORDER);
        }
        listData.add(MainChangeItemEnum.FIND);
        listData.add(MainChangeItemEnum.MY);
        return listData;
    }
}
