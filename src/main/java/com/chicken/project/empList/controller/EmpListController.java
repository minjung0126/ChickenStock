package com.chicken.project.empList.controller;

import com.chicken.project.empList.model.service.EmpListServiceImpl;
import com.chicken.project.member.model.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/empList/*")
public class EmpListController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final EmpListServiceImpl empListService;

    private PasswordEncoder passwordEncoder;


    @Autowired
    public EmpListController(EmpListServiceImpl empListService, PasswordEncoder passwordEncoder) {
        this.empListService = empListService;
        this.passwordEncoder = passwordEncoder;

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

    @PostMapping("/empList")
    public String registEmp(@ModelAttribute EmployeeDTO emp, HttpServletRequest request, RedirectAttributes rttr){

        log.info("");
        log.info("");
        log.info("[EmpListController] ========================================");

        emp.setEmpPhone(emp.getEmpPhone().replace("-",""));
        emp.setEmpPwd(passwordEncoder.encode(emp.getEmpPwd()));

        log.info("[EmpListController] registEmp : " + emp);

        int result = empListService.registEmp(emp);

        if(result > 0){

            rttr.addFlashAttribute("message", "success");
        } else {

            rttr.addFlashAttribute("message","fail");
        }

        log.info("[EmpListController] ========================================");

        return "redirect:/";
    }

}
