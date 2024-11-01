package com.itrus.contract.demo.vo.req.contract;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class ContractDetailsApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 查询详情是否返回合同文件数据，默认false不返回
     */
    private Boolean responseContractFile;

}
