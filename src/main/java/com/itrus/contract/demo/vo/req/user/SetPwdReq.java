package com.itrus.contract.demo.vo.req.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/11/0011
 */
@Setter
@Getter
public class SetPwdReq {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 设置签署的密码,如果设置类型是更改密码,则在此录入新密码,可以与原密码保持一致(必填)
     */
    private String signPassword;

    /**
     * 验证来源 1 客户验证 2 天威验证 默认客户验证
     */
    private Integer verifySource;

    /**
     * 意愿认证编号
     */
    private String intentionId;

}
