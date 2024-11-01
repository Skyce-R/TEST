package com.itrus.contract.demo.vo.req.contract;

import com.itrus.contract.demo.vo.req.contract.signByFile.SignSignerApiVO;
import lombok.Data;

/**
 * @author pjw
 */
@Data
public class SignByFileOrTemplateApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同签署人
     */
    private SignSignerApiVO signer;

}
