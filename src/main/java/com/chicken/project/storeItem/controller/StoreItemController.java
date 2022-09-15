package com.chicken.project.storeItem.controller;

import com.chicken.project.storeItem.model.dto.StoreItemListDTO;
import com.chicken.project.storeItem.model.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/storeItem")
public class StoreItemController {

    private final StoreItemService storeItemService;

    @Autowired
    public StoreItemController(StoreItemService storeItemService) {
        this.storeItemService = storeItemService;
    }

    @GetMapping("/itemListSelect")
    public ModelAndView itemListSelect(ModelAndView mv){

        List<StoreItemListDTO> itemList = storeItemService.itemListSelect();

        mv.addObject("itemList", itemList);
        mv.setViewName("storeItem/storeItem_list");
        return mv;
    }
}
