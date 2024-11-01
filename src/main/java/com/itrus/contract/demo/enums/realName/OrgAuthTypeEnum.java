package com.itrus.contract.demo.enums.realName;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/9/20/0020
 */
@Getter
@AllArgsConstructor
public enum OrgAuthTypeEnum {

    /**
     * 实名类型
     */
    AUTH_TYPE_LEGAL_PHONE(1, "法人手机号"),
    AUTH_TYPE_ORG_PAYMENT(2,"企业打款"),
    ;

    private final int index;
    private final String description;

}
