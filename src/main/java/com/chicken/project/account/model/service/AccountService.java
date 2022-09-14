package com.chicken.project.account.model.service;

import com.chicken.project.account.model.dao.AccountMapper;
import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.store.model.dto.BalanceDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public BalanceDTO selectBalance(String storeName) {

        return accountMapper.selectBalance(storeName);
    }

    @Transactional
    public int accountInsert(int accountDeposit, String storeName) {

        int result = accountMapper.accountInsert(accountDeposit, storeName);

        if(result > 0) {

            accountMapper.accountApplyInsert(storeName);
        }

        return result;
    }

    public List<AccountDTO> selectAccountListByStoreName(String storeName) {

        return accountMapper.selectAccountListByStoreName(storeName);
    }

    @Transactional
    public int accountApplyUpdate2(int depositNum) {

        int result = accountMapper.accountApplyUpdate2(depositNum);

        if(result > 0){

            int result2 = accountMapper.accountUpdate2(depositNum);
        }

        return result;
    }

    @Transactional
    public int balanceUpdate(AccountApplyDTO accountApply, int accountDeposit, String storeName) {

        int result = accountMapper.balanceUpdate(accountApply, accountDeposit, storeName);

        if(result > 0){

            int result2 = accountMapper.accountApplyUpdate(accountApply);

            if(result2 > 0){

                int result3 = accountMapper.accountUpdate(accountApply);
            }
        }

        return result;
    }

    public List<BalanceDTO> balanceSelect() {

        return accountMapper.balanceSelect();
    }
}
