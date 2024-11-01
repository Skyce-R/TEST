package com.itrus.contract.demo.enums.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum ContractDownloadTypeEnum {

    /**
     * 签名字体
     */
    SINGLE(1, "单个"),
    MULT(2, "多个"),
    ;

    private final int index;
    private final String description;

}
