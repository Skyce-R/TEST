package com.itrus.contract.demo.vo.req.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/11/0011
 */
@Setter
@Getter
public class JoinOrgReq {

    /**
     * 邀请人用户唯一标识
     */
    private String userId;

    /**
     * 受邀人用户唯一标识
     */
    private String inviteUserId;

    /**
     * 邀请加入企业唯一标识
     */
    private String enterpriseId;

    /**
     * 企业邮箱
     */
    private String employeeEmail;

    /**
     * 员工工号
     */
    private String employeeCode;

}
