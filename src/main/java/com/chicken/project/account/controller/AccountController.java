package com.chicken.project.account.controller;

import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.account.model.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account/*")
public class AccountController {

    private final AccountService accountService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @GetMapping("/admin/list")
    public ModelAndView accountAdminList(ModelAndView mv) {

        List<AccountApplyDTO> accountApplyList = accountService.selectAccountApplyList();

        mv.addObject("accountApplyList", accountApplyList);
        mv.setViewName("/account/admin/adminAccountList");

        return mv;
    }

    @GetMapping("/user/list")
    public ModelAndView accountUserList(ModelAndView mv) {

        List<AccountDTO> accountList = accountService.selectAccountList();

        log.info("[AccountController] : accountList : " + accountList );

        mv.addObject("accountList", accountList);
        mv.setViewName("/account/user/userAccountList");

        return mv;
    }
}
