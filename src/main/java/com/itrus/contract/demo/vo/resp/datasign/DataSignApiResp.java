package com.itrus.contract.demo.vo.resp.datasign;

import com.itrus.contract.demo.vo.resp.template.DocumentApiVO;

import java.time.LocalDateTime;
import java.util.List;

public class DataSignApiResp {

    /**
     * 签名记录id
     */
    private Long signRecordCode;
    /**
     * 签名值,字符串Base64
     */
    private String signValue;
    /**
     * 证书申请状态: 1:新证书的申请   2:新更新的证书   3:使用原有的证书
     */
    private Integer certApplyStatus;
    /**
     * 证书编号
     */
    private String certCode;
    /**
     * 证书生效时间,格式:yyyy-MM-dd HH:mm:ss
     */
    private String certEffectTime;
    /**
     * 证书过期时间,格式:yyyy-MM-dd HH:mm:ss
     */
    private String certExpireTime;


    public Long getSignRecordCode() {
        return signRecordCode;
    }

    public void setSignRecordCode(Long signRecordCode) {
        this.signRecordCode = signRecordCode;
    }

    public String getSignValue() {
        return signValue;
    }

    public void setSignValue(String signValue) {
        this.signValue = signValue;
    }

    public Integer getCertApplyStatus() {
        return certApplyStatus;
    }

    public void setCertApplyStatus(Integer certApplyStatus) {
        this.certApplyStatus = certApplyStatus;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getCertEffectTime() {
        return certEffectTime;
    }

    public void setCertEffectTime(String certEffectTime) {
        this.certEffectTime = certEffectTime;
    }

    public String getCertExpireTime() {
        return certExpireTime;
    }

    public void setCertExpireTime(String certExpireTime) {
        this.certExpireTime = certExpireTime;
    }
}