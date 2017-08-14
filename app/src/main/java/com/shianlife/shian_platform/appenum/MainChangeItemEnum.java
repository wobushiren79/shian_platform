package com.shianlife.shian_platform.appenum;


import com.shianlife.shian_platform.R;

/**
 * Created by Administrator on 2017/3/31.
 */

public enum MainChangeItemEnum {

    MAIN("首页", R.drawable.ic_bar_home_press_2, R.drawable.ic_bar_home_default_2, 1),
    DIRVERORDER("派车", R.drawable.ic_bar_order_press_2, R.drawable.ic_bar_order_default_2, 2),
    FIND("发现", R.drawable.ic_bar_find_press_2, R.drawable.ic_bar_find_default_2, 3),
    MY("我", R.drawable.ic_bar_my_press_2, R.drawable.ic_bar_my_default_2, 4),

    ORDER("审核", R.drawable.ic_bar_order_press_2, R.drawable.ic_bar_order_default_2, 5),
    STORE("商城", R.drawable.ic_bar_orders_press_2, R.drawable.ic_bar_orders_default_2, 6);

    private String title;
    private int unCheckIconId;
    private int checkIconId;
    private int itemId;


    MainChangeItemEnum(String title, int unCheckIconId, int checkIconId, int itemId) {
        this.title = title;
        this.unCheckIconId = unCheckIconId;
        this.checkIconId = checkIconId;
        this.itemId = itemId;

    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUnCheckIconId() {
        return unCheckIconId;
    }

    public void setUnCheckIconId(int unCheckIconId) {
        this.unCheckIconId = unCheckIconId;
    }

    public int getCheckIconId() {
        return checkIconId;
    }

    public void setCheckIconId(int checkIconId) {
        this.checkIconId = checkIconId;
    }
}
