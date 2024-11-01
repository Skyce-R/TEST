package com.itrus.contract.demo.vo.resp.user;

/**
 * @author pjw
 * @date 2023/8/10/0010
 */
public class PersonResp {

    private String userId;
    private Long certId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCertId() {
        return certId;
    }

    public void setCertId(Long certId) {
        this.certId = certId;
    }
}
