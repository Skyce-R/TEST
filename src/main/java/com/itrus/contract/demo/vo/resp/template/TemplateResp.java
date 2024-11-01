package com.itrus.contract.demo.vo.resp.template;


import java.util.List;

public class TemplateResp   {

    /**
     * 模板id
     */
    private Long templateId;

    /**
     * 模板编号
     */
    private String code;
    /**
     * 模板文件
     */
    private List<DocumentApiVO> docList;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DocumentApiVO> getDocList() {
        return docList;
    }

    public void setDocList(List<DocumentApiVO> docList) {
        this.docList = docList;
    }
}
