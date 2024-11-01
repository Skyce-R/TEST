package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pjw
 */

@Getter
@AllArgsConstructor
public enum ControlTypeEnum {

    /**
     * 控件类型
     */
    TEXT(1,"text","文本控件"),
    AUTOGRAPH(2,"autograph","签名控件"),
    SIGNET(3,"signet","印章控件"),
    DATE(4,"date","日期控件"),
    AGENT(5,"agent","经办人控件"),
    LEGAL_PERSON(6,"legal","法定代表人控件"),
    ;

    private final int index;
    private final String code;
    private final String description;

    public static Set<String> getCodeSet(){
        ControlTypeEnum[] values = ControlTypeEnum.values();
        Set<String> codes = new HashSet<>();
        for (ControlTypeEnum value : values) {
            codes.add(value.code);
        }
        return codes;
    }

}
