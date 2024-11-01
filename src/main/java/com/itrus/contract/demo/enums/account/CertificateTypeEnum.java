package com.itrus.contract.demo.enums.account;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum CertificateTypeEnum {

    /**
     * 证件类型
     */
    IDENTITY_CARD(0,"0","居民身份证", UserTypeEnum.PERSON),
    PASSPORT(1,"1","护照", UserTypeEnum.PERSON),
    MILITARY_ID(2,"2","军人身份证", UserTypeEnum.PERSON),
    ORGANIZATION_CODE_CERTIFICATE(7,"7","组织机构代码证", UserTypeEnum.ENTERPRISE),
    BUSINESS_LICENSE(8,"8","企业营业执照", UserTypeEnum.ENTERPRISE),
    HONG_KONG_MACAU_RESIDENTS(11,"B","港澳居民往来内地通行证", UserTypeEnum.PERSON),
    TAIWAN_RESIDENTS(12,"C","台湾居民来往大陆通行证", UserTypeEnum.PERSON),
    HK_FOREVER_PASS(13,"D","香港永久性居民身份证", UserTypeEnum.PERSON),
    UNIFIED_SOCIAL_CREDIT_CODE(23,"N","统一社会信用代码证", UserTypeEnum.ENTERPRISE),
    OTHER(35,"Z","其他", UserTypeEnum.PERSON),
    OTHER2(36,"Z","其他", UserTypeEnum.ENTERPRISE),
    ;

    private final int index;
    private final String code;
    private final String description;
    private final UserTypeEnum userType;

    public static CertificateTypeEnum[] getList(UserTypeEnum userType){
        List<CertificateTypeEnum> list = new ArrayList<>();
        CertificateTypeEnum[] values = CertificateTypeEnum.values();
        for(CertificateTypeEnum idCardType : values) {
            if(userType.equals(idCardType.userType)) {
                list.add(idCardType);
            }
        }
        CertificateTypeEnum[] resp = new CertificateTypeEnum[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resp[i] = list.get(i);
        }
        return resp;
    }
}
