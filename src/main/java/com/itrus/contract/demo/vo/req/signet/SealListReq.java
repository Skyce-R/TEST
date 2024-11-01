package com.itrus.contract.demo.vo.req.signet;

import com.itrus.contract.demo.vo.req.PageReq;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Setter
@Getter
public class SealListReq extends PageReq {

    private String enterpriseId;
    private String userId;
    private Long id;
    private String name;
    private Boolean requiredBase64;
    private Boolean requiredAuthorizer;

}
