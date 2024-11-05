package com.itrus.contract.demo.enums.account;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum UserEnterpriseLabelEnum {

    /**
     * 用户类型
     */
    PERSON(1, "个人用户","001"),
    ENTERPRISE(2, "企业用户","002"),
    ;

    private final int index;
    private final String description;
    private final String code;

}