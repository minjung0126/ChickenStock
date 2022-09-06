package com.chicken.project.member.model.dto;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;

public class EmployeeImpl extends User {

    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String empPwd;
    private java.util.Date birth;


    private List<EmpRoleDTO> empRoleList;

    private List<CalendarDTO> calendar;

    public EmployeeImpl(String empId, String empPwd, Collection<? extends GrantedAuthority> authorities) {
        super(empId, empPwd, authorities);
    }

    public void setDetails(EmployeeDTO member) {
        this.empId = member.getEmpId();
        this.empName = member.getEmpName();
        this.empPhone = member.getEmpPhone();
        this.empEmail = member.getEmpEmail();
        this.empPwd = member.getEmpPwd();
        this.birth = member.getBirth();
        this.empRoleList = member.getEmpRoleList();
        this.calendar = member.getCalendar();

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

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPwd='" + empPwd + '\'' +
                ", birth=" + birth +
                ", empRoleList=" + empRoleList +
                ", calendar=" + calendar +
                '}';
    }
}