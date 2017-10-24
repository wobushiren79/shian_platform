
package com.shianlife.shian_platform.mvp.ordercenter.bean;


import com.shianlife.shian_platform.base.BaseEntity;



public class PerformerAssignRecord extends BaseEntity {


	/**
	 * 工单id
	 */
    private Long orderId;

	/**
	 * 执行人员id
	 */
    private Long performerId;

	/**
	 * 执行人员处理状态 1待接单 2处理中  3审核中 4已完成 5已取消 6已拒单
	 */
    private Integer assignStatus;

	/**
	 * 接/拒单时间
	 */
    private String dealDate;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPerformerId() {
		return performerId;
	}

	public void setPerformerId(Long performerId) {
		this.performerId = performerId;
	}

	public Integer getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(Integer assignStatus) {
		this.assignStatus = assignStatus;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
}
