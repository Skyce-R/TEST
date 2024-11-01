package com.itrus.contract.demo.vo.req.template;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class TemplateStatusApiReq {

    /**
     * 模板编号
     */
    private String code;

    /**
     * 模板所属企业id
     */
    private String enterpriseId;

    /**
     * 模板状态:1开启,2关闭,3删除
     */
    private Integer status;

}
