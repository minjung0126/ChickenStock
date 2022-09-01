package com.chicken.project.empList.model.dao;

import com.chicken.project.empList.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee();
}
