package com.chicken.project.member.model.service;

import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dao.StoreMemberMapper;
import com.chicken.project.member.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeMapper employeeMapper;

    private final StoreMemberMapper storeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, StoreMemberMapper storeMapper) {

        this.employeeMapper = employeeMapper;
        this.storeMapper = storeMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("[EmployeeService]================================= ");
        log.info("[EmployeeService] empId = " + username);

        EmployeeDTO empMember = employeeMapper.selectEmpInfo(username);
        StoreMemberDTO storeMember = storeMapper.selectStoreInfo(username);

        log.info("[EmployeeService] member = " + empMember);

        EmployeeImpl member = null;

        if(empMember != null){

            List<GrantedAuthority> authorities = new ArrayList<>();

            if(empMember.getEmpRoleList() != null) {

                List<EmpRoleDTO> roleList = empMember.getEmpRoleList();

                for(int i = 0; i < roleList.size(); i++){

                    AuthDTO authority = roleList.get(i).getAuthority();
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
                }
            }

            member = new EmployeeImpl(empMember.getEmpId(), empMember.getEmpPwd(), authorities);
            member.setDetails(empMember);

        } else if(storeMember != null){

            List<GrantedAuthority> authorities = new ArrayList<>();

            if(member.getStoreRoleList() != null){

                List<StoreRoleDTO> roleList = member.getStoreRoleList();

                for(int i = 0; i < roleList.size(); i++){

                    AuthDTO authority = roleList.get(i).getAuthority();
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
                }

                member = new EmployeeImpl(member.getStoreId(), member.getStorePwd(), authorities);
                member.setDetails(storeMember);
            }
        }

        return member;


//        if(empMember == null){
//            throw new UsernameNotFoundException("직원 정보가 존재하지 않습니다.");
//        }

//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if(member.getEmpRoleList() != null) {
//
//            List<EmpRoleDTO> roleList = member.getEmpRoleList();
//
//            for(int i = 0; i < roleList.size(); i++){
//
//                AuthDTO authority = roleList.get(i).getAuthority();
//                authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
//            }
//        }
//
//        EmployeeImpl emp = new EmployeeImpl(member.getEmpId(), member.getEmpPwd(), authorities);
//        emp.setDetails(member);

//        return emp;
    }

}
