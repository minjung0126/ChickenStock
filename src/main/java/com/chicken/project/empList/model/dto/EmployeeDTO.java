package com.chicken.project.empList.model.dto;

import java.util.Date;

public class EmployeeDTO {

    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String menagerYn;
    private String empPwd;
    private java.util.Date birth;
    private String memberType;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String empId, String empName, String empPhone, String empEmail, String menagerYn, String empPwd, Date birth, String memberType) {
        this.empId = empId;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.menagerYn = menagerYn;
        this.empPwd = empPwd;
        this.birth = birth;
        this.memberType = memberType;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public String getMenagerYn() {
        return menagerYn;
    }

    public void setMenagerYn(String menagerYn) {
        this.menagerYn = menagerYn;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", menagerYn='" + menagerYn + '\'' +
                ", empPwd='" + empPwd + '\'' +
                ", birth=" + birth +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}