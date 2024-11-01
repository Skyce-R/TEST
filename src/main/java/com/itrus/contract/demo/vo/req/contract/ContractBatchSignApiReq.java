package com.itrus.contract.demo.vo.req.contract;


import java.util.List;

public class ContractBatchSignApiReq   {


    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 验证码认证类型
     * @see
     */

    private Integer verificationCodeType;
    private String intentionId;

    private Integer userType;
    private String userId;
    private String enterpriseId;
    /**
     * 合同id集合
     */
    private List<Long> contractIdList;
    /**
     * 印章/签名id
     */
    //企业章
    private Long signSealId;
    //法定代表人章
    private Long legalSealId;
    /**
     * 经办人签名id
     */
    private Long agentStampId;

    private Integer channel;


    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getVerificationCodeType() {
        return verificationCodeType;
    }

    public void setVerificationCodeType(Integer verificationCodeType) {
        this.verificationCodeType = verificationCodeType;
    }

    public String getIntentionId() {
        return intentionId;
    }

    public void setIntentionId(String intentionId) {
        this.intentionId = intentionId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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

    public List<Long> getContractIdList() {
        return contractIdList;
    }

    public void setContractIdList(List<Long> contractIdList) {
        this.contractIdList = contractIdList;
    }

    public Long getSignSealId() {
        return signSealId;
    }

    public void setSignSealId(Long signSealId) {
        this.signSealId = signSealId;
    }

    public Long getLegalSealId() {
        return legalSealId;
    }

    public void setLegalSealId(Long legalSealId) {
        this.legalSealId = legalSealId;
    }

    public Long getAgentStampId() {
        return agentStampId;
    }

    public void setAgentStampId(Long agentStampId) {
        this.agentStampId = agentStampId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
