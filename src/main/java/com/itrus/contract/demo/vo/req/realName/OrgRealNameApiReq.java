package com.itrus.contract.demo.vo.req.realName;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2022/5/24/0024
 */
@Setter
@Getter
public class OrgRealNameApiReq  {

	/**
	 * 企业id
	 */
	private String enterpriseId;

	/**
	 * 经办人用户id
	 */
	private String agentUserId;

	/**
	 * 认证方式 1法定代表人手机号验证 2.企业打款认证
	 */
	private Integer authType = 1;

	/**
	 * 是否三证合一  false：否，true 是(默认)
	 */
	private Boolean inOneType = true;

	/**
	 * 统一社会信用代码(三证合一必填)
	 */
	private String socialCode;

	/**
	 * 组织机构代码(非三证合一必填)
	 */
	private String unitCode;

	/**
	 * 工商注册号(非三证合一必填)
	 */
	private String registeredNo;

	/* ---------------------- 法定代表人认证参数 ------------------------ */

	/**
	 * 法定代表人姓名  认证方式 为1时必填
	 */
	private String legalPersonName;

	/**
	 * 法定代表人身份证号 认证方式 为1时必填
	 */
	private String legalIdCardNum;


	/**
	 * 法定代表人手机号 认证方式 为1时必填
	 */
	private String legalPhone;

	/**
	 * 法定代表人短信验证码
	 */
	private String intentionId;

	/* ---------------------- 打款认证参数 ------------------------ */

	/**
	 * 银行账号 认证方式 为2时必填
	 */
	private String bankAccount;

	/**
	 * 开户行名称 认证方式 为2时必填
	 */
	private String bankName;

	/**
	 * 支行名称 认证方式 为2时必填
	 */
	private String branchBankName;

	/**
	 * 开户银行编码 认证方式 为2时必填
	 */
	private String bankCode;

	/**
	 * 省份编码 认证方式 为2时必填
	 */
	private String provinceCode;

	/**
	 * 城市编码 认证方式 为2时必填
	 */
	private String cityCode;

	/**
	 * 验证码流水号
	 */
	private String codeNumber;

	/**
	 * 验证码
	 */
	private String verifyCode;

	/**
	 * 实名来源   api 页面实名
	 */
	private Integer authSource = 1;

}
