package com.chicken.project.calendar.controller;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.calendar.model.service.CalendarServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CalendarServiceImpl calendarService;

    @Autowired
    public CalendarController(CalendarServiceImpl calendarService) {
        this.calendarService = calendarService;
    }


    /* 일정 조회 */
    @GetMapping("/calendar")
    public String CalMain(){

        log.info("[CalendarController]  ========================================");

        return "/calendar/calendar";
    }

    @GetMapping(value = {"calList"}, produces = {"application/json;"})
    @ResponseBody
    public List<CalendarDTO> selectCal(){

        return calendarService.selectCalendar();
    }



    @PostMapping("/calendar")
    public String calendar(){

        return null;
    }
}
