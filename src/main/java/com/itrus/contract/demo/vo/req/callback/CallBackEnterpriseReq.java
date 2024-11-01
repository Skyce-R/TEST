package com.itrus.contract.demo.vo.req.callback;

import lombok.Data;

/**
 * 回调企业信息
 */
@Data
public class CallBackEnterpriseReq {
    private String companyUuid;
    //用户ID，用于处理企业移除用户场景
    private String userUuid;
    private String orgAlias;
    private String orgName;
    private String authType;
    private String authResult;
    /**
     * 主管理员
     */
    private String creatorUuid;
    private String socialCode;
    private String unitCode;
    private String legalUuid;
}
