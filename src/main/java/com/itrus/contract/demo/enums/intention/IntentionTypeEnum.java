package com.itrus.contract.demo.enums.intention;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum IntentionTypeEnum  {
    /**
     *  类型 1 userid(默认) 2 phone
     */
    USER_ID(1, "userid(默认)"),
    PHONE(2, "phone"),
    ;

    private final int index;
    private final String description;

}
