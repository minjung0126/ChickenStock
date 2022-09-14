package com.chicken.project.account.model.dao;

import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.store.model.dto.BalanceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    List<AccountApplyDTO> selectAccountApplyList();

    List<AccountDTO> selectAccountList();

    BalanceDTO selectBalance(String storeName);

    int accountInsert(int accountDeposit, String storeName);

    int accountApplyInsert(String storeName);

    List<AccountDTO> selectAccountListByStoreName(String storeName);

    int balanceUpdate(AccountApplyDTO accountApply, int accountDeposit, String storeName);

    int accountApplyUpdate2(int depositNum);

    int accountUpdate2(int depositNum);

    int accountApplyUpdate(AccountApplyDTO accountApply);

    int accountUpdate(AccountApplyDTO accountApply);
}
