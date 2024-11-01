package com.itrus.contract.demo.enums.cert;


import com.itrus.contract.demo.enums.account.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum CertTypeEnum   {

    /**
     * 证书类型
     */
    PERSON(1,"个人", UserTypeEnum.PERSON,1),
    ENTERPRISE(2,"企业",UserTypeEnum.ENTERPRISE,2),
    LEGAL(3,"法定代表人",UserTypeEnum.PERSON,1)
    ;

    private final int index;
    private final String description;
    private final UserTypeEnum userType;
    private final Integer atomIndex;

}
