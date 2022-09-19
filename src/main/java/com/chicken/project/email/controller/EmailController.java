package com.chicken.project.email.controller;

import com.chicken.project.email.model.service.EmailService;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/member/*")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/ckEmail")
    public String ckEmail(){

        return "/member/ckEmail";
    };

    @PostMapping("/ckEmail")
    public String emailConfirm(EmployeeDTO emp, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {

        emp.setEmpId(request.getParameter("ckEmpId"));
        emp.setEmpEmail(request.getParameter("ckEmail"));

        int empResult = emailService.updateEmailCode(emp);

        emp.setEmailCode(request.getParameter("code"));

        String emailCode = emailService.selectEmailCode();

        String url = "";

        if(empResult > 0 && emailCode.equals(emp.getEmailCode())){

            url = "/member/updatePwd";
        }
        return url;
    }

    @GetMapping("/updatePwd")
    public String updatePwd(){

        return  "/member/updatePwd";
    }
}
