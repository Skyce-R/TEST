package com.itrus.contract.demo.enums.account;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum AccountTypeEnum {

    /**
     * 账号类型
     */
    PHONE(1, "手机号"),
    ACCOUNT(2, "账号"),
    ;

    private final int index;
    private final String description;

}
