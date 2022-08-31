package com.chicken.project.member.model.dto;

import java.util.Date;

public class EmployeeDTO {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String menagerYn;
    private String pwd;
    private java.util.Date birth;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String id, String name, String phone, String email, String menagerYn, String pwd, Date birth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.menagerYn = menagerYn;
        this.pwd = pwd;
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMenagerYn() {
        return menagerYn;
    }

    public void setMenagerYn(String menagerYn) {
        this.menagerYn = menagerYn;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", menagerYn='" + menagerYn + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birth=" + birth +
                '}';
    }
}
