package com.itrus.contract.demo.enums.enterprise;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum EnterpriseTypeEnum   {

    /**
     * 企业类型
     */
    ET_PE(0, "企业","ET_PE"),
    ET_SE(1, "个体工商户","ET_SE"),
    OU(2, "政府机构/事业单位","OU"),
    ;

    private final int index;
    private final String description;
    private final String code;

}
