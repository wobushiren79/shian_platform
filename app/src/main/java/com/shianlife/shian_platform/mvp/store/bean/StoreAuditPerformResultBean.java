package com.shianlife.shian_platform.mvp.store.bean;

/**
 * Created by zm.
 */

public class StoreAuditPerformResultBean {
    private String completeInfo;
    private String completePic;
    private GoodsPerform goodsPerform;

    public String getCompleteInfo() {
        return completeInfo;
    }

    public void setCompleteInfo(String completeInfo) {
        this.completeInfo = completeInfo;
    }

    public String getCompletePic() {
        return completePic;
    }

    public void setCompletePic(String completePic) {
        this.completePic = completePic;
    }

    public GoodsPerform getGoodsPerform() {
        return goodsPerform;
    }

    public void setGoodsPerform(GoodsPerform goodsPerform) {
        this.goodsPerform = goodsPerform;
    }
}
