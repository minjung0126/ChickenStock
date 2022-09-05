package com.chicken.project.member.controller;

import com.chicken.project.empList.model.dto.EmployeeDTO;
import com.chicken.project.member.model.service.MemberService;
import com.chicken.project.store.model.dto.StoreDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberService memberService;

    public MemberController( MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String login(){

        return "member/login";
    }
}
