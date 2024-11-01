package com.itrus.contract.demo.vo.req.contract;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class ApiNullifyContractReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 已认证的意愿编号
     */
    private String intentionId;

    /**
     * 操作类型:1=同意、2=拒绝
     */
    private Integer operateType;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 企业id，企业方必填
     */
    private String enterpriseId;

    /**
     * 原因
     */
    private String reason;

}
