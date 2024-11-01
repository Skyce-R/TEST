package com.itrus.contract.demo.vo.resp.signet;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
public class CreateSealResp {

    private Long sealId;
    private String sealName;
    private String base64;

    public Long getSealId() {
        return sealId;
    }

    public void setSealId(Long sealId) {
        this.sealId = sealId;
    }

    public String getSealName() {
        return sealName;
    }

    public void setSealName(String sealName) {
        this.sealName = sealName;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
