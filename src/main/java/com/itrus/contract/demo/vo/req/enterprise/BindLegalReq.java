package com.itrus.contract.demo.vo.req.enterprise;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class BindLegalReq {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 法定代表人ID
     */
    private String legalUserId;

    /**
     * 操作者ID
     */
    private String operatorUserId;

}
