package com.chicken.project.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("order")
public class OrderController {

    @GetMapping("orderItem")
    public void orderItem () {

    }

    @GetMapping("cart")
    public void cart() {

    }
}
