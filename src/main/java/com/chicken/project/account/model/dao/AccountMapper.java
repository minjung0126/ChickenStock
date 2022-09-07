package com.chicken.project.account.model.dao;

import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    List<AccountApplyDTO> selectAccountApplyList();

    List<AccountDTO> selectAccountList();
}
