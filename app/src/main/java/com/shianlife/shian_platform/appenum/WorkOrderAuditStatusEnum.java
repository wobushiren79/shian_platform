package com.shianlife.shian_platform.appenum;

/**
 * Created by zm
 */
public enum WorkOrderAuditStatusEnum {
    no_pass(0, "再次审核"),
    pass(1, "结束审核");

    private int code;
    private String name;

    WorkOrderAuditStatusEnum(int code, String name) {
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
