package com.itrus.contract.demo.vo.req.ofdUkey;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class GetOfdSignetHashApiReq {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 签章id
     */
    private Long signatureId;

    /**
     * 签章类型 1 个人 2 企业
     */
    private Integer signatureType;

    /**
     * 证书的base64
     */
    private String certBase64;

}
