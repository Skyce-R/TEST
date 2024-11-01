package com.itrus.contract.demo.vo.req.callback;

import lombok.Data;

import java.io.Serializable;

/**
 * 回调用户信息
 */
@Data
public class CallBackUserReq implements Serializable {

    private String userUuid;

    private String email;
    private String phone;
    /**
//     * @see com.itrus.contract.enumeration.user.AuthTypeEnum
     */
    private String authType;
    /**
//     * @see AuthStatusEnum
     */
    private String authResult;
    private String displayName;
    private String idCardNum;
    private String idCardType;

}
