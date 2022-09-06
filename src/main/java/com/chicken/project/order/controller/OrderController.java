package com.chicken.project.order.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.service.OrderService;
import com.chicken.project.common.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        if (currentPage != null && !"".equals(currentPage)) {
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

        if (searchCondition != null && !"".equals(searchCondition)) {
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
    public String interestControl(HttpServletRequest request, RedirectAttributes rttr) throws InterestException {

        InterestDTO interest = new InterestDTO();
        OrderDTO order = new OrderDTO();

        //itemNo, categoryNo 값 가져오기 + DTO에 저장
        int itemNo = Integer.parseInt(request.getParameter("itemNo"));
        interest.setItemNo(itemNo);
        System.out.println(itemNo);

        int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
        interest.setCategoryNo(categoryNo);
        System.out.println(categoryNo);


        //기존 관심 설정 여부 판단
        int interCheck = orderService.selectInterestCount(interest);


        //관심 설정이 되어 있으면 삭제를, 되어 있지 않으면 추가를 한다.
        if (interCheck == 0) {
            orderService.insertInterest(interest);

        } else if (interCheck == 1) {

            orderService.deleteInterest(interest);
        }

        rttr.addFlashAttribute("message", "관심 상품 등록 성공!");

        return "redirect:/order/list";
    }

    @GetMapping("cart")
    public String cartInsertPage() {

        return "/order/orderList";
    }

    @PostMapping("cart/insert")
    public void cartInsert(@ModelAttribute CartDTO cart, RedirectAttributes rttr, HttpServletRequest request) {

        // CART_AMOUNT, CATEROGRY_NO, ITEM_NO, STORE_NAME 값 가져오기
        int cartAmount = Integer.parseInt(request.getParameter("cartAmount"));
        int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
        int itemNo = Integer.parseInt(request.getParameter("itemNo"));

        // DTO 에 주입
        cart.setCartAmount(cartAmount);
        cart.setCategoryNo(categoryNo);
        cart.setItemNo(itemNo);

        System.out.println(cart);

        int result = orderService.insertItemIntoCart(cart);


    }

    @GetMapping(value = "cart/list")
    public ModelAndView cartList(ModelAndView mv, HttpServletRequest request) {

            String currentPage = request.getParameter("currentPage");

            int pageNo = 1;

            if (currentPage != null && !"".equals(currentPage)) {
                pageNo = Integer.parseInt(currentPage);
            }

            String searchCondition = request.getParameter("searchCondition");
            String searchValue = request.getParameter("searchValue");

            Map<String, String> searchMap = new HashMap<>();
            searchMap.put("searchCondition", searchCondition);
            searchMap.put("searchValue", searchValue);

            int totalCount = orderService.selectCartTotalCount(searchMap);

            int limit = 10;
            int buttonAmount = 5;

            SelectCriteria selectCriteria = null;

            if (searchCondition != null && !"".equals(searchCondition)) {
                selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
            } else {
                selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
            }

            List<CartDTO> cartList = orderService.selectCartItem(selectCriteria);

            mv.addObject("cartList", cartList);
            mv.addObject("selectCriteria", selectCriteria);
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