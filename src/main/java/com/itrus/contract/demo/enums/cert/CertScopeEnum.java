package com.itrus.contract.demo.enums.cert;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/9/7/0007
 */
@Getter
@AllArgsConstructor
public enum CertScopeEnum {

    /**
     * 证书范围
     */
    ALL(0, "全部"),
    SERVER(1, "服务端证书"),
    CLIENT(2, "客户端证书")
    ;

    private final int index;
    private final String description;

}
