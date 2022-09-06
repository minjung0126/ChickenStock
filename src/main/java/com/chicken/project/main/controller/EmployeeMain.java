package com.chicken.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/*")
public class EmployeeMain {

    @PostMapping("main/admin_main")
    public void defaultLocation(){

    }
}
