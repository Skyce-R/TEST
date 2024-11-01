package com.itrus.contract.demo.vo.req.pageauth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnterpriseInfoReq {
    /**
     * 企业名称
     */
    String enterpriseName;

    /**
     * 证件号
     */
    String orgCode;

    String legalPersonName;
    /**
     * 法人身份证
     */
    String legalIdcardNum;
    /**
     * 法人手机号
     */
    String legalPhone;

    /**
     * 经办人姓名
     */
    String agentName;

    /**
     * 经办人身份证号
     */
    String agentIdcardNum;
    /**
     * 银行卡号
     */
    String bankAccount;
}
