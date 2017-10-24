package com.shianlife.shian_platform.mvp.ordercenter.bean;


import com.shianlife.shian_platform.base.BaseEntity;

public class PerformRecord extends BaseEntity {

    /**
     * 处理摘要
     */
    private String  performSummary;

    /**
     * 执行图片
     */
    private String  performPic;

    /**
     * 执行人员id
     */
    private Long    performerId;

    /**
     * 执行状态 值:0待完成  1提交审核
     */
    private Integer performStatus;

    /**
     * 订单id
     */
    private Long    orderId;

    public String getPerformSummary() {
        return performSummary;
    }

    public void setPerformSummary(String performSummary) {
        this.performSummary = performSummary;
    }

    public String getPerformPic() {
        return performPic;
    }

    public void setPerformPic(String performPic) {
        this.performPic = performPic;
    }

    public Long getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Long performerId) {
        this.performerId = performerId;
    }

    public Integer getPerformStatus() {
        return performStatus;
    }

    public void setPerformStatus(Integer performStatus) {
        this.performStatus = performStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
