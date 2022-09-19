package com.chicken.project.order.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.member.model.dto.StoreImpl;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.dto.OrderHistoryDTO;
import com.chicken.project.order.model.service.OrderServiceImpl;
import com.chicken.project.common.paging.SelectCriteria;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("order")
public class OrderController {
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    //상품 목록 전체 조회
    @GetMapping(value = "/list")
    public ModelAndView inquire(ModelAndView mv,
                                HttpServletRequest request,
                                @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
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
        searchMap.put("storeName", storeName);


        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }

    //관심 설정 저장
    @ResponseBody
    @PostMapping ("/list/interest/insert")
    public String interestControl(HttpServletRequest request,
                                        RedirectAttributes rttr,
                                        @AuthenticationPrincipal User user,
                                        ModelAndView mv
                                  ) throws InterestException {

        String storeName = ((StoreImpl) user).getStoreName();

        InterestDTO interest = new InterestDTO();
        OrderDTO order = new OrderDTO();

        //itemNo 값 가져오기 + DTO에 저장
        int itemNo = Integer.parseInt(request.getParameter("itemNo"));
        interest.setItemNo(itemNo);

        interest.setStoreName(storeName);

        //기존 관심 설정 여부 판단
        int interCheck = orderService.selectInterestCount(interest);
        String interYn = "";

        //관심 설정이 되어 있으면 삭제를, 되어 있지 않으면 추가를 한다.
        if (interCheck == 0) {
            orderService.insertInterest(interest);
            interYn = "Y";

        } else if (interCheck == 1) {
            orderService.deleteInterest(interest);
            interYn = "N";
        }

        rttr.addFlashAttribute("message", "관심 상품 등록 성공!");

        mv.addObject("interYn", interYn);
        return "redirect:/order/list";
    }

    // 관심 설정 상품만 조회
    @GetMapping("/list/interest/select")
    public ModelAndView interestList(ModelAndView mv,
                                     HttpServletRequest request,
                                     @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
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
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectInterestItemCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectInterestItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }

    //품절 상품 제외하고 보기
    @GetMapping("/list/available")
    public ModelAndView availableList(ModelAndView mv,
                                      HttpServletRequest request,
                                      @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
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
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectAvailableItemCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectAvailableItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }

    //카트에 넣기 (GET)
    @GetMapping(value = "/list/insert")
    public ModelAndView insertCart (HttpServletRequest request,
                                    ModelAndView mv,
                                    @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
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
        searchMap.put("storeName", storeName);

        //int totalCount = orderService.selectCartTotalCount(searchMap);
        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");

        return mv;
    }

    //카트에 넣기 (POST)
    @PostMapping(value="/list/insert")
    public ModelAndView insertCartList(HttpServletRequest request,
                                       ModelAndView mv,
                                       @RequestParam("itemNoList") String itemNoList,
                                       @AuthenticationPrincipal User user) throws InterestException, ParseException {

        String storeName = ((StoreImpl) user).getStoreName();
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
        searchMap.put("storeName", storeName);

        //int totalCount = orderService.selectCartTotalCount(searchMap);
        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
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
            cart.setStoreName(storeName);

            orderService.insertItemIntoCart(itemNo, cartAmount, storeName);
        }

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("cart", cart);
        mv.setViewName("order/orderList");

        return mv;
    }

    //장바구니 목록 조회
    @GetMapping(value = "/cart/list")
    public ModelAndView cartList(ModelAndView mv,
                                 HttpServletRequest request,
                                 @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        System.out.println(storeName);

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectCartTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<CartDTO> cartList = orderService.selectCartItem(selectCriteria);
//        CartDTO store = new CartDTO();
//        int balanceNo = orderService.selectBalance(store);
//        store.setBalance(balanceNo);
//        int balance = store.getBalance();
//
//        mv.addObject("balance", balance);
        mv.addObject("cartList", cartList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/cart");
        return mv;
    }

    /* 장바구니 아이템 삭제 (DELETE) */
    @PostMapping(value ="/cart/delete")
    public String deleteCartItem(HttpServletRequest request, @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();

        CartDTO cart = new CartDTO();
        cart.setStoreName(storeName);

        int itemNo = Integer.parseInt(request.getParameter("itemNo"));
        cart.setItemNo(itemNo);

        orderService.deleteCartItem(cart);

        return "redirect:/order/cart/list";
    }


    /* 발주하기--GET (INSERT) */
    @GetMapping(value = "/insert/items/page")
    public ModelAndView insertItemsPage (HttpServletRequest request,
                                    ModelAndView mv,
                                    @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
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
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectCartTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<CartDTO> cartList = orderService.selectCartItem(selectCriteria);

        mv.addObject("cartList", cartList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/cart");

        return mv;
    }


    /* 발주하기--POST (INSERT) */
    /* 민수님 여기예요 */
    @PostMapping(value="/insert/items/do")
    public ModelAndView insertItemsDo(HttpServletRequest request,
                                      ModelAndView mv,
                                      @RequestParam("cartNoList") String cartNoList,
                                      @AuthenticationPrincipal User user) throws InterestException, ParseException {

        String storeName = ((StoreImpl) user).getStoreName();

        CartDTO cart = new CartDTO();

        cart.setStoreName(storeName);

        int orderNoResult = orderService.insertStoreOrderNo(cart);

        JSONParser jsonParse = new JSONParser();
        JSONArray jsonArr = (JSONArray) jsonParse.parse(cartNoList);

        for(int i = 0; i < jsonArr.size(); i++) {

            int itemNo = Integer.parseInt(((JSONObject) jsonArr.get(i)).get("itemNo").toString());
            int cartAmount = Integer.parseInt(((JSONObject) jsonArr.get(i)).get("cartAmount").toString());
            int categoryNo = Integer.parseInt(((JSONObject) jsonArr.get(i)).get("categoryNo").toString());
            String price = ((JSONObject) jsonArr.get(i)).get("totalPrice").toString();
            int totalPrice = Integer.parseInt(price.replace(",",""));

            cart.setItemNo(itemNo);
            cart.setCartAmount(cartAmount);
            cart.setCategoryNo(categoryNo);
            cart.setTotalPrice(totalPrice);

            orderService.resetCartItems(cart);

            int cartNoResult = orderService.insertOrderItems(cart);

            cart.setOrderNo(orderNoResult);
            cart.setCartNo(cartNoResult);

        }

        int result = orderService.insertOrderHandler(cart);

        //mv.setViewName("redirect:/order/cart/list");
        mv.setViewName("order/orderSuccess");

        return mv;
    }


    /* 발주 내역 조회 */
    @GetMapping(value = "/history")
    public ModelAndView history(ModelAndView mv,
                                HttpServletRequest request,
                                @AuthenticationPrincipal User user,
                                @RequestParam(value="orderDate", required = false) String orderDate) {

        String storeName = ((StoreImpl) user).getStoreName();
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
        searchMap.put("storeName", storeName);

        if(orderDate != null){
            searchMap.put("orderDate", orderDate);
        }

        int totalCount = orderService.selectOrderHistoryCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName, orderDate);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderHistoryDTO> historyList = orderService.selectOrderHistory(selectCriteria);

        mv.addObject("historyList", historyList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderHistory");
        return mv;

    }




}