package com.itrus.contract.demo.enums.account;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    /**
     * 用户类型
     */
    PERSON(1, "个人用户"),
    ENTERPRISE(2, "企业用户"),
    ;

    private final int index;
    private final String description;

}
