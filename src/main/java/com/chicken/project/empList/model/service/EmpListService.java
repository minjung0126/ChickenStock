package com.chicken.project.empList.model.service;

import com.chicken.project.empList.model.dao.EmployeeMapper;
import com.chicken.project.empList.model.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpListService {

    private final EmployeeMapper employeeMapper;

    public EmpListService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> selectAllEmployee() {

        List<EmployeeDTO> empList = employeeMapper.selectAllEmployee();

        return empList;
    }
}
