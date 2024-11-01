package com.itrus.contract.demo.vo.req.cert;


import java.util.List;

/**
 * @author pjw
 * @date 2022/10/30/0030
 */

public class PagePrivateAuthApiReq  {

    /**
     * 合同id
     */
    private List<Long> contractId;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 签署人类型：1个人、2企业
     */
    private Integer signerType;

    /**
     * 授权回调地址
     */
    private String callbackUrl;

    public List<Long> getContractId() {
        return contractId;
    }

    public void setContractId(List<Long> contractId) {
        this.contractId = contractId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getSignerType() {
        return signerType;
    }

    public void setSignerType(Integer signerType) {
        this.signerType = signerType;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
