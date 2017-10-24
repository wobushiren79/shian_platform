package com.shianlife.shian_platform.mvp.ordercenter.bean;


import com.shianlife.shian_platform.base.BaseEntity;

public class OrderStatusChange extends BaseEntity {

	/**
	 * 工单id
	 */
    private Long orderId;

	/**
	 * 订单状态变化时间
	 */
    private String updateTime;

	/**
	 * 工单状态 0待确定 1待分配 2待接单 3处理中  4审核中 5已完成 6已取消
	 */
    private Integer updataStatus;


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdataStatus() {
		return updataStatus;
	}

	public void setUpdataStatus(Integer updataStatus) {
		this.updataStatus = updataStatus;
	}
}
