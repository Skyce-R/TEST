package com.itrus.contract.demo.enums.ukey;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
@Getter
@AllArgsConstructor
public enum SignatureTypeEnum {

    /**
     * 签名宽度
     */
    Sha256WithRsa("Sha256WithRsa"),
    Sm3WithSm2("Sm3WithSm2"),
    ;

    private final String code;

}
