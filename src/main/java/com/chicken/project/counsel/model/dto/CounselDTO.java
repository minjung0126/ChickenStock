package com.chicken.project.counsel.model.dto;

import java.sql.Date;

public class CounselDTO {

    private int counselNo;
    private String counselName;
    private String counselContent;
    private Date counselRegistDate;
    private String storeId;
    private String counselYn;

    public CounselDTO() {}

    public CounselDTO(int counselNo, String counselName, String counselContent, Date counselRegistDate, String storeId, String counselYn) {
        this.counselNo = counselNo;
        this.counselName = counselName;
        this.counselContent = counselContent;
        this.counselRegistDate = counselRegistDate;
        this.storeId = storeId;
        this.counselYn = counselYn;
    }

    public int getCounselNo() {
        return counselNo;
    }

    public void setCounselNo(int counselNo) {
        this.counselNo = counselNo;
    }

    public String getCounselName() {
        return counselName;
    }

    public void setCounselName(String counselName) {
        this.counselName = counselName;
    }

    public String getCounselContent() {
        return counselContent;
    }

    public void setCounselContent(String counselContent) {
        this.counselContent = counselContent;
    }

    public Date getCounselRegistDate() {
        return counselRegistDate;
    }

    public void setCounselRegistDate(Date counselRegistDate) {
        this.counselRegistDate = counselRegistDate;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getCounselYn() {
        return counselYn;
    }

    public void setCounselYn(String counselYn) {
        this.counselYn = counselYn;
    }

    @Override
    public String toString() {
        return "CounselDTO{" +
                "counselNo=" + counselNo +
                ", counselName='" + counselName + '\'' +
                ", counselContent='" + counselContent + '\'' +
                ", counselRegistDate=" + counselRegistDate +
                ", storeId='" + storeId + '\'' +
                ", counselYn='" + counselYn + '\'' +
                '}';
    }
}
