package com.itrus.contract.demo.enums.callback;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信息变更类型
 */
@Getter
@AllArgsConstructor
public enum InformationChangedTypeEnum {

    PERSON_CHANGED(1,"个人信息变更"),
    ENTERPRISE_CHANGED(2,"企业信息变更"),
    LEGAL_CHANGED(3,"法定代表人变更"),
    ENTERPRISE_REMOVE_USER(4,"企业移除用户"),

            ;
    private int index;
    private String description;

    public static InformationChangedTypeEnum getChangedTypeById(int index){
        InformationChangedTypeEnum[] values = values();
        for (InformationChangedTypeEnum value : values) {
            if(value.getIndex() == index){
                return value;
            }
        }
        return null;
    }

}
