package com.chicken.project.calendar.model.service;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.member.model.dao.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    EmployeeMapper employeeMapper;

    @Override
    public List<CalendarDTO> selectCalendar() {

        List<CalendarDTO> calList = employeeMapper.selectCalendar();

        return calList;
    }
}
