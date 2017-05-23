package com.shianlife.shian_platform.mvp.main.view;

import com.shianlife.shian_platform.appenum.MainChangeItemEnum;
import com.shianlife.shian_platform.base.BaseFragment;

import java.util.List;

/**
 * Created by zm.
 */

public interface IChangeItemView {
    /**
     * 设置初始数据
     */
    void setItemData(List<MainChangeItemEnum> listData);

    /**
     * 改变内容
     * @param fragment
     */
    void changeContent(BaseFragment fragment);
}
