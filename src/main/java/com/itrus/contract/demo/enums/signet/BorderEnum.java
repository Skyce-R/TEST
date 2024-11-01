package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum BorderEnum {

    /**
     * 边框
     */
    HAVE(1, "有边框（默认）"),
    NOT_HAVE(2, "没有边框"),
    ;

    private final int index;
    private final String description;

}
