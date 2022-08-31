package com.chicken.project.order.controller;

import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("list")
    public ModelAndView inquire(ModelAndView mv) {
        List<OrderDTO> orderList = orderService.findAllItem();

        mv.addObject("orderList", orderList);
        mv.setViewName("order/orderList");
        return mv;
    }

    @GetMapping("cart")
    public void cart() {

    }

    @GetMapping("history")
    public void history() {

    }
}
