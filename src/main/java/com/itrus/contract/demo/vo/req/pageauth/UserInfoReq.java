package com.itrus.contract.demo.vo.req.pageauth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoReq {
    /**
     * 用户名
     */
    String displayName;

    /**
     * 手机号
     */
    String phone;

    /**
     * 证件编号
     */
    String idCardNum;

    /**
     * 证件类型
     */
    String idCardType = "0";

    /**
     * 银行卡号
     */
    String bankCard;
}
