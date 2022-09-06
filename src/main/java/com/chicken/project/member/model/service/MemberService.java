package com.chicken.project.member.model.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MemberService{
    boolean selectEmpId(UserDetails member);

    boolean selectStoreId(UserDetails member);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
