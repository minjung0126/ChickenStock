package com.chicken.project.account.model.service;

import com.chicken.project.account.model.dao.AccountMapper;
import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.account.model.dto.StoreBreakdownDTO;
import com.chicken.project.account.model.dto.StoreDepositDTO;
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
    /* 본사 가맹점 입금신청 조회 */
    public List<AccountApplyDTO> selectAccountApplyList() {

        return accountMapper.selectAccountApplyList();
    }

    /* 가맹점 잔액 조회 */
    public BalanceDTO selectBalance(String storeName) {

        return accountMapper.selectBalance(storeName);
    }

    /* 가맹점 입금신청 */
    @Transactional
    public int accountInsert(int accountDeposit, String storeName) {

        int result = accountMapper.accountInsert(accountDeposit, storeName);

        if(result > 0) {

            int result2 = accountMapper.accountApplyInsert(storeName);
        }

        return result;
    }

    /* 가맹점명으로 입금신청 조회 */
    public List<AccountDTO> selectAccountListByStoreName(String storeName) {

        return accountMapper.selectAccountListByStoreName(storeName);
    }

    /* 가맹점 입금 반려 */
    @Transactional
    public int accountApplyUpdate2(int depositNum) {

        int result = accountMapper.accountApplyUpdate2(depositNum);

        if(result > 0){

            int result2 = accountMapper.accountUpdate2(depositNum);
        }

        return result;
    }

    /* 가맹점 잔액 수정 */
    @Transactional
    public int balanceUpdate(AccountApplyDTO accountApply, int accountDeposit, String storeName) {

        int result = accountMapper.balanceUpdate(accountApply, accountDeposit, storeName);

        if(result > 0){

            int result2 = accountMapper.accountApplyUpdate(accountApply);

            if(result2 > 0){

                int result3 = accountMapper.accountUpdate(accountApply);

                if(result3 > 0 ){

                    int result4 = accountMapper.depositInsert(accountDeposit, storeName);
                }
            }
        }

        return result;
    }

    /* 본사 가맹점 잔액 조회 */
    public List<BalanceDTO> balanceSelect() {

        return accountMapper.balanceSelect();
    }

    /* 가맹점 입금액 조회 */
    public List<StoreDepositDTO> selectStoreDeposit(String storeName) {

        return accountMapper.selectStoreDeposit(storeName);
    }

    /* 가맹점 출금액 조회 */
    public List<StoreBreakdownDTO> selectStoreBreakdown(String storeName) {

        return accountMapper.selectStoreBreakdown(storeName);
    }
}
