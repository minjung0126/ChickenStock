package com.chicken.project.member.model.service;

import com.chicken.project.member.model.dto.EmployeeDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MemberService extends UserDetailsService{

    int updateEmailCode(EmployeeDTO emp) throws MessagingException, UnsupportedEncodingException;
}
