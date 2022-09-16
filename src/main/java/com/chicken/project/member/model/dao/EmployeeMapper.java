package com.chicken.project.member.model.dao;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.member.model.dto.EmpRoleDTO;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee();
    int insertEmployee(EmployeeDTO emp);
    int insertEmpRole(EmployeeDTO emp);
    EmployeeDTO selectEmpInfo(String empId);
    int selectCkAdminAuth(String empId);
    int insertAuth(String empId);
    List<CalendarDTO>  selectCalendar();
}
