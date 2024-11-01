package com.itrus.contract.demo.vo.resp.enterprise;




/**
 * @author pjw
 * @date 2022/10/6/0006
 */

public class CreateOrgApiResp  {

    /**
     * 企业id
     * @required
     */
    private String enterpriseId;

    /**
     * 证书id
     */
    private Long certId;


    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getCertId() {
        return certId;
    }

    public void setCertId(Long certId) {
        this.certId = certId;
    }
}
