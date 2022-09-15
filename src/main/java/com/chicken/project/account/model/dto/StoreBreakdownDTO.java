package com.chicken.project.account.model.dto;

import java.sql.Date;

public class StoreBreakdownDTO {

    private String storeName;
    private Date breakdownDate;
    private int withdrawal;

    public StoreBreakdownDTO() {}

    public StoreBreakdownDTO(String storeName, Date breakdownDate, int withdrawal) {
        this.storeName = storeName;
        this.breakdownDate = breakdownDate;
        this.withdrawal = withdrawal;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getBreakdownDate() {
        return breakdownDate;
    }

    public void setBreakdownDate(Date breakdownDate) {
        this.breakdownDate = breakdownDate;
    }

    public int getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(int withdrawal) {
        this.withdrawal = withdrawal;
    }

    @Override
    public String toString() {
        return "StoreBreakdownDTO{" +
                "storeName='" + storeName + '\'' +
                ", breakdownDate=" + breakdownDate +
                ", withdrawal=" + withdrawal +
                '}';
    }
}
