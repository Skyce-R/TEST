package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum TypeOfSealEnum {

    /**
     * 印章所属类型
     */
    PERSON(0, "个人"),
    ORG(1, "企业"),
    ;

    private final int index;
    private final String description;

}
