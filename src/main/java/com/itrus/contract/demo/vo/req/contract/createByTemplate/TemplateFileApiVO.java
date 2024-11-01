package com.itrus.contract.demo.vo.req.contract.createByTemplate;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author pjw
 */
@Data
public class TemplateFileApiVO {

    /**
     * 模板合同文件id
     */
    private Long templateDocId;

    /**
     * 合同文件名称
     */

    private String docName;

    /**
     * 模板合同补充变量
     */
    private Map<String,String> params;

    /**
     * 文本控件字体属性
     */
    private List<FontApiVO> fonts;

}
