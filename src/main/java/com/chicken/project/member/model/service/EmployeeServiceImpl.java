package com.chicken.project.member.model.service;

import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dto.AuthDTO;
import com.chicken.project.member.model.dto.EmpRoleDTO;
import com.chicken.project.member.model.dto.EmployeeDTO;
import com.chicken.project.member.model.dto.EmployeeImpl;
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

    @Autowired
    public EmployeeServiceImpl( EmployeeMapper employeeMapper) {

        this.employeeMapper = employeeMapper;
    }

//    @Override
//    public boolean selectEmpId(EmployeeDTO emp){
//
//        String result = employeeMapper.selectEmpId(emp);
//
//        return result != null? true : false;
//    }

    @Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {

        log.info("[EmployeeService]================================= ");
        log.info("[EmployeeService] member = " + empId);

        EmployeeDTO member = employeeMapper.selectEmpInfo(empId);

        log.info("[EmployeeService] member = " + member);

        if(member == null){
            throw new UsernameNotFoundException("직원 정보가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(member.getEmpRoleList() != null) {

            List<EmpRoleDTO> roleList = member.getEmpRoleList();

            for(int i = 0; i < roleList.size(); i++){

                AuthDTO authority = roleList.get(i).getAuthority();
                authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
            }
        }

        EmployeeImpl emp = new EmployeeImpl(member.getEmpId(), member.getEmpPwd(), authorities);
        emp.setDetails(member);

        return emp;
    }

}
