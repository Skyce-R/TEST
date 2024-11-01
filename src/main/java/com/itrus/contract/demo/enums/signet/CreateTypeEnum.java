package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
@Getter
@AllArgsConstructor
public enum CreateTypeEnum {

    /**
     * 创建类型
     */
    CUSTOM(1, "自定义"),
    IMAGE(2, "图片"),
    ;

    private final int index;
    private final String description;

}
