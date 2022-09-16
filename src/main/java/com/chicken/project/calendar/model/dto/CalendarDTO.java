package com.chicken.project.calendar.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
public class CalendarDTO {

    private int calNo;
    private String calName;
    private java.sql.Date startDay;
    private java.sql.Date endDay;
    private String content;
    private String empId;
    private String groupNO;

    public CalendarDTO() {
    }

    public CalendarDTO(int calNo, String calName, Date startDay, Date endDay, String content, String empId, String groupNO) {
        this.calNo = calNo;
        this.calName = calName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.content = content;
        this.empId = empId;
        this.groupNO = groupNO;
    }

    public int getCalNo() {
        return calNo;
    }

    public void setCalNo(int calNo) {
        this.calNo = calNo;
    }

    public String getCalName() {
        return calName;
    }

    public void setCalName(String calName) {
        this.calName = calName;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getGroupNO() {
        return groupNO;
    }

    public void setGroupNO(String groupNO) {
        this.groupNO = groupNO;
    }

    @Override
    public String toString() {
        return "CalendarDTO{" +
                "calNo=" + calNo +
                ", calName='" + calName + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", content='" + content + '\'' +
                ", empId='" + empId + '\'' +
                ", groupNO='" + groupNO + '\'' +
                '}';
    }
}