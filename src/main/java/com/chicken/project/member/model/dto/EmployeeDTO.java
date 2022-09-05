package com.chicken.project.member.model.dto;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmployeeDTO implements UserDetails {

    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String empPwd;
    private java.util.Date birth;

    private List<EmpRoleDTO> empRoleList;

    private List<CalendarDTO> calendar;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return getEmpPwd();
    }

    @Override
    public String getUsername() {
        return getEmpId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}