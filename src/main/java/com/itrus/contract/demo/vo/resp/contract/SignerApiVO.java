package com.itrus.contract.demo.vo.resp.contract;

import com.itrus.contract.demo.vo.resp.template.DocumentApiVO;

import java.time.LocalDateTime;
import java.util.List;

public class SignerApiVO {

    /**
     * 签署人id
     */
    private Long signerId;

    /**
     * 签约方类型:1个人 2企业
     */
    private Integer signerType;

    /**
     * 签署人状态:1.待他人签署,2 待我签(.签署中),3.已签署,5.已解约,6.已拒签
     */
    private Integer signStatus;

    /**
     * 签署人姓名
     */
    private String userName;

    /**
     * 签署人用户id
     */
    private String userId;

    /**
     * 签署人企业id
     */
    private String enterpriseId;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 签署人角色
     */
    private String signRole;

    /**
     * 是否为有序签
     */
    private Boolean signSortable;

    /**
     * 签署顺序
     */
    private Integer sequenceNumber;

    /**
     * 是否意愿认证:0 否、1是
     */
    private Boolean desireType;

    /**
     * 是否发生短信通知签署人到诚信签-前置平台进行签署:0 否、1是
     */
    private Boolean sendMsg;

    /**
     * 是否发生邮件通知签署人到诚信签-前置平台进行签署:0 否、1是
     */
    private Boolean sendMail;

    /**
     * 签署方式:1手动签署(默认)、2自动签署
     */
    private Integer signMode;

    /**
     * 是否需要审批:0不需要(默认)、1要审批
     */
    private Boolean approved;

    /**
     * 审批状态: 0:待审批,1:审批通过,2:已拒绝,3: 退回,4:撤销,5:审批中
     */
    private Integer approveStatus;

    /**
     * 解约状态:0无解约、1待确认解约、2已确认解约、3已拒绝解约
     */
    private Integer nullifyStatus;

    /**
     * 是否指定控件位置:0否、1是
     */
    private Boolean setting;

    /**
     * 控件类型范围
     */
    private String controlsType;

    /**
     * 签署时间
     */

    private LocalDateTime signTime;

    /**
     * 签署人文档
     */
    private List<DocumentApiVO> docList;


    public Long getSignerId() {
        return signerId;
    }

    public void setSignerId(Long signerId) {
        this.signerId = signerId;
    }

    public Integer getSignerType() {
        return signerType;
    }

    public void setSignerType(Integer signerType) {
        this.signerType = signerType;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getSignRole() {
        return signRole;
    }

    public void setSignRole(String signRole) {
        this.signRole = signRole;
    }

    public Boolean getSignSortable() {
        return signSortable;
    }

    public void setSignSortable(Boolean signSortable) {
        this.signSortable = signSortable;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Boolean getDesireType() {
        return desireType;
    }

    public void setDesireType(Boolean desireType) {
        this.desireType = desireType;
    }

    public Boolean getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(Boolean sendMsg) {
        this.sendMsg = sendMsg;
    }

    public Boolean getSendMail() {
        return sendMail;
    }

    public void setSendMail(Boolean sendMail) {
        this.sendMail = sendMail;
    }

    public Integer getSignMode() {
        return signMode;
    }

    public void setSignMode(Integer signMode) {
        this.signMode = signMode;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Integer getNullifyStatus() {
        return nullifyStatus;
    }

    public void setNullifyStatus(Integer nullifyStatus) {
        this.nullifyStatus = nullifyStatus;
    }

    public Boolean getSetting() {
        return setting;
    }

    public void setSetting(Boolean setting) {
        this.setting = setting;
    }

    public String getControlsType() {
        return controlsType;
    }

    public void setControlsType(String controlsType) {
        this.controlsType = controlsType;
    }

    public LocalDateTime getSignTime() {
        return signTime;
    }

    public void setSignTime(LocalDateTime signTime) {
        this.signTime = signTime;
    }

    public List<DocumentApiVO> getDocList() {
        return docList;
    }

    public void setDocList(List<DocumentApiVO> docList) {
        this.docList = docList;
    }
}