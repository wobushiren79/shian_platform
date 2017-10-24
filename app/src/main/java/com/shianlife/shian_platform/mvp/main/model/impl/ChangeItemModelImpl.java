package com.shianlife.shian_platform.mvp.main.model.impl;

import com.shianlife.shian_platform.appenum.MainChangeItemEnum;
import com.shianlife.shian_platform.appenum.RoleEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.main.model.IChangeItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class ChangeItemModelImpl implements IChangeItemModel {
    @Override
    public List<MainChangeItemEnum> getChangeItemData() {
        List<MainChangeItemEnum> listData = new ArrayList<>();
        listData.add(MainChangeItemEnum.MAIN);
//        listData.add(MainChangeItemEnum.STORE);
        if (Constants.systemUser != null) {
            List<String> permissions = Constants.systemUser.getResourceCodes();
            for (String permission : permissions) {
                if (permission.equals(RoleEnum.Car_Driver.getCode())) {
                    listData.add(MainChangeItemEnum.DIRVERORDER);
                }
                if (permission.equals(RoleEnum.OrderC_Auditor.getCode())) {
                    listData.add(MainChangeItemEnum.ORDER);
                }
            }
        }
        listData.add(MainChangeItemEnum.FIND);
        listData.add(MainChangeItemEnum.MY);
        return listData;
    }
}
