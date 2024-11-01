package com.itrus.contract.demo.vo.resp.enterprise;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : peigen
 * Date: 2021/8/10 上午11:57
 */
public class GetCompanyResp {

    /**
     * 企业名称
     */
    private String orgName;

    /**
     * 企业简称
     */
    private String orgAlias;

    /**
     * 企业类型
     */
    private String orgType;

    /**
     * 所属渠道标识
     */
    private String channelUuid;

    /**
     * 是否是渠道商
     */
    private Boolean channel;

    /**
     * 企业唯一标识
     */
    private String companyUuid;

    /**
     * 企业状态
     * 0 未激活
     * 1 正常（默认）
     * 2 挂起
     */
    private String status;

    /**
     * 主管理员唯一标识
     */
    private String creatorUuid;

    /**
     * 销售名称
     */
    private String sellerName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 实名结果
     */
    private String companyRole;

    /**
     * 第三方企业唯一标识
     */
    private String thirdUniqueId;

    /**
     * 实名类型
     */
    private Integer authType;

    /**
     * 实名结果
     */
    private Integer authResult;

    private String logoId;

    /**
     * 企业实名信息
     */
    private Object authInfo;

    /**
     * 账号信息
     */
    private Object accountInfo;

    /**
     * 账号在企业下信息
     */
    private Object companyUserInfo;

    /**
     * 企业基本信息，为兼容诚信签增加
     */
    private Object companyInfo;

    /**
     * 管理员账号信息，为兼容诚信签增加
     */
    private Object managerInfo;

    /**
     * 企业基本信息，为兼容诚信签增加
     */
    private Object companyBaseInfo;

    /**
     * 三方系统 唯一标识
     */
    private List<Object> companyThirdExtResps;

    /**
     * 联行号
     */
    private String interbankNo;


    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgAlias() {
        return orgAlias;
    }

    public void setOrgAlias(String orgAlias) {
        this.orgAlias = orgAlias;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getChannelUuid() {
        return channelUuid;
    }

    public void setChannelUuid(String channelUuid) {
        this.channelUuid = channelUuid;
    }

    public Boolean getChannel() {
        return channel;
    }

    public void setChannel(Boolean channel) {
        this.channel = channel;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatorUuid() {
        return creatorUuid;
    }

    public void setCreatorUuid(String creatorUuid) {
        this.creatorUuid = creatorUuid;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }

    public String getThirdUniqueId() {
        return thirdUniqueId;
    }

    public void setThirdUniqueId(String thirdUniqueId) {
        this.thirdUniqueId = thirdUniqueId;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public Integer getAuthResult() {
        return authResult;
    }

    public void setAuthResult(Integer authResult) {
        this.authResult = authResult;
    }

    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    public Object getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(Object authInfo) {
        this.authInfo = authInfo;
    }

    public Object getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(Object accountInfo) {
        this.accountInfo = accountInfo;
    }

    public Object getCompanyUserInfo() {
        return companyUserInfo;
    }

    public void setCompanyUserInfo(Object companyUserInfo) {
        this.companyUserInfo = companyUserInfo;
    }

    public Object getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(Object companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Object getManagerInfo() {
        return managerInfo;
    }

    public void setManagerInfo(Object managerInfo) {
        this.managerInfo = managerInfo;
    }

    public Object getCompanyBaseInfo() {
        return companyBaseInfo;
    }

    public void setCompanyBaseInfo(Object companyBaseInfo) {
        this.companyBaseInfo = companyBaseInfo;
    }

    public List<Object> getCompanyThirdExtResps() {
        return companyThirdExtResps;
    }

    public void setCompanyThirdExtResps(List<Object> companyThirdExtResps) {
        this.companyThirdExtResps = companyThirdExtResps;
    }

    public String getInterbankNo() {
        return interbankNo;
    }

    public void setInterbankNo(String interbankNo) {
        this.interbankNo = interbankNo;
    }
}
