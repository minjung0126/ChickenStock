package com.chicken.project.account.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class AccountApplyDTO {

    private String storeName; // 가맹점명
    private int depositNum; // 입금신청번호
    private Date depositRegistDate; // 입금신청일
    private AccountDTO accountDeposit; // 입금액
    private String depositYn; // 입금상태여부
}
