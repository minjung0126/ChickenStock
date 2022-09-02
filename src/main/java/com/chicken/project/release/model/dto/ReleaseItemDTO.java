package com.chicken.project.release.model.dto;

import java.sql.Date;

public class ReleaseItemDTO {

    private String relYn;
    private int relAmount;
    private int relCode;
    private int itemNo;
    private int orderAmount;
    private java.sql.Date relDate;
    private java.sql.Date relItemRequestDate;
    private String storeName;
    private int totalItemMoney;

    public ReleaseItemDTO() {}

    public ReleaseItemDTO(String relYn, int relAmount, int relCode, int itemNo, int orderAmount, Date relDate, Date relItemRequestDate, String storeName, int totalItemMoney) {
        this.relYn = relYn;
        this.relAmount = relAmount;
        this.relCode = relCode;
        this.itemNo = itemNo;
        this.orderAmount = orderAmount;
        this.relDate = relDate;
        this.relItemRequestDate = relItemRequestDate;
        this.storeName = storeName;
        this.totalItemMoney = totalItemMoney;
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

    public int getRelCode() {
        return relCode;
    }

    public void setRelCode(int relCode) {
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

    public int getTotalItemMoney() {
        return totalItemMoney;
    }

    public void setTotalItemMoney(int totalItemMoney) {
        this.totalItemMoney = totalItemMoney;
    }

    @Override
    public String toString() {
        return "ReleaseItemDTO{" +
                "relYn='" + relYn + '\'' +
                ", relAmount=" + relAmount +
                ", relCode=" + relCode +
                ", itemNo=" + itemNo +
                ", orderAmount=" + orderAmount +
                ", relDate=" + relDate +
                ", relItemRequestDate=" + relItemRequestDate +
                ", storeName='" + storeName + '\'' +
                ", totalItemMoney=" + totalItemMoney +
                '}';
    }
}
