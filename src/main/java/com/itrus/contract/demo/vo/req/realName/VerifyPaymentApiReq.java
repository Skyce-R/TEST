package com.itrus.contract.demo.vo.req.realName;



/**
 * @author pjw
 * @date 2022/10/27/0027
 */

public class VerifyPaymentApiReq  {

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 银行打款金额
     */
    private String paymentAmount;

    private Integer authSource;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Integer getAuthSource() {
        return authSource;
    }

    public void setAuthSource(Integer authSource) {
        this.authSource = authSource;
    }
}
