package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum OperationTypeEnum {

    /**
     * 操作类型
     */
    STATUS(0, "设置状态"),
    DEFAULT(1, "设置默认"),
    ;

    private final int index;
    private final String description;

}
