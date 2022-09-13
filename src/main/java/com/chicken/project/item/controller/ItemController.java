package com.chicken.project.item.controller;

//import com.chicken.project.item.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/item")
public class ItemController {

//    private final ItemService itemService;
//
//    @Autowired
//    public ItemController(ItemService itemService){
//
//        this.itemService = itemService;
//    }

    @GetMapping("/admin/list")
    public ModelAndView itemList(HttpServletRequest request, ModelAndView mv){

        mv.setViewName("item/admin/admin_item");

        return mv;
    }
    @GetMapping("/admin_item_new")
    public void itemInsert(){}
}
