package com.itrus.contract.demo.vo.req.contract;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class AddCCApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 抄送人类型:1=个人 2=企业
     */
    private Integer ccType;

    /**
     * 抄送人用户id
     */
    private String userId;

    /**
     * 抄送人企业id
     */
    private String enterpriseId;

}
