package com.chicken.project.member.model.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface EmployeeService {
    boolean selectEmpId(UserDetails member);

    boolean selectStoreId(UserDetails member);

    UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException;
}
