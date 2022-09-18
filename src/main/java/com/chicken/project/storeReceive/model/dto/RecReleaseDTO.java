package com.chicken.project.storeReceive.model.dto;

import java.sql.Date;

public class RecReleaseDTO {

    private String relCode;
    private String relName;
    private java.sql.Date relDate;
    private String relYn;
    private String storeName;
    private String totalMoney;
    private java.sql.Date relListDate;

    public RecReleaseDTO() {
    }

    public RecReleaseDTO(String relCode, String relName, Date relDate, String relYn, String storeName, String totalMoney, Date relListDate) {
        this.relCode = relCode;
        this.relName = relName;
        this.relDate = relDate;
        this.relYn = relYn;
        this.storeName = storeName;
        this.totalMoney = totalMoney;
        this.relListDate = relListDate;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
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

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getRelListDate() {
        return relListDate;
    }

    public void setRelListDate(Date relListDate) {
        this.relListDate = relListDate;
    }

    @Override
    public String toString() {
        return "RecReleaseDTO{" +
                "relCode='" + relCode + '\'' +
                ", relName='" + relName + '\'' +
                ", relDate=" + relDate +
                ", relYn='" + relYn + '\'' +
                ", storeName='" + storeName + '\'' +
                ", totalMoney='" + totalMoney + '\'' +
                ", relListDate=" + relListDate +
                '}';
    }
}
