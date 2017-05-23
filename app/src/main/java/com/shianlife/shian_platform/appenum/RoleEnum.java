package com.shianlife.shian_platform.appenum;

/**
 * Created by zm.
 */

public enum RoleEnum {
    DRIVER(1, "司机");

    private int code;
    private String name;

    RoleEnum(int code, String name) {
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
