package com.shianlife.shian_platform.appenum;

/**
 * 订单是否有效，值：1有效（初始值）、0失效
 * Created by xGang
 */
public enum ValidStatus {
    valid(1,"有效"),
    invalid(0,"失效");
    private Integer code;
    private String text;

    ValidStatus(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
