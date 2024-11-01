package com.itrus.contract.demo.vo.req.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/10/0010
 */
@Setter
@Getter
public class CreatePersonReq {

    /**
     * 用户名称，用户名称长度需要在1-32之间，当authentication为true时，为必填
     */
    private String displayName;

    /**
     * 证件类型，（当输入idCardNum，此项必填），当authentication为true时支持多种证件类型，当authentication 为false时只支持身份证号
     */
    private String idCardType;

    /**
     * 证件号码 ，当authentication为true时，idCardNum为必填
     */
    private String idCardNum;

    /**
     * 其他证件类型名称
     */
    private String otherCardName;

    /**
     * 账号类型:1手机号(默认),2账号
     */
    private Integer type;

    /**
     * 手机号(手机号与账号二选一)  type为1时手机号必填
     */
    private String phone;

    /**
     * 账号  长度1-64位(手机号与账号二选一)  type为2时账号必填
     */
    private String account;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 实名认证来源(客户认证true,天威认证false)
     */
    private Boolean authentication;

    /**
     * 用户标签(需在诚信签-前置web页面配置)
     */
    private String userLabel;

}
