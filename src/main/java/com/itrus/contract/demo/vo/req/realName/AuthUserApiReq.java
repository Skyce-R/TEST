package com.itrus.contract.demo.vo.req.realName;


import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class AuthUserApiReq  {

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 企业ID
	 */
	private String companyUuid;
	
	/**
	 * 意愿认证编号
	 */
	private String intentionId;

	/**
	 * 用户名称，用户名称长度需要在1-16之间
	 */
	private String displayName;

	/**
	 * 证件编号
	 */
	private String idCardNum;

	/**
	 * 证件类型
	 */
	private String idCardType;

	/**
	 * 银行卡号
	 */
	private String bankCard;

	/**
	 * 实名认证类型1.手机号三要素，3.银行卡四要素 默认手机号三要素
	 */
	private Integer realNameType;

	/**
	 * 手机号
	 */
	private  String phone;

	/**
	 * 验证码流水号
	 */
	private String codeNumber;

	/**
	 * 验证码
	 */
	private String verifyCode;

}
