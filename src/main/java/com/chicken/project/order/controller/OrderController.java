package com.chicken.project.order.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.service.OrderService;
import com.chicken.project.common.paging.SelectCriteria;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import java.util.ArrayList;
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

    @GetMapping("list/interest/insert")
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

    @GetMapping("list/interest/select")
    public ModelAndView interestList(ModelAndView mv, HttpServletRequest request) {

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

        int totalCount = orderService.selectInterestItemCount(searchMap);

        int limit = 10;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<OrderDTO> orderList = orderService.selectInterestItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }


    @GetMapping("list/available")
    public ModelAndView availableList(ModelAndView mv, HttpServletRequest request) {

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

        int totalCount = orderService.selectAvailableItemCount(searchMap);

        int limit = 10;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<OrderDTO> orderList = orderService.selectAvailableItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }

    @GetMapping(value = "list/insert")
    public ModelAndView insertCart (HttpServletRequest request, ModelAndView mv) {

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

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");

        return mv;
    }

    @PostMapping(value="list/insert")
    public ModelAndView insertCartList(HttpServletRequest request, ModelAndView mv,
                                       @RequestParam("itemNoList") String itemNoList)
            throws ParseException, InterestException {

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

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        System.out.println("itemNo = " + itemNoList);

        JSONParser jsonParse = new JSONParser();

        JSONArray jsonObj = (JSONArray) jsonParse.parse(itemNoList);

        System.out.println("jsonObj = " + jsonObj);

        CartDTO cart = new CartDTO();

        for(int i = 0; i < jsonObj.size(); i++){

            System.out.println("jsonObj.get(i).get(\"itemNo\") = " + ((JSONObject)jsonObj.get(i)).get("itemNo"));
            System.out.println("jsonObj.get(i).get(\"cartAmount\") = " + ((JSONObject)jsonObj.get(i)).get("cartAmount"));

            int itemNo = Integer.parseInt(((JSONObject)jsonObj.get(i)).get("itemNo").toString());
            int cartAmount = Integer.parseInt(((JSONObject)jsonObj.get(i)).get("cartAmount").toString());

            cart.setItemNo(itemNo);
            cart.setCartAmount(cartAmount);

            orderService.insertItemIntoCart(itemNo, cartAmount);
        }

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("cart", cart);
        mv.setViewName("order/orderList");
        //redirect:/

        return mv;
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