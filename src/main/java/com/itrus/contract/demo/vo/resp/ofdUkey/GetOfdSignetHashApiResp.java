package com.itrus.contract.demo.vo.resp.ofdUkey;


public class GetOfdSignetHashApiResp  {

    /**
     * 状态:0=系统中存在此印章的ofd文件无需重新生成;1=需要生成ofd签章同时会返回印章的hash需要使用ukey对此hash进行签名
     * @ignore
     */
    private Integer status;

    /**
     * 印章的hash
     */
    private String hash;

    /**
     * 签章id
     * @ignore
     */
    private Long signatureId;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getSignatureId() {
        return signatureId;
    }

    public void setSignatureId(Long signatureId) {
        this.signatureId = signatureId;
    }
}
