package com.itrus.contract.demo.vo.resp.signet;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
public class CreateStampResp {

    private Long autographId;
    private String base64;

    public Long getAutographId() {
        return autographId;
    }

    public void setAutographId(Long autographId) {
        this.autographId = autographId;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
