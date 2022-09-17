package com.chicken.project.mypage.controller;

import com.chicken.project.mypage.service.MypageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/*")
public class MypageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MypageServiceImpl mypageService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MypageController(MypageServiceImpl mypageService, PasswordEncoder passwordEncoder) {
        this.mypageService = mypageService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/member_mypage")
    public void empMypage(){

    }

    @PostMapping("/member_mypage")
    public String updateEmpPwd(){

        return null;
    }


    @GetMapping("/store_mypage")
    public void storeMypage(){

    }

    @PostMapping("/store_mypage")
    public String updateStorePwd(){

        return null;
    }
}
