package com.chicken.project.account.model.dto;

import java.sql.Date;

public class StoreBreakdownDTO {

    private String storeName;
    private Date breakdownDate;
    private int withdrawal;
    private String content;

    public StoreBreakdownDTO() {}

    public StoreBreakdownDTO(String storeName, Date breakdownDate, int withdrawal, String content) {
        this.storeName = storeName;
        this.breakdownDate = breakdownDate;
        this.withdrawal = withdrawal;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "StoreBreakdownDTO{" +
                "storeName='" + storeName + '\'' +
                ", breakdownDate=" + breakdownDate +
                ", withdrawal=" + withdrawal +
                ", content='" + content + '\'' +
                '}';
    }
}
