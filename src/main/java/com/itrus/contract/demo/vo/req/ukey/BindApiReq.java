package com.itrus.contract.demo.vo.req.ukey;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class BindApiReq {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 证书类型
     */
    private Integer certType;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 操作(0:绑定；1:解绑;不传或为空时,默认为绑定)
     */
    private Integer operation;

}
