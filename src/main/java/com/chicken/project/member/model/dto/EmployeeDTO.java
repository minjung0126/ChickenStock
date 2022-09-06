package com.chicken.project.member.model.dto;

import com.chicken.project.calendar.model.dto.CalendarDTO;

import java.util.Date;
import java.util.List;

public class EmployeeDTO {

    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String empPwd;
    private java.util.Date birth;

    private List<EmpRoleDTO> empRoleList;

    private List<CalendarDTO> calendar;

    public EmployeeDTO() {
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public Date getBirth() {
        return birth;
    }

    public List<EmpRoleDTO> getEmpRoleList() {
        return empRoleList;
    }

    public List<CalendarDTO> getCalendar() {
        return calendar;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setEmpRoleList(List<EmpRoleDTO> empRoleList) {
        this.empRoleList = empRoleList;
    }

    public void setCalendar(List<CalendarDTO> calendar) {
        this.calendar = calendar;
    }


}
