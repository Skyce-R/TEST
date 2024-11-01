package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum SealShapeEnum {

    /**
     * 印章形状
     */
    CIRCULAR(1, "圆章(默认)"),
    OVAL(2, "椭圆章"),
    TRIANGLE(3, "三角章"),
    ;

    private final int index;
    private final String description;

}
