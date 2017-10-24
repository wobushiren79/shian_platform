package com.shianlife.shian_platform.mvp.store.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class StoreAuditPerformSubmitBean extends BaseHttpParams {
    /**
     * 订单执行信息表ID
     */
    private Long performId;
    /**
     * 审核文字
     */
    private String auditInfo;

    /**
     * 审核结果：0未审核  1审核通过 2审核未通过
     */
    private Integer auditResult;



    public Long getPerformId() {
        return performId;
    }

    public void setPerformId(Long performId) {
        this.performId = performId;
    }

    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Integer getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }
}
