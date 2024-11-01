package com.itrus.contract.demo.vo.req.cert;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class QueryCertApiReq   {

    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 企业唯一标识
     */
    private String enterpriseId;

    /**
     * 证书类型范围， 0:全部（默认），1:服务端证书，2:客户端证书
     */
    private Integer scope = 0;

    /**
     * 证书类型
     */
    private Integer category;

}
