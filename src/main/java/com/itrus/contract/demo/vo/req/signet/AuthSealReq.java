package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Setter
@Getter
public class AuthSealReq {

    private String enterpriseId;
    private String authUserId;
    private String toAuthUserId;
    private String toAuthManagerId;
    private Long sealId;

}
