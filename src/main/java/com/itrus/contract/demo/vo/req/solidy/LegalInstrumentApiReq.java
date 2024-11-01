package com.itrus.contract.demo.vo.req.solidy;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: meng
 * @Description: 查询法律文书入参
 * @Date: Create in 16:48 2020/10/22 0022
 */
@Getter
@Setter
public class LegalInstrumentApiReq {

    /**
     * 企业id
     */
    private String enterpriseId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 法律文书类型
     */
    private Integer legalInstrumentType;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页大小
     */
    private Integer pageSize;
    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;
    /**
     * 申请人类型
     */
    private Integer applicantType;

}
