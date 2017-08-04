package com.shianlife.shian_platform.appenum;

/**
 * Created by zm.
 */

public enum  StoreOrderAuditListEnum {
    auditing(1, "审核中"),
    servicesuccess(2, "服务完成");

    private int code;
    private String name;

    StoreOrderAuditListEnum(int code, String name) {
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
