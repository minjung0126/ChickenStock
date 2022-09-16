package com.chicken.project.account.model.dto;

import java.sql.Date;

public class StoreDepositDTO {

    private String storeName;
    private int depositMoney;
    private Date depositDate;

    private String content;

    public StoreDepositDTO() {}

    public StoreDepositDTO(String storeName, int depositMoney, Date depositDate, String content) {
        this.storeName = storeName;
        this.depositMoney = depositMoney;
        this.depositDate = depositDate;
        this.content = content;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "StoreDepositDTO{" +
                "storeName='" + storeName + '\'' +
                ", depositMoney=" + depositMoney +
                ", depositDate=" + depositDate +
                ", content='" + content + '\'' +
                '}';
    }
}
