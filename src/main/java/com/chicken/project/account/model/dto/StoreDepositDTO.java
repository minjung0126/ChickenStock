package com.chicken.project.account.model.dto;

import java.sql.Date;

public class StoreDepositDTO {

    private String storeName;
    private int depositMoney;
    private Date depositDate;

    public StoreDepositDTO() {}

    public StoreDepositDTO(String storeName, int depositMoney, Date depositDate) {
        this.storeName = storeName;
        this.depositMoney = depositMoney;
        this.depositDate = depositDate;
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

    @Override
    public String toString() {
        return "StoreDepositDTO{" +
                "storeName='" + storeName + '\'' +
                ", depositMoney=" + depositMoney +
                ", depositDate=" + depositDate +
                '}';
    }
}
