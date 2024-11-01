package com.itrus.contract.demo.vo.req.datasign;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Getter
@Setter
public class DigestVerifyReq {

    /**
     * 签名记录id
     */
    private Long signRecordCode;

    /**
     * 签名值
     */
    private String signValue;

    /**
     * 签名原文
     */
    private String content;

}