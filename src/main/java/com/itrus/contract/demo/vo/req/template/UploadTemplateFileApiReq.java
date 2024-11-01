package com.itrus.contract.demo.vo.req.template;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class UploadTemplateFileApiReq   {

    /**
     * 模板编号
     */
    private String code;

    /**
     * 模板合同文档名称1-64字符，支持中文、英文大小写，数字、特殊字符
     */
    private String docName;

    /**
     * 模板合同文件（base64），支持pdf/doc/docx/ofd文件格式
     */
    private String templateFile;

    /**
     * 模板合同文件排序序号（此序号用于多文件场景，无多文件场景可不传递）
     */
    private Integer sequence;

    /**
     * 企业id
     */
    private String enterpriseId;

}
