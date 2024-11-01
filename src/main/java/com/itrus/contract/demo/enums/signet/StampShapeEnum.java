package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum StampShapeEnum {

    /**
     * 签名形状  4:单行章, 5:双行章
     */
    SINGLE(4, "单行章(默认)"),
    DOUBLE(5, "双行章"),
    ;

    private final int index;
    private final String description;

}
