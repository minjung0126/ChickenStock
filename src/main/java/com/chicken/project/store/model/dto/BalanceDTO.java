package com.chicken.project.store.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BalanceDTO {

    private String storeName; // 가맹점 명
    private int balance; // 잔액
}
