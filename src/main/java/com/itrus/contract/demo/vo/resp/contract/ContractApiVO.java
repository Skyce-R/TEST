package com.itrus.contract.demo.vo.resp.contract;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.itrus.contract.demo.vo.resp.template.DocumentApiVO;

import java.time.LocalDateTime;
import java.util.List;

public class ContractApiVO  {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同名称
     */
    private String contractName;


    /**
     * 合同编号
     */
    private String code;

    /**
     * 签署状态:1.待签署,2.签署中,3.已完成,4.已过期,5.已解约,6.已拒签
     */
    private Integer status;

    /**
     * 企业名称
     */
    private String enterpriseName;


    /**
     * 企业id
     */
    private String enterpriseId;


    /**
     * 业务类型
     */
    private String bizCode;

    /**
     * 发起人姓名
     */
    private String createName;

    /**
     * 文件类型 1:PDF,2:OFD
     */
    private Integer fileType;

    /**
     * 生效日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime effectDate;

    /**
     * 发送日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime sendTime;

    /**
     * 最后签署时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastSignedTime;

    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime expiredTime;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishedTime;

    /**
     * 文档
     */
    private List<DocumentApiVO> documents;

    /**
     * 文档id
     * @ignore
     */
    private Long docId;

    /**
     * 文档id
     * @ignore
     */
    private String docName;


    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public LocalDateTime getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(LocalDateTime effectDate) {
        this.effectDate = effectDate;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public LocalDateTime getLastSignedTime() {
        return lastSignedTime;
    }

    public void setLastSignedTime(LocalDateTime lastSignedTime) {
        this.lastSignedTime = lastSignedTime;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }

    public List<DocumentApiVO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentApiVO> documents) {
        this.documents = documents;
    }

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
}
