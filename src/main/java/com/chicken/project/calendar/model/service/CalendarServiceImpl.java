package com.chicken.project.calendar.model.service;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.member.model.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public CalendarServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<CalendarDTO> selectCalendar() {

        List<CalendarDTO>  calList = employeeMapper.selectCalendar();

        return calList;
    }
}
