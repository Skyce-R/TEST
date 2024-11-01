package com.itrus.contract.demo.vo.req.enterprise;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class AddOrModifyAdminApiReq   {

	/**
	 * 类型  1.变更（默认）  2.添加
	 */
	private Integer type;

	/**
	 * 被变更主管理员用户唯一标识，类型为1时必填  旧主管理员
	 */
	private String originalUserId;

	/**
	 * 新主管理员
	 */
	private String newUserId;

	/**
	 * 企业id
	 */
	private String enterpriseId;

	/**
	 * 意愿编号
	 */
	private String intentionId;

	/**
	 * 是否发送变更完成短信通知
	 */
	private Boolean smsNotice;

}
