package com.itrus.contract.demo.vo.req.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/10/0010
 */
@Setter
@Getter
public class UpdatePersonReq {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String displayName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户标签(需在诚信签-前置web页面配置)
     */
    private String userLabel;

}
