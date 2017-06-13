package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public class BaseDriverOrderResultItemBean extends BaseDataResult {
    private long orderId;//订单ID
    private int orderState;//订单状态
    private String customerPhone;//客户电话
    private String customer;//客户
    private String carNum;//车牌号
    private String personNum;//乘车人数
    private String getPersonTime;//接人时间
    private String source;//接人地
    private String target;//目的地
    private String remark;//备注
    private String takeCarLocation;//取车地
    /**
     * 出发地_经度
     */
    private String sourceLongitude;

    /**
     * 出发地_维度
     */
    private String sourceLatitude;

    /**
     * 目的地
     */
    private String targetLongitude;

    /**
     * 目的地_维度
     */
    private String targetLatitude;
    /**
     * 取车地_经度
     */
    private String takeCarLocationLongitude;

    /**
     * 取车地_维度
     */
    private String takeCarLocationLatitude;

    public String getTakeCarLocation() {
        return takeCarLocation;
    }

    public void setTakeCarLocation(String takeCarLocation) {
        this.takeCarLocation = takeCarLocation;
    }

    public String getTakeCarLocationLongitude() {
        return takeCarLocationLongitude;
    }

    public void setTakeCarLocationLongitude(String takeCarLocationLongitude) {
        this.takeCarLocationLongitude = takeCarLocationLongitude;
    }

    public String getTakeCarLocationLatitude() {
        return takeCarLocationLatitude;
    }

    public void setTakeCarLocationLatitude(String takeCarLocationLatitude) {
        this.takeCarLocationLatitude = takeCarLocationLatitude;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public String getGetPersonTime() {
        return getPersonTime;
    }

    public void setGetPersonTime(String getPersonTime) {
        this.getPersonTime = getPersonTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSourceLongitude() {
        return sourceLongitude;
    }

    public void setSourceLongitude(String sourceLongitude) {
        this.sourceLongitude = sourceLongitude;
    }

    public String getSourceLatitude() {
        return sourceLatitude;
    }

    public void setSourceLatitude(String sourceLatitude) {
        this.sourceLatitude = sourceLatitude;
    }

    public String getTargetLongitude() {
        return targetLongitude;
    }

    public void setTargetLongitude(String targetLongitude) {
        this.targetLongitude = targetLongitude;
    }

    public String getTargetLatitude() {
        return targetLatitude;
    }

    public void setTargetLatitude(String targetLatitude) {
        this.targetLatitude = targetLatitude;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
