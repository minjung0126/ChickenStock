package com.chicken.project.calendar.controller;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.calendar.model.service.CalendarService;
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
    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    /* 일정 조회 */
    @GetMapping("/calendar")
    @ResponseBody
    public List<Map<String, Object>> selectCal(){

        log.info("[CalendarService] selectCalendar ========================================");

        List<CalendarDTO> calList = calendarService.selectCalendar();

        log.info("[CalendarService] calList : " + calList);

        HashMap<String, Object> hash = new HashMap<>();
        ArrayList data = new ArrayList<>();

        for(int i = 0; i < calList.size(); i++){
            hash.put("calName", calList.get(i).getCalName());
            hash.put("startDay", calList.get(i).getStartDay());
            hash.put("endDay", calList.get(i).getEndDay());
        }
        data.add(hash);

        return data;
    }

//    @PostMapping("/calendar")
//    public String calendar(){
//
//        return null;
//    }
}
