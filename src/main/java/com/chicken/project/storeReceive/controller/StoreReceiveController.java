package com.chicken.project.storeReceive.controller;

import com.chicken.project.storeReceive.model.service.StoreReceiveServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/storeReceive")
public class StoreReceiveController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final StoreReceiveServiceImpl storeReceiveService;

    @Autowired
    public StoreReceiveController(StoreReceiveServiceImpl storeReceiveService){

        this.storeReceiveService = storeReceiveService;
    }

    @GetMapping("/user/list")
    public ModelAndView storeReceiveList(HttpServletRequest request, ModelAndView mv){

        mv.setViewName("receive/user/user_receive");

        return mv;
    }
}
