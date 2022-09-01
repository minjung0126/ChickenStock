package com.chicken.project.release.model.dto;

import java.sql.Date;

public class ReleaseDTO {

    private int relCode;
    private String relName;
    private java.sql.Date relRequestDate;
    private java.sql.Date relDate;
    private String relYn;
    private String storeName;
    private String orderNo;

    public ReleaseDTO() {}

    public ReleaseDTO(int relCode, String relName, Date relRequestDate, Date relDate, String relYn, String storeName, String orderNo) {
        this.relCode = relCode;
        this.relName = relName;
        this.relRequestDate = relRequestDate;
        this.relDate = relDate;
        this.relYn = relYn;
        this.storeName = storeName;
        this.orderNo = orderNo;
    }

    public int getRelCode() {
        return relCode;
    }

    public void setRelCode(int relCode) {
        this.relCode = relCode;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public Date getRelRequestDate() {
        return relRequestDate;
    }

    public void setRelRequestDate(Date relRequestDate) {
        this.relRequestDate = relRequestDate;
    }

    public Date getRelDate() {
        return relDate;
    }

    public void setRelDate(Date relDate) {
        this.relDate = relDate;
    }

    public String getRelYn() {
        return relYn;
    }

    public void setRelYn(String relYn) {
        this.relYn = relYn;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "ReleaseDTO{" +
                "relCode=" + relCode +
                ", relName='" + relName + '\'' +
                ", relRequestDate=" + relRequestDate +
                ", relDate=" + relDate +
                ", relYn='" + relYn + '\'' +
                ", storeName='" + storeName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
