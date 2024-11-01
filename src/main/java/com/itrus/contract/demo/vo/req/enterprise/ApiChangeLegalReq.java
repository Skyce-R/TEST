package com.itrus.contract.demo.vo.req.enterprise;

import lombok.Getter;
import lombok.Setter;

/**
 * description: WebChangeLegalReq <br>
 * date: 2023/4/8  <br>
 * @author zss <br>
 * version: 1.0.0 <br>
 */
@Setter
@Getter
public class ApiChangeLegalReq {

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
