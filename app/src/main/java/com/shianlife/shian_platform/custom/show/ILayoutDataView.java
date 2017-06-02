package com.shianlife.shian_platform.custom.show;

/**
 * Created by zm.
 */

public interface ILayoutDataView {
    /**
     * 设置标题
     *
     * @param name
     */
    void setTitle(String name);

    /**
     * 设置内容
     *
     * @param content
     */
    void setContent(String content);


    /**
     * 设置字体粗体
     */
    void setContentBold();


    /**
     * 设置布局状态
     *
     * @param state
     */
    void setState(int state);
}
