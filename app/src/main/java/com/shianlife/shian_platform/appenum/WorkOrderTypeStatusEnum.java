package com.shianlife.shian_platform.appenum;

/**
 * Created by zm
 * 类型:0殡仪 1公墓 2其他
 */
public enum WorkOrderTypeStatusEnum {
    funeral(0, "殡仪"),
    cemetery(1, "公墓"),
    other(2, "其他");

    private int code;
    private String name;

    WorkOrderTypeStatusEnum(int code, String name) {
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

    public static String getValueText(Integer status) {
        if (status == null)
            return null;
        for (WorkOrderTypeStatusEnum e : WorkOrderTypeStatusEnum.values()) {
            if (e.getCode() == status) {
                return e.getName();
            }
        }
        return null;
    }
}
