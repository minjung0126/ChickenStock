package com.chicken.project.account.controller;

import com.chicken.project.account.model.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/*")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){

        this.accountService = accountService;
    }

    @GetMapping("/admin/list")
    public String accountAdminList(){

        return "/account/admin/adminAccountList";
    }

    @GetMapping("/user/list")
    public String accountUserList(){

        return "/account/user/userAccountList";
    }
}
