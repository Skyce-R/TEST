package com.itrus.contract.demo.vo.req.cert;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author pjw
 */
@Setter
@Getter
public class PrivateAuthApiReq   {

    /**
     * 合同id
     */
    private List<Long> contractId;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 签署人类型：1个人、2企业
     */
    private Integer signerType;

    /**
     * 意愿认证编号
     */
    private String intentionId;

}
