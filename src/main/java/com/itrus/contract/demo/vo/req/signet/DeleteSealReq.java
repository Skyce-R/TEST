package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Setter
@Getter
public class DeleteSealReq {

    private String userId;
    private Long sealId;

}
