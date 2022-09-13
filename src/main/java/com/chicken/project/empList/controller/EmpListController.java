package com.chicken.project.empList.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.empList.model.service.EmpListServiceImpl;
import com.chicken.project.member.model.dto.EmpRoleDTO;
import com.chicken.project.member.model.dto.EmployeeDTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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
    public ModelAndView empList(ModelAndView mv, HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)){

            pageNo = Integer.parseInt(currentPage);
        }

        int limit = 10;
        int button = 5;

        log.info("[EmpListController] ========================================");

        int totalEmp = empListService.selectTotalEmpList();

        SelectCriteria criteria = Pagenation.getSelectCriteria(pageNo, totalEmp, limit, button);

        List<EmployeeDTO> empList = empListService.selectAllEmployee(criteria);
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

        emp.setEmpPhone(emp.getEmpPhone().replace("-", ""));
        emp.setEmpPwd(passwordEncoder.encode(emp.getEmpPwd()));

        log.info("[EmpListController] registEmp : " + emp);

        int result = empListService.registEmp(emp);

        if(result > 0){

            rttr.addFlashAttribute("message", "success");
        } else {

            rttr.addFlashAttribute("message","fail");
        }

        log.info("[EmpListController] ========================================");

        return "redirect:/empList/empList";
    }

    @PostMapping("/auth")
    @ResponseBody
    public String insertAuth(@RequestParam String empId){

        log.info("[EmpListController] insertAuth ========================================");

        log.info("[EmpListController] empId : " + empId);

        int ckAdmin = empListService.selectCkAdminAuth(empId);

        log.info("[EmpListController] ckAdmin : " + ckAdmin);

        String data = "";

        if (ckAdmin == 2){

            data = "admin";
        }
        if(ckAdmin == 1){

            int result = empListService.insertAuth(empId);

            if(result > 0){

                data = "emp";
            }
        }

        return data;
    }

}
