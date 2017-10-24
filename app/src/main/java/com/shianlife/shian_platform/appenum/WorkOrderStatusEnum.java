package com.shianlife.shian_platform.appenum;

/**
 * Created by zm
 * 工单状态 0已确认1待分配 2待接单 3处理中  4审核中 5已完成
 */
public enum WorkOrderStatusEnum {
    affirmed(0, "已确认"),
    waitassign(1, "待分配"),
    waitaccept(2, "待接单"),
    handling(3, "处理中"),
    auditing(4, "审核中"),
    finished(5, "已完成"),
    canceled(6, "已取消");

    private int code;
    private String name;

    WorkOrderStatusEnum(int code, String name) {
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

    public static String getValueText(int status) {
        for (WorkOrderStatusEnum e : WorkOrderStatusEnum.values()) {
            if (e.getCode() == status) {
                return e.getName();
            }
        }
        return null;
    }
}
