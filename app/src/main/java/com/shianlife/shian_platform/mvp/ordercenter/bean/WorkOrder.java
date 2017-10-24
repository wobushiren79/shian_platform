package com.shianlife.shian_platform.mvp.ordercenter.bean;

import com.shianlife.shian_platform.base.BaseEntity;

import java.util.Date;

public class WorkOrder extends BaseEntity {

	/**
	 * 关联工单编号
	 */
    private String relateOrderNo;

	/**
	 * 工单编号
	 */
    private String orderNumber;

	/**
	 * 工单状态 1待分配 2待接单 3处理中  4审核中 5已完成
	 */
    private Integer orderStatus;

	/**
	 * 执行人员id
	 */
    private Long performerId;

	/**
	 * 审核人员id
	 */
    private Long auditorId;

	/**
	 * 客户信息id
	 */
    private Long customerInfoId;

	/**
	 * 备注
	 */
    private String orderRemark;

	/**
	 * 描述
	 */
    private String orderDescribe;

	/**
	 * 类型:0殡仪 1公墓 2其他
	 */
    private Integer orderType;

	/**
	 * 预约时间
	 */
    private String appointmentTime;

	/**
	 * 确认状态 值0未确认1已确认
	 */
    private Integer affrimStatus;

	/**
	 * 取消状态 值:0未取消 1已取消
	 */
    private Integer cancelStatus;

	/**
	 * 推荐人姓名
	 */
    private String refereeName;

	/**
	 * 推荐人电话
	 */
    private String refereePhone;

	/**
	 * 订单金额
	 */
    private Integer orderMoney;

	/**
	 *  分配类型 值: 0自动分配 1人工分配
	 */
    private Integer assignType;


	public String getRelateOrderNo() {
		return relateOrderNo;
	}

	public void setRelateOrderNo(String relateOrderNo) {
		this.relateOrderNo = relateOrderNo;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getPerformerId() {
		return performerId;
	}

	public void setPerformerId(Long performerId) {
		this.performerId = performerId;
	}

	public Long getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(Long auditorId) {
		this.auditorId = auditorId;
	}

	public Long getCustomerInfoId() {
		return customerInfoId;
	}

	public void setCustomerInfoId(Long customerInfoId) {
		this.customerInfoId = customerInfoId;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getOrderDescribe() {
		return orderDescribe;
	}

	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Integer getAffrimStatus() {
		return affrimStatus;
	}

	public void setAffrimStatus(Integer affrimStatus) {
		this.affrimStatus = affrimStatus;
	}

	public Integer getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(Integer cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public String getRefereeName() {
		return refereeName;
	}

	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}

	public String getRefereePhone() {
		return refereePhone;
	}

	public void setRefereePhone(String refereePhone) {
		this.refereePhone = refereePhone;
	}

	public Integer getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Integer orderMoney) {
		this.orderMoney = orderMoney;
	}

	public Integer getAssignType() {
		return assignType;
	}

	public void setAssignType(Integer assignType) {
		this.assignType = assignType;
	}
}
