package com.itrus.contract.demo.vo.resp.enterprise;




public class UpdateOrgApiResp{

    /**
     * 企业id
     * @required
     */
    private String enterpriseId;

    private String certId;

    private String certCode;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }
}
