package com.chicken.project.member.model.dao;

import com.chicken.project.member.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee();
    int insertEmployee(EmployeeDTO emp);
    EmployeeDTO selectEmpInfo(String empId);

}
