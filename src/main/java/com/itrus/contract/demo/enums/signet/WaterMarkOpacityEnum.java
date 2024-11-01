package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2022/5/9/0009
 */
@Getter
@AllArgsConstructor
public enum WaterMarkOpacityEnum {

    /**
     * 是否透明
     */
    TRUE(0f, "透明"),
    FALSE(1f, "不透明"),
    ;

    private final Float code;
    private final String name;

}
