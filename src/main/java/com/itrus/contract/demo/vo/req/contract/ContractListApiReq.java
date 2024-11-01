package com.itrus.contract.demo.vo.req.contract;


public class ContractListApiReq   {


    /**
     * 个人用户id
     */
    private String userId;
    /**
     * 企业用户id
     */
    private String enterpriseId;
    /**
     * 业务类型
     */
    private String bizCode;

    /**
     * 合同编号
     */
    private String code;
    /**
     * 合同状态
     * 0草稿,1.待签署,2.签署中,3.已完成,4.已过期,5.已解约,6.已拒签
     */
    private Integer status;
    /**
     * 起始时间
     */
    private Long beginTime;
    /**
     * 结束时间
     */
    private Long endTime;
    /**
     * 页码
     */
    private Integer pageNumber=1;
    /**
     * 每页记录数
     */
    private Integer pageSize=10;

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

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
