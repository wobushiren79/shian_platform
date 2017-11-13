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
            boolean hasOrder = false;
            boolean hasDiriverOrder = false;
            List<String> permissions = Constants.systemUser.getResourceCodes();
            for (String permission : permissions) {
                if (permission.equals(RoleEnum.Car_Driver.getCode()))
                    hasDiriverOrder = true;
                if (permission.equals(RoleEnum.OrderC_Auditor.getCode())
                        || permission.equals(RoleEnum.Goods_Audit.getCode()))
                    hasOrder = true;

            }
            if (hasOrder)
                listData.add(MainChangeItemEnum.ORDER);
            if (hasDiriverOrder)
                listData.add(MainChangeItemEnum.DIRVERORDER);
        }
        listData.add(MainChangeItemEnum.FIND);
        listData.add(MainChangeItemEnum.MY);
        return listData;
    }
}
