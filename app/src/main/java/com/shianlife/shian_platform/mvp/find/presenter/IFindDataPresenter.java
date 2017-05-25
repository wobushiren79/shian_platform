package com.shianlife.shian_platform.mvp.find.presenter;

/**
 * Created by zm.
 */

public interface IFindDataPresenter {
    /**
     * 点赞 收藏数据
     *
     * @param type
     * @param findId
     */
    void saveData(int type, int findId);
}
