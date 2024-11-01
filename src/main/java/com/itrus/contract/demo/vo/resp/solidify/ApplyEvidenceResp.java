package com.itrus.contract.demo.vo.resp.solidify;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 9:41 2020/10/23 0023
 */
@Getter
@Setter
public class ApplyEvidenceResp {

    /**
     * 法律文书标识  apply_order
     */
    private String legalDoc;
    /**
     * 合同id
     */
    private Long contractId;
    /**
     *  合同名称
     */
    private String contractTitle;



}
