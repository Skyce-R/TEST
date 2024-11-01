package com.itrus.contract.demo.vo.req.intention;


import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class VerifyIntentionApiReq   {

    /**
     * 意愿认证用途
     */
    private Integer intentionPurpose;

    /**
     * 意愿认证方式；1,验证码认证方式，2,签署密码认证。
     */
    private Integer intentionWay;

    /**
     * 认证编号
     */
    private  String intentionId;

    /**
     * 验证码,意愿认证方式为验证码认证时必填
     */
    private String verifyCode;

    /**
     * 签署密码,意愿认证方式为签署密码认证时必填
     */
    private String signPassword;

    /**
     * 用户id
     */
    private String userId;

}
