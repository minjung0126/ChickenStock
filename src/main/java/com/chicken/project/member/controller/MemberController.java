package com.chicken.project.member.controller;

import com.chicken.project.member.model.dto.EmployeeDTO;
import com.chicken.project.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;


@Controller
@RequestMapping("/member/*")
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/login")
    public void login(){}

    @GetMapping("/main/admin_main")
    public void empMain(){}

    @GetMapping("/ckEmail")
    public String ckEmail(){

        return "/member/ckEmail";
    };

    @PostMapping("/ckEmail")
    public String emailConfirm(EmployeeDTO emp, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {

        emp.setEmpId(request.getParameter("empId"));
        emp.setEmpEmail(request.getParameter("email"));

        int empResult = memberService.updateEmailCode(emp);

        String url = "";

        if(empResult > 0){

            url = "/member/updatePwd";
        }
        return url;
    }

    @GetMapping("/updatePwd")
    public String updatePwd(){

        return  "/member/updatePwd";
    }

}
