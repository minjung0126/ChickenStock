package com.chicken.project.release.model.dto;

import java.sql.Date;

public class ReleaseSelectCriteria {
    private String searchDate;
    private String searchDate2;
    private String searchValue;

    public ReleaseSelectCriteria() {}

    public ReleaseSelectCriteria(String searchDate, String searchDate2, String searchValue) {
        this.searchDate = searchDate;
        this.searchDate2 = searchDate2;
        this.searchValue = searchValue;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public String getSearchDate2() {
        return searchDate2;
    }

    public void setSearchDate2(String searchDate2) {
        this.searchDate2 = searchDate2;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public String toString() {
        return "ReleaseSelectCriteria{" +
                "searchDate='" + searchDate + '\'' +
                ", searchDate2='" + searchDate2 + '\'' +
                ", searchValue='" + searchValue + '\'' +
                '}';
    }
}
