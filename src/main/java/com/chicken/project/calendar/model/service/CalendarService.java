package com.chicken.project.calendar.model.service;

import com.chicken.project.calendar.model.dto.CalendarDTO;

import java.util.List;

public interface CalendarService {
    List<CalendarDTO> selectCalendar();
}
