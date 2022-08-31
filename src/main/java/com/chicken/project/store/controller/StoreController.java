package com.chicken.project.store.controller;

import com.chicken.project.store.model.dto.StoreDTO;
import com.chicken.project.store.model.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/store/*")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){

        this.storeService = storeService;
    }

    @GetMapping("/list")
    public ModelAndView StoreListPage(ModelAndView mv){

        List<StoreDTO> storeList = storeService.storeList();

        mv.addObject("storeList", storeList);
        mv.setViewName("store/store_list");

        return mv;
    }
}
