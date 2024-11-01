package com.itrus.contract.demo.enums.intention;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum IntentionPurposeEnum  {

	/**
	 * 认证用途
	 */
	SIGN_CONTRACT(1,"合同签署意愿认证"),
	PERSON_REAL_NAME(2,"个人实名意愿认证"),
	ORG_REAL_NAME(3,"企业实名意愿认证"),
	SET_SIGN_PASSWORD(4,"签署密码设置"),
	PRIVATE_AUTH(5,"私钥授权"),
	CHANGE_ADMIN(6,"变更管理员"),
	NULLIFY_CONTRACT(7,"合同解约意愿认证"),
	READ_CONTRACT(8,"合同查阅意愿认证"),
	;

	private final int index;
	private final String description;

}
