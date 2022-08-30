package com.chicken.project.billtax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("billtax")
public class BilltaxController {

    @GetMapping("/billList")
    public void billList(){

    }
}
