package com.itrus.contract.demo.vo.req.contract;

import com.itrus.contract.demo.vo.req.contract.addSignerByTemplate.TemplateSignerApiVO;
import lombok.Data;

import java.util.List;

/**
 * @author pjw
 */
@Data
public class AddSignerByTemplateApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同签署人
     */
    private List<TemplateSignerApiVO> templateSigners;

}
