package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
@Getter
@AllArgsConstructor
public enum ColorEnum {

    /**
     * 签名颜色
     */
    UNCHANGED(0, "使用原图颜色"),
    RED(1, "红色（默认）"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色"),
    BLACK(4, "黑色"),
    ;

    private final int index;
    private final String description;

}
