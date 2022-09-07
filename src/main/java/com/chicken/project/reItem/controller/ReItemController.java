package com.chicken.project.reItem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reItem/*")
public class ReItemController {

    @GetMapping("/user/insertReItem")
    public void reItem(){

    }

    @GetMapping("/user/storeReList")
    public void SreItem(){

//        <a href="/reItem/user/reviseReItem">가맹점 반품신청 수정</a>

    }
    @GetMapping("/user/reviseReItem")
    public void RreItem(){

    }

}
