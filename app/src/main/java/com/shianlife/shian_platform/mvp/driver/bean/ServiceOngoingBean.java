package com.shianlife.shian_platform.mvp.driver.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class ServiceOngoingBean extends BaseHttpParams {
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 照片
     */
    private String files;

    /**
     * 里程
     */
    private String km;

    /**
     * 操作步骤
     */
    private Integer opeType;

    /**
     * 百度地图经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 百度地图的地址用,隔开
     */
    private String address;

    /**
     * 设备序列号
     */
    private String deviceSerialNo;

    /**
     * 设备型号
     */
    private String deviceModelNo;

    /**
     * 设备操作系统
     */
    private String deviceOs;
    /**
     * 服务步骤
     */
    private Integer serviceStep;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public Integer getOpeType() {
        return opeType;
    }

    public void setOpeType(Integer opeType) {
        this.opeType = opeType;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeviceSerialNo() {
        return deviceSerialNo;
    }

    public void setDeviceSerialNo(String deviceSerialNo) {
        this.deviceSerialNo = deviceSerialNo;
    }

    public String getDeviceModelNo() {
        return deviceModelNo;
    }

    public void setDeviceModelNo(String deviceModelNo) {
        this.deviceModelNo = deviceModelNo;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public Integer getServiceStep() {
        return serviceStep;
    }

    public void setServiceStep(Integer serviceStep) {
        this.serviceStep = serviceStep;
    }
}
