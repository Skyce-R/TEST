package com.itrus.contract.demo.enums.enterprise;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum AdminModifyTypeEnum {

    /**
     * 操作类型
     */
    CHANGE(1, "变更"),
    ADD(2, "添加"),
    ;

    private final int index;
    private final String description;

}
