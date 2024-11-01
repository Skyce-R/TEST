package com.itrus.contract.demo.enums.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/11/0011
 */
@Getter
@AllArgsConstructor
public enum VerifySourceEnum {

    /**
     * 验证来源
     */
    TRIPARTITE(1, "三方验证"),
    ITRUS(2, "天威验证"),
    ;

    private final Integer index;
    private final String description;

}
