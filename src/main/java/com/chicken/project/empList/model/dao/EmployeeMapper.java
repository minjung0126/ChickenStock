package com.chicken.project.empList.model.dao;

import com.chicken.project.empList.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee();
    int insertEmployee(EmployeeDTO emp);
    EmployeeDTO selectEmpInfo(String username);

    String selectEmpId(UserDetails member);
}
