package com.itrus.contract.demo.vo.req.contract;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class UploadFileApiReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同文档名称
     */
    private String docName;

    /**
     * 合同文件（base64），支持pdf/doc/docx文件格式. base64与filePath二选一
     */
    private String contractFile;

    /**
     * 文件绝对路径（带文件名）
     */
    private String filePath;

    /**
     * 文件绝对路径类型：1ftp路径（默认）、2http路径
     */
    private Integer pathType;

    /**
     * 合同文件排序序号（此序号用于多文件场景，无多文件场景可不传递）
     */
    private Integer sequence;

}
