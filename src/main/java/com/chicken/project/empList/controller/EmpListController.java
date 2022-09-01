package com.chicken.project.empList.controller;

import com.chicken.project.empList.model.service.EmpListService;
import com.chicken.project.empList.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/empList")
public class EmpListController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final EmpListService empListService;

    @Autowired
    public EmpListController(EmpListService empListService) {
        this.empListService = empListService;
    }

    @GetMapping("/empList")
    public ModelAndView empList(ModelAndView mv){
        log.info("");
        log.info("");
        log.info("[EmpListController] ========================================");

        List<EmployeeDTO> empList = empListService.selectAllEmployee();
        log.info("[EmpListController] empList : " + empList);

        mv.addObject("empList", empList);

        mv.setViewName("empList/empList");

        log.info("[EmpListController] ========================================");


        return mv;
    }
}
