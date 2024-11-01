package com.itrus.contract.demo.vo.req.cert;


import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class ApplyCertApiReq  {

    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 企业唯一标识
     */
    private String enterpriseId;

    /**
     * 证书类型
     */
    private Integer certType;

}
