package com.itrus.contract.demo.vo.req.signet;

import com.itrus.contract.demo.vo.req.PageReq;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@Setter
public class StampListReq extends PageReq {

    private String userId;
    private Long id;
    private String name;
    private Boolean requiredBase64;

}
