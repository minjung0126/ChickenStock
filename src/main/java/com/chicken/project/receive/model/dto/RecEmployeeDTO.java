package com.chicken.project.receive.model.dto;

import java.util.Date;

public class RecEmployeeDTO {

    private String empName;
    private String empPhone;
    private String empEmail;
    private java.util.Date empBirth;
    private String memberId;

    public RecEmployeeDTO() {
    }

    public RecEmployeeDTO(String empName, String empPhone, String empEmail, Date empBirth, String memberId) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empBirth = empBirth;
        this.memberId = memberId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Date getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(Date empBirth) {
        this.empBirth = empBirth;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empBirth=" + empBirth +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
