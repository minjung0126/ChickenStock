package com.chicken.project.order.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.order.model.dto.InterestDTO;
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

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 10;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }
    @GetMapping("list/interest")
    public ModelAndView interest(ModelAndView mv, HttpServletRequest request){

        InterestDTO interest = new InterestDTO();

        //itemNo 값 가져오기 + DTO에 저장
        int itemNo =  Integer.parseInt(request.getParameter("itemNo"));
        interest.setItemNo(itemNo);

//        //기존 관심 설정 여부 판단
//        int interCheck = orderService.selectInterestCount(interest);
//        int interResult;
//
//        //관심 설정이 되어 있으면 삭제를, 되어 있지 않으면 추가를 한다.
//        if(interCheck==0) {
//
//            interResult = orderService.insertInterest(interest);
//        } else if(interCheck==1) {
//
//            interResult = orderService.deleteInterest(interest);
//        }
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
