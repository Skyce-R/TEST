package com.itrus.contract.demo.vo.req.contract;


import java.util.List;

public class ApiContractBatchSignReq   {
//
//    | enterpriseId           | String     | 选填 | 企业id                                                       |
//            | ---------------------- | ---------- | ---- | ------------------------------------------------------------ |
//            | userId                 | String     | 必填 | 用户id                                                       |
//            | signerType             | Integer    | 必填 | 签署人类型 1 个人 2企业                                      |
//            | contractIds            | List<Long> | 必填 | 合同id集合                                                   |
//            | isUserWishes           | boolean    | 选填 | 是否要做意愿认证；默认false；<br />false 否 用户自己做意愿认证， <br />true 是 需要天威诚信做意愿认证 ； |
//            | userWishesWay          | Integer    | 选填 | 意愿认证方式；1 验证码认证方式（默认），后续会扩展认证方式；<br />isUserWishes参数为true时必填<br /> |
//            | codeNumber             | String     | 选填 | 验证码编号                                                   |
//            | verifyCode             | String     | 选填 | 验证码                                                       |
//            | signControlValue       | String     | 必填 | 控件值  支持 base64:xxx 和 sealId:123                        |
//            | signDate               | String     | 选填 | 如果存在日期控件此项为必填                                   |
//            | agentStampControlValue | String     | 选填 | 经办人签名控件值，支持 base64:xxx 和 sealId:123              |


    private Integer signerType;
    private String userId;
    private String enterpriseId;

    /**
     * 合同id集合
     */
    private List<Long> contractIds;

    /**
     * 是否要做意愿认证；默认false；<br />false 否 用户自己做意愿认证， <br />true 是 需要天威诚信做意愿认证 ； |
     */
    private boolean isUserWishes;
    /**
     *  意愿认证方式；1 验证码认证方式（默认），后续会扩展认证方式；<br />isUserWishes参数为true时必填<br />
     */
    private Integer userWishesWay;
    /**
     * 验证码编号
     */
    private String codeNumber;
    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 控件值  支持 base64:xxx 和 sealId:123
     */
    private String signControlValue;
    /**
     * 如果存在日期控件此项为必填
     */
//    private String signDate;
    /**
     * 经办人签名控件值，支持 base64:xxx 和 sealId:123
     */
    private String agentStampControlValue;

    private Integer channel;


    public Integer getSignerType() {
        return signerType;
    }

    public void setSignerType(Integer signerType) {
        this.signerType = signerType;
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

    public List<Long> getContractIds() {
        return contractIds;
    }

    public void setContractIds(List<Long> contractIds) {
        this.contractIds = contractIds;
    }

    public boolean isUserWishes() {
        return isUserWishes;
    }

    public void setUserWishes(boolean userWishes) {
        isUserWishes = userWishes;
    }

    public Integer getUserWishesWay() {
        return userWishesWay;
    }

    public void setUserWishesWay(Integer userWishesWay) {
        this.userWishesWay = userWishesWay;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getSignControlValue() {
        return signControlValue;
    }

    public void setSignControlValue(String signControlValue) {
        this.signControlValue = signControlValue;
    }

    public String getAgentStampControlValue() {
        return agentStampControlValue;
    }

    public void setAgentStampControlValue(String agentStampControlValue) {
        this.agentStampControlValue = agentStampControlValue;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
