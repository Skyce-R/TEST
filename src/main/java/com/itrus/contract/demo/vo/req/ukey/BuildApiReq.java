package com.itrus.contract.demo.vo.req.ukey;

import com.itrus.contract.demo.vo.view.DocumentHashVO;
import lombok.Data;

import java.util.List;

/**
 * @author pjw
 */
@Data
public class BuildApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 签署人id
     */
    private Long signerId;

    /**
     * ukey hash
     */
    private List<DocumentHashVO> ukeyHashList;

}
