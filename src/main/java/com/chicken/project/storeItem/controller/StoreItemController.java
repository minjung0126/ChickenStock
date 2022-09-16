package com.chicken.project.storeItem.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.storeItem.model.dto.StoreItemListDTO;
import com.chicken.project.storeItem.model.service.StoreItemService;
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
@RequestMapping("/storeItem")
public class StoreItemController {

    private final StoreItemService storeItemService;

    @Autowired
    public StoreItemController(StoreItemService storeItemService) {
        this.storeItemService = storeItemService;
    }

    @GetMapping("/itemListSelect")
    public ModelAndView itemListSelect(ModelAndView mv, HttpServletRequest request){

        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)){

            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = storeItemService.selectTotalCount(searchMap);

        int limit;
        if(searchCondition != null && !"".equals(searchCondition)) {
            limit = totalCount;
        } else{
            limit = 10;
        }

        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;
        if(searchCondition != null && !"".equals(searchCondition)){

            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {

            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<StoreItemListDTO> itemList = storeItemService.itemListSelect(selectCriteria);

        System.out.println(itemList);

        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("itemList", itemList);
        mv.setViewName("/storeItem/storeItem_list");
        return mv;
    }
}