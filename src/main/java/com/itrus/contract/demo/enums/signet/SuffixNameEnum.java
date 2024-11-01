package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum SuffixNameEnum {

    /**
     * 印章后缀名
     */
    ONE("印"),
    TWO("之印"),
    ;

    private final String description;

}
