package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum ViewRangeTypeEnum {

    /**
     * 签名字体
     */
    COMMONCDOC(1,"公共文档"),
    AUTHORIZEDDOC(2,"有访问权限的文档")
    ;

    private final int index;
    private final String description;

}
