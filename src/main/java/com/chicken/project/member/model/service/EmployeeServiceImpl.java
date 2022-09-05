package com.chicken.project.member.model.service;

import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dto.EmployeeDTO;
import com.chicken.project.store.model.dao.StoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeMapper employeeMapper;

    private final StoreMapper storeMapper;

    @Autowired
    public EmployeeServiceImpl( EmployeeMapper employeeMapper, StoreMapper storeMapper) {

        this.employeeMapper = employeeMapper;
        this.storeMapper = storeMapper;
    }

    @Override
    public boolean selectEmpId(UserDetails member){

        String result = employeeMapper.selectEmpId(member);

        return result != null? true : false;
    }

    @Override
    public boolean selectStoreId(UserDetails member){

        String result = storeMapper.selectStoreId(member);

        return result != null? true : false;
    }

    @Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {

        EmployeeDTO member = employeeMapper.selectEmpInfo(empId);

        System.out.println("member = " + member);

        if(member == null){
            throw new UsernameNotFoundException("직원 정보가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();



        return member;
    };




}
