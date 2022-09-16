package com.chicken.project.calendar.controller;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.calendar.model.service.CalendarService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
    public String CalMain(){

        log.info("[CalendarController]  ========================================");

        return "/calendar/calendar";
    }

    @GetMapping(value = {"calList"}, produces = {"application/json;"})
    @ResponseBody
    public List<Map<String, Object>> selectCal(@RequestParam Map<String, Object> cal){

        log.info("[CalendarController] selectCalendar ========================================");

        List<CalendarDTO> calList = calendarService.selectCalendar();

        log.info("[CalendarController] calList : " + calList);

        JSONArray jsonArray = new JSONArray();

        Map<String, Object> calMap = new HashMap<>();
        for(int i = 0; i < calList.size(); i++){
            calMap.put("calName", calList.get(i).getCalName());
            calMap.put("startDay", calList.get(i).getStartDay());
            calMap.put("endDay", calList.get(i).getEndDay());

            JSONObject jsonObject = new JSONObject(calMap);
            jsonArray.add(jsonObject);
        }
        log.info("[CalendarController] list : " + jsonArray);

        return jsonArray;
    }



//    @PostMapping("/calendar")
//    public String calendar(){
//
//        return null;
//    }
}
