package com.itrus.contract.demo.vo.req.solidy;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * @author pjw
 */
@Getter
@Setter
public class SolidifyReq {
    /**
     * 业务单号
     */
    private String applyOrder;
    /**
     * 企业id 申请人企业id
     */
    private String enterpriseId;
    /**
     * 用户id 申请人用户id
     */
    private String userId;
    /**
     * 合同id集合  只支持一个
     */
    private List<Long> contractIds;
    /**
     * 签署人id集合 v3.2 暂时只支持所有合同签署人
     */
    private List<Long> signerIds;
    /**
     * 法律文书类型(默认见证报告), 支持1、见证报告 2、取证报告3、存证报告(v3.2支持见证报告)
     */
    private Integer legalInstrumentType;
    /**
     * 文件类型 1 hash 2 原文 v3.2只支持hash
     */
    private Integer fileType;
    /**
     * 申请人类型
     */
    private Integer applicantType;
    /**
     *  签署地点
     */
    private String signLocation;

}
