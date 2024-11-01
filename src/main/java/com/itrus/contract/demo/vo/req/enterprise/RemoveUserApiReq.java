package com.itrus.contract.demo.vo.req.enterprise;


import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2022/10/27/0027
 */
@Setter
@Getter
public class RemoveUserApiReq  {

    /**
     * 被移除用户id
     */
    private String userId;

    /**
     * 企业id
     */
    private String enterpriseId;

}
