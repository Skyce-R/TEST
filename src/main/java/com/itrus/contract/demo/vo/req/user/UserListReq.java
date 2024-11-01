package com.itrus.contract.demo.vo.req.user;

import com.itrus.contract.demo.vo.req.TimePeriodReq;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/11/0011
 */
@Setter
@Getter
public class UserListReq extends TimePeriodReq {

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 证件号
     */
    private String idCardNum;

}
