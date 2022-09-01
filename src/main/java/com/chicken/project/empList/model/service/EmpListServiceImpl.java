package com.chicken.project.empList.model.service;

import com.chicken.project.empList.model.dao.EmployeeMapper;
import com.chicken.project.empList.model.dto.EmployeeDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service("empListService")
public class EmpListServiceImpl implements EmpService{

    private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmpListServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> selectAllEmployee() {

        List<EmployeeDTO> empList = employeeMapper.selectAllEmployee();

        return empList;
    }
    
    @Transactional
    public void registEmp(EmployeeDTO emp){
        
        log.info("[EmpListService] Insert Employee : " + emp);
        
        int result = employeeMapper.insertEmployee(emp);

        log.info("[EmpListService] Insert result : " + ((result > 0)? "직원 정보 추가 성공" : "직원 정보 추가 실패"));
        
    }
}
