package com.itrus.contract.demo.vo.req.pageauth;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author pjw
 */
@Getter
@Setter
public class StartUserPageAuthReq {

    /**
     * 用户ID
     */
    public String userId;

    /**
     * 可选实名认证类型
     */
    private List<Integer> realNameTypes;

    /**
     * 认证时可修改内容
     */
    private List<String> cantEditFields;

    /**
     * 认证成功跳转页面（不传用天威默认页面）
     */
    private String successLocation;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 链接有效期,单位分钟;默认30分钟,最小5分钟, 最大60*24分钟(24小时);
     */
    private Integer expire;

    private UserInfoReq userInfo;

}
