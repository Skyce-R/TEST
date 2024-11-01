package com.itrus.contract.demo.vo.req.enterprise;

import lombok.Getter;
import lombok.Setter;

/**
 * 企业信息VO
 * @author pjw
 * @date 2022/4/29/0029
 */
@Setter
@Getter
public class CreateOrgApiReq  {

    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 企业全称（1-32位字符）
     */
    private String orgName;

    /**
     * 证件类型（"N"，社会统一信用代码（支持多种）） authentication=true时必填
     */
    private String idType;

    /**
     * 证件号（1-32） authentication=true时必填
     */
    private String orgCode;

    /**
     * 其他证件类型名称
     */
    private String otherCardName;

    /**
     * 企业类型:ET_PE:企业 (默认),  ET_SE:个体工商户,  OU:政府机构/事业单位
     */
    private String enterpriseType;

    /**
     * 实名认证来源(客户认证true,天威认证false)
     */
    private Boolean authentication;

    /**
     * 法定代表人姓名,(1-32位长度)
     */
    private String legalName;

    /**
     * 法定代表人手机号
     */
    private String legalPhone;

    /**
     * 法定代表人证件类型
     */
    private String legalIdCardType;

    /**
     * 法定代表人证件号(身份证号15、18位校验,其它1-64位校验)
     */
    private String legalIdCard;

    /**
     * 扩展数据,数据格式为json(key/value形式)例如:{"name":"张三"}
     */
    private String extendData;

    /**
     * 企业标签
     */
    private String enterpriseLabel;

}
