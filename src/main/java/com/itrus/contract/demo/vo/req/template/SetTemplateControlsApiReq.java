package com.itrus.contract.demo.vo.req.template;


import com.itrus.contract.demo.vo.req.template.setControls.SetTemplateSignersApiOld;
import lombok.Data;

import java.util.List;

/**
 * @author pjw
 */
@Data
public class SetTemplateControlsApiReq  {

    /**
     * 模板编号
     */
    private String code;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 模板签署方
     */
    private List<SetTemplateSignersApiOld> signers;

}
