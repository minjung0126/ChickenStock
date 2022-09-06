package com.chicken.project.member.controller;

import com.chicken.project.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/member/*")
public class EmployeeController {


    private final MemberService memberService;

    @Autowired
    public EmployeeController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/employee/login")
    public void login(){}

    @GetMapping("/main/admin_main")
    public void empMain(){}
}
