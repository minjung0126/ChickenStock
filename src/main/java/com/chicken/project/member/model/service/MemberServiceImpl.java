package com.chicken.project.member.model.service;

import com.chicken.project.empList.model.dao.EmployeeMapper;
import com.chicken.project.empList.model.dto.EmployeeDTO;
import com.chicken.project.store.model.dao.StoreMapper;
import com.chicken.project.store.model.dto.StoreDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeMapper employeeMapper;

    private final StoreMapper storeMapper;

    @Autowired
    public MemberServiceImpl( EmployeeMapper employeeMapper, StoreMapper storeMapper) {
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        EmployeeDTO empDTO = employeeMapper.selectEmpInfo(username);

        UserDetails member = (UserDetails) empDTO;

        if(empDTO == null){

            StoreDTO storeDTO = storeMapper.selectStoreInfo(username);

            member = (UserDetails) storeDTO;
        }

        if(member == null){
            throw new UsernameNotFoundException("직원 정보가 존재하지 않습니다.");
        }

        return member;
    };




}
