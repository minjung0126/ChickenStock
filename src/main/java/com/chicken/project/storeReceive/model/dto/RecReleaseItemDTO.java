package com.chicken.project.storeReceive.model.dto;

import java.sql.Date;

public class RecReleaseItemDTO {

    private String relYn;
    private int relAmount;
    private String relCode;
    private int itemNo;
    private int orderAmount;
    private java.sql.Date relDate;
    private java.sql.Date relItemRequestDate;
    private String storeName;
    private int totalMoney;
    private int orderNo;
    private int relCodeDetail;
    private String relListYn;

    public RecReleaseItemDTO() {
    }

    public RecReleaseItemDTO(String relYn, int relAmount, String relCode, int itemNo, int orderAmount, Date relDate, Date relItemRequestDate, String storeName, int totalMoney, int orderNo, int relCodeDetail, String relListYn) {
        this.relYn = relYn;
        this.relAmount = relAmount;
        this.relCode = relCode;
        this.itemNo = itemNo;
        this.orderAmount = orderAmount;
        this.relDate = relDate;
        this.relItemRequestDate = relItemRequestDate;
        this.storeName = storeName;
        this.totalMoney = totalMoney;
        this.orderNo = orderNo;
        this.relCodeDetail = relCodeDetail;
        this.relListYn = relListYn;
    }

    public String getRelYn() {
        return relYn;
    }

    public void setRelYn(String relYn) {
        this.relYn = relYn;
    }

    public int getRelAmount() {
        return relAmount;
    }

    public void setRelAmount(int relAmount) {
        this.relAmount = relAmount;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getRelDate() {
        return relDate;
    }

    public void setRelDate(Date relDate) {
        this.relDate = relDate;
    }

    public Date getRelItemRequestDate() {
        return relItemRequestDate;
    }

    public void setRelItemRequestDate(Date relItemRequestDate) {
        this.relItemRequestDate = relItemRequestDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getRelCodeDetail() {
        return relCodeDetail;
    }

    public void setRelCodeDetail(int relCodeDetail) {
        this.relCodeDetail = relCodeDetail;
    }

    public String getRelListYn() {
        return relListYn;
    }

    public void setRelListYn(String relListYn) {
        this.relListYn = relListYn;
    }

    @Override
    public String toString() {
        return "RecReleaseItemDTO{" +
                "relYn='" + relYn + '\'' +
                ", relAmount=" + relAmount +
                ", relCode='" + relCode + '\'' +
                ", itemNo=" + itemNo +
                ", orderAmount=" + orderAmount +
                ", relDate=" + relDate +
                ", relItemRequestDate=" + relItemRequestDate +
                ", storeName='" + storeName + '\'' +
                ", totalMoney=" + totalMoney +
                ", orderNo=" + orderNo +
                ", relCodeDetail=" + relCodeDetail +
                ", relListYn='" + relListYn + '\'' +
                '}';
    }
}
