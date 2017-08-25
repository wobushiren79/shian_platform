package com.shianlife.shian_platform.appenum;


import com.shianlife.shian_platform.R;

/**
 * Created by zm.
 */

public enum OrderItemShowEnum {
    cemetery(1, "圆满-公墓", R.drawable.order_cemetery_icon),
    funeral(2, "圆满-白事", R.drawable.order_funeral_icon),
    store(3, "圆满-商城", R.drawable.order_store_icon);

    private int code;
    private String name;
    private int itemPic;

    OrderItemShowEnum(int code, String name, int itemPic) {
        this.code = code;
        this.name = name;
        this.itemPic = itemPic;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemPic() {
        return itemPic;
    }

    public void setItemPic(int itemPic) {
        this.itemPic = itemPic;
    }
}
