package com.itrus.contract.demo.enums.realName;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum UserAuthTypeEnum  {

    /**
     * 实名类型
     */
    AUTH_TYPE_PERSON_ID_CARD_2(0, "身份证两要素"),
	AUTH_TYPE_PHONE_3(1,"手机号三要素"),
	AUTH_TYPE_BANK_CARD_4(3,"银行卡四要素")
    ;

    private final int index;
    private final String description;

}