package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum OperationModeEnum {

    /**
     * 操作类型
     */
    CREATE(0, "创建（默认）"),
    PREVIEW(1, "预览"),
    ;

    private final int index;
    private final String description;

}
