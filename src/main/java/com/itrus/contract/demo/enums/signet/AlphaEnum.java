package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
@Getter
@AllArgsConstructor
public enum AlphaEnum {

    /**
     * 签名透明度(0-10)默认5(公共参数)
     */
    A0(0),
    A1(1),
    A2(2),
    A3(3),
    A4(4),
    A5(5),
    A6(6),
    A7(7),
    A8(8),
    A9(9),
    A10(10),
    ;

    private final int index;

}
