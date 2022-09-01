package com.chicken.project.order.controller;

import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.service.OrderService;
import com.chicken.project.common.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "list")
    public ModelAndView inquire(ModelAndView mv, HttpServletRequest request) {

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        Map<String, String> searchMap = new HashMap<>();
        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 10;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        List<OrderDTO> orderList = orderService.selectAllItem();

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;
    }

    @GetMapping("cart")
    public ModelAndView cartList(ModelAndView mv) {
        List<OrderDTO> cartList = orderService.selectCartItem();

        mv.addObject("cartList", cartList);
        mv.setViewName("order/cart");

        return mv;
    }

    @GetMapping("history")
    public ModelAndView orderHistory(ModelAndView mv) {
        List<OrderDTO> orderHistory = orderService.selectOrderHistory();

        mv.addObject("orderHistory", orderHistory);
        mv.setViewName("order/orderHistory");

        return mv;
    }
}
