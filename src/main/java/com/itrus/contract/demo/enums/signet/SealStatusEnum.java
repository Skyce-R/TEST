package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum SealStatusEnum {

    /**
     * 印章状态
     */
    ENABLE(2, "启用"),
    DEACTIVATE(3, "停用"),
    ;

    private final int index;
    private final String description;

}
