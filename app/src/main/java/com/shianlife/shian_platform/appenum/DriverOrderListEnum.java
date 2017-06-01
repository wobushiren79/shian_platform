package com.shianlife.shian_platform.appenum;

/**
 * Created by zm.
 */

public enum DriverOrderListEnum {
    waitservice(1, "待服务"),
    inservice(2, "正在服务"),
    successservice(3, "服务成功"),
    failservice(4, "服务失败");

    private int code;
    private String name;

    DriverOrderListEnum(int code, String name) {
        this.code = code;
        this.name = name;
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
}
