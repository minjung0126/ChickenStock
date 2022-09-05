package com.chicken.project.member.model.service;

import com.chicken.project.empList.model.dao.EmployeeMapper;
import com.chicken.project.empList.model.dto.EmployeeDTO;
import com.chicken.project.member.model.dao.MemberMapper;
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

    private final MemberMapper memberMapper;

    private final EmployeeMapper employeeMapper;

    private final StoreMapper storeMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, EmployeeMapper employeeMapper, StoreMapper storeMapper) {
        this.memberMapper = memberMapper;
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

//        MemeberDTO member = memberMapper
//
//        if(empInfo != null){
//
//            EmployeeDTO member = empInfo;
//        } else {
//
//            StoreDTO member = storeInfo;
//        }
//
//        if(member == null){
//            throw new UsernameNotFoundException("직원 정보가 존재하지 않습니다.");
//        }

        return null;
    };




}
