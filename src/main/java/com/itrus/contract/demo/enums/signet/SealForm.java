package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum SealForm {

    /**
     * 印章类型
     */
    OFFICIAL(1, "公章"),
    FINANCE(2, "财务专用章"),
    CONTRACTUAL(3, "合同专用章"),
    INVOICE(4, "发票专用章"),
    OTHER(0, "其他"),
    ;

    private final int index;
    private final String description;

}
