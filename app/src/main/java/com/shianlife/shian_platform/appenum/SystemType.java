package com.shianlife.shian_platform.appenum;

/**
 * Created by zm.
 */

public enum SystemType {
    funeral(1, "殡仪"),
    cemetery(2, "公墓"),
    platform(3, "平台");

    private int code;
    private String name;

    SystemType(int code, String name) {
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
