package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@Setter
public class DelStampReq {

    private String userId;
    private Long stampId;

}
