package com.itrus.contract.demo.vo.req.contract;

public class ApiNullifyUrlReq  {

    /**
     * 合同id
     * @required
     */

    private Long contractId;
    /**用户类型**/
    private Integer userType;
    /**用户id(合同的发起方或签署方)**/
    private String userId;
    /**企业id(合同的发起方或签署方)，企业方必填**/
    private String enterpriseId;
    /**确认完成跳转地址  **/
    private String syncUrl;
    /**异步回调地址 **/
    private String asyncUrl;

    /**地址有效期,单位分钟;默认30分钟**/
    private Integer expire = 30;


    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public String getSyncUrl() {
        return syncUrl;
    }

    public void setSyncUrl(String syncUrl) {
        this.syncUrl = syncUrl;
    }

    public String getAsyncUrl() {
        return asyncUrl;
    }

    public void setAsyncUrl(String asyncUrl) {
        this.asyncUrl = asyncUrl;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}
