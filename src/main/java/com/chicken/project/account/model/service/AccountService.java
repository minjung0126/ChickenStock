package com.chicken.project.account.model.service;

import com.chicken.project.account.model.dao.AccountMapper;
import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountService {

    private final AccountMapper accountMapper;

    public AccountService(AccountMapper accountMapper){

        this.accountMapper = accountMapper;
    }
    public List<AccountApplyDTO> selectAccountApplyList() {

        return accountMapper.selectAccountApplyList();
    }

    public List<AccountDTO> selectAccountList() {

        return accountMapper.selectAccountList();
    }
}
