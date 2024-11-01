package com.itrus.contract.demo.vo.req.ukey;

import com.itrus.contract.demo.vo.req.contract.signByFile.SignSignerApiVO;
import lombok.Data;

/**
 * @author pjw
 */
@Data
public class SignByFileApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同签署人
     */
    private SignSignerApiVO signer;

}
