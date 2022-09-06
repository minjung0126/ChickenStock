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


    private String storeName;
    private String storeAccount;
    private String storeRep;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storeId;
    private String storePwd;
    private String storeNo;

    private List<StoreRoleDTO> storeRoleList;

    public EmployeeImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
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

    public void setDetails(StoreMemberDTO member) {
        this.storeName = member.getStoreName();
        this.storeAccount = member.getStoreAccount();
        this.storeRep = member.getStoreRep();
        this.storeAddress = member.getStoreAddress();
        this.storePhone = member.getStoreAddress();
        this.storeEmail = member.getStoreEmail();
        this.storeId = member.getStoreId();
        this.storePwd = member.getStorePwd();
        this.storeNo = member.getStoreNo();
        this.storeRoleList = member.getStoreRoleList();
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

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAccount() {
        return storeAccount;
    }

    public String getStoreRep() {
        return storeRep;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStorePwd() {
        return storePwd;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public List<StoreRoleDTO> getStoreRoleList() {
        return storeRoleList;
    }

    @Override
    public String toString() {
        return "EmployeeImpl{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPwd='" + empPwd + '\'' +
                ", birth=" + birth +
                ", empRoleList=" + empRoleList +
                ", calendar=" + calendar +
                ", storeName='" + storeName + '\'' +
                ", storeAccount='" + storeAccount + '\'' +
                ", storeRep='" + storeRep + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", storeEmail='" + storeEmail + '\'' +
                ", storeId='" + storeId + '\'' +
                ", storePwd='" + storePwd + '\'' +
                ", storeNo='" + storeNo + '\'' +
                ", storeRoleList=" + storeRoleList +
                '}';
    }
}