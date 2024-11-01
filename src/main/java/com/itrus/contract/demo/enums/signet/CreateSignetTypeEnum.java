package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum CreateSignetTypeEnum {

    /**
     * 创建印章类型
     */
    ORDINARY(1, "普通印章（默认）"),
    OFD(2, "OFD印章"),
    ;

    private final int index;
    private final String description;

}
