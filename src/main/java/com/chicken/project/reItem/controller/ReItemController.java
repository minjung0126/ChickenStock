package com.chicken.project.reItem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reItem/*")
public class ReItemController {

    // 가맹점 반품서작성
    @GetMapping("/user/insertReItem")
    public void reItem(){

    }

    // 가맹점 반품서 리스트
    @GetMapping("/user/storeReList")
    public void SreItem(){

//        <a href="/reItem/user/reviseReItem">가맹점 반품신청 수정</a>

    }

    // 가맹점 반품서 수정
    @GetMapping("/user/reviseReItem")
    public void RreItem(){

    }

    @GetMapping("/admin/adminReList")
    public void ReList(){

    }

    @GetMapping("/admin/adminReItem")
    public void ReItem(){

    }



}
