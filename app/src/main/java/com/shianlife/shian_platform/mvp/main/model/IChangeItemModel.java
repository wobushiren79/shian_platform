package com.shianlife.shian_platform.mvp.main.model;

import com.shianlife.shian_platform.appenum.MainChangeItemEnum;
import com.shianlife.shian_platform.appenum.RoleEnum;

import java.util.List;

/**
 * Created by zm.
 */

public interface IChangeItemModel {
    /**
     * 根据角色获取主菜单数据
     * @param role
     * @return
     */
    List<MainChangeItemEnum> getChangeItemData(RoleEnum role);
}
