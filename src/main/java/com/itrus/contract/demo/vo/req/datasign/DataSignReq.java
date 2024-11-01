package com.itrus.contract.demo.vo.req.datasign;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataSignReq {

    /**
     * 标题
     */
    private String title;

    /**
     * 待签名数据 (原文或摘要)
     */
    private String content;

    /**
     * 数据类型:0摘要签名、1原文签名
     */
    private Integer digestType;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 签署方类型:1个人   2 企业
     */
    private Integer signerType;

    /**
     * 意愿验证  true:表示应用进行了用户意愿验证,并验证通过 ;非true返回错误信息提示
     */
    private Boolean desireType;

}
