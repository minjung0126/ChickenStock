package com.chicken.project.calendar.controller;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.calendar.model.service.CalendarServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

        log.info("[CalendarController] 조회 확인 ========================================");

        return "/calendar/calendar";
    }

    @GetMapping(value = {"calList"}, produces = {"application/json;"})
    @ResponseBody
    public List<CalendarDTO> selectCal(){

        return calendarService.selectCalendar();
    }

    @PostMapping("/calInsert")
    @ResponseBody
    public int calInsert(@ModelAttribute CalendarDTO cal,@RequestParam String calName, @RequestParam String calCon, @RequestParam java.sql.Date calStart, @RequestParam java.sql.Date calEnd, @AuthenticationPrincipal User user){


        cal.setCalName(calName);
        cal.setContent(calCon);
        cal.setStartDay(calStart);
        cal.setEndDay(calEnd);
        cal.setEmpId(user.getUsername());

        log.info("[CalendarController] cal : " + cal);

        int result = calendarService.insertCal(cal);

        return result;
    }

    @ResponseBody
    @PostMapping("/calDelete")
    public int calDelete(@ModelAttribute CalendarDTO cal,@RequestParam String calName, @RequestParam String content){


        cal.setCalName(calName);
        cal.setContent(content);

        log.info("[CalendarController] calNo : " + cal);

        int result = calendarService.deleteCal(cal);

        log.info("[CalendarController] result : " + result);

        return result;
    }
}
