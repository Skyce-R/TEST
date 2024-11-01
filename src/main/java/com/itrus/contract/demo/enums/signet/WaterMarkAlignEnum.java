package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2022/5/9/0009
 */
@Getter
@AllArgsConstructor
public enum  WaterMarkAlignEnum {

    /**
     * 左上
     */
    LEFT_TOP(1, "LEFT_TOP"),
    /**
     * 右上
     */
    RIGHT_TOP(2, "RIGHT_TOP"),
    /**
     * 左下
     */
    LEFT_BOTTOM(3, "LEFT_BOTTOM"),
    /**
     * 右下
     */
    RIGHT_BOTTOM(4, "RIGHT_BOTTOM"),
    /**
     * 居中
     */
    CENTER(5, "CENTER"),
    /**
     * 平铺
     */
    TILED(6, "TILED"),
    /**
     * 填充
     */
    STRET(7, "STRET")
    ;

    private final Integer code;
    private final String name;

}
