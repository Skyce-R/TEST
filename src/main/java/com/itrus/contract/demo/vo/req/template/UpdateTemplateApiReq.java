package com.itrus.contract.demo.vo.req.template;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class UpdateTemplateApiReq {

    /**
     * 模板编号
     */
    private String code;

    /**
     * 模板所属企业id
     */
    private String enterpriseId;

}
