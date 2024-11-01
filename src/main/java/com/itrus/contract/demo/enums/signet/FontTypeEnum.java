package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum FontTypeEnum {

    /**
     * 签名字体
     */
    WEIRUANYAHEI(1, "微软雅黑（默认）"),
    HEITI(2, "黑体"),
    SONG(3, "宋体"),
    HUAWEN(4, "华文行楷"),
    FANGZHENG(5, "方正舒体"),
    ;

    private final int index;
    private final String description;

}
