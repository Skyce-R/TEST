package com.itrus.contract.demo.vo.req.contract;

import lombok.Data;

/**
 * @author pjw
 * @date 2022/6/2/0002
 */
@Data
public class ContractStatusApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同文件id
     */
    private Long docId;

    /**
     * 操作类型：4=发起，5=撤回，6=结束
     */
    private Integer operationType;

}
