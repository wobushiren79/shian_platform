package com.shianlife.shian_platform.mvp.ordercenter.bean;


import com.shianlife.shian_platform.base.BaseEntity;

public class CustomerInfo extends BaseEntity {

	/**
	 * 联系人姓名
	 */
    private String contactName;

	/**
	 * 联系人电话
	 */
    private String contactPhone;

	/**
	 * 经办人姓名
	 */
    private String agentName;

	/**
	 * 经办人电话
	 */
    private String agentPhone;

	/**
	 * 服务对象
	 */
    private String serviceTarget;

	/**
	 * 地址
	 */
    private String address;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getServiceTarget() {
		return serviceTarget;
	}

	public void setServiceTarget(String serviceTarget) {
		this.serviceTarget = serviceTarget;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
