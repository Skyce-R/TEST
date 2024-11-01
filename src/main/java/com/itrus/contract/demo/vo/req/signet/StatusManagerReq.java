package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Setter
@Getter
public class StatusManagerReq {

    private String userId;
    private Integer typeOfSeal;
    private Long sealId;
    private Boolean status;
    private Integer operationType;
    private String syncUrl;

}
