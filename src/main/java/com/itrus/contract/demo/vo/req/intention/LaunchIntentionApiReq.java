package com.itrus.contract.demo.vo.req.intention;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class LaunchIntentionApiReq   {

	/**
	 * 企业ID
	 */
	private String companyUuid;
	/**
	 * 意愿认证用途:1合同签署意愿认证(默认),2个人实名意愿认证,3企业实名意愿认证,4签署密码设置,5私钥授权,6变更管理员，7合同解约意愿认证
	 */
	private Integer intentionPurpose;

	/**
	 * 意愿认证发送方式:1发送验证码(默认)
	 */
	private Integer intentionWay;

	/**
	 * 意愿认证方式(根据用户或者手机号发送) 1 userid(默认) 2 phone
	 */
	private Integer type;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 手机号
	 */
	private String phone;

}
