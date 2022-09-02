package com.chicken.project.reItem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reItem/*")
public class ReItemController {

    @GetMapping("/returnRItemList")
    public void ReturnReList(){

    }
}
