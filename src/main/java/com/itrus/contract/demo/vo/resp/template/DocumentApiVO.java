package com.itrus.contract.demo.vo.resp.template;


public class DocumentApiVO  {

    /**
     * 合同文件docId
     */
    private Long docId;

    /**
     * 合同文件名称
     */
    private String docName;

    /**
     * 合同文件签署状态
     */
    private Integer docStatus;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名
     */
    private String fileName;


    /**
     * 最终文件存储id
     * @ignore
     */
    private Long lastFileId;

    /**
     * 合同文件base64
     */
    private String docBase64;

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Integer getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(Integer docStatus) {
        this.docStatus = docStatus;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getLastFileId() {
        return lastFileId;
    }

    public void setLastFileId(Long lastFileId) {
        this.lastFileId = lastFileId;
    }

    public String getDocBase64() {
        return docBase64;
    }

    public void setDocBase64(String docBase64) {
        this.docBase64 = docBase64;
    }
}
