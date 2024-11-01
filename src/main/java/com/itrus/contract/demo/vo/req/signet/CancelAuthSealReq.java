package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Setter
@Getter
public class CancelAuthSealReq {

    private String enterpriseId;
    private String userId;
    private String managerId;
    private Long sealId;
    private String authUserId;

}
