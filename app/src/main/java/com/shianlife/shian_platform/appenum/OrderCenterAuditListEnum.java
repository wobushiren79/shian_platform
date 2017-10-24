package com.shianlife.shian_platform.appenum;

/**
 * Created by zm.
 */

public enum OrderCenterAuditListEnum {
    all(0, "全部"),
    wait_audit(1, "待审核"),
    audit_complete(2, "已完成");

    private int code;
    private String name;

    OrderCenterAuditListEnum(int code, String name) {
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
