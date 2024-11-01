package com.itrus.contract.demo.vo.req.template.create;

import lombok.*;

/**
 * @author pjw
 */
@Data
public class AddTemplateSignerApiVO  {

    /**
     * 模板签署方（角色与签署人类型要匹配）
     */
    private String signerRole;

    /**
     * 模板签署方类型：1个人，2企业
     */
    private Integer signerType;

    /**
     * 签署顺序
     */
    private Integer sequence;

    public AddTemplateSignerApiVO(String signerRole, int signerType, int sequence) {
        this.signerRole = signerRole;
        this.signerType = signerType;
        this.sequence = sequence;
    }
}
