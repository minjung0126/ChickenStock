package com.chicken.project.empList.model.service;

import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("empListService")
public class EmpListServiceImpl implements EmpListService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmpListServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    /* 직원 정보 리스트 조회 */
    @Override
    public List<EmployeeDTO> selectAllEmployee() {

        List<EmployeeDTO> empList = employeeMapper.selectAllEmployee();

        return empList;
    }

    /* 직원 정보 등록 */
    @Override
    @Transactional
    public int registEmp(EmployeeDTO emp){
        
        log.info("[EmpListService] Insert Employee : " + emp);
        
        int result = employeeMapper.insertEmployee(emp);

        log.info("[EmpListService] Insert result : " + ((result > 0)? "직원 정보 추가 성공" : "직원 정보 추가 실패"));

        return result;
    }
}
