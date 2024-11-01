package com.itrus.contract.demo.vo.resp.solidify;


/**
 * @Author: fujp
 * @Date: 2023/2/3 14:07
 */

public class WitnessResp {
    /**
     * base64文件
     */
    private String fileContent;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 见证报告文件名称
     */
    private String fileName;

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}