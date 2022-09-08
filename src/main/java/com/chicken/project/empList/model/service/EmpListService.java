package com.chicken.project.empList.model.service;

import com.chicken.project.member.model.dto.EmpRoleDTO;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpListService {
    /* 직원 정보 리스트 조회 */
    List<EmployeeDTO> selectAllEmployee();

    /* 직원 정보 등록 */
    @Transactional
    int registEmp(EmployeeDTO emp);

    int selectCkAdminAuth(String empId);

    int insertAuth(String empId);

}
