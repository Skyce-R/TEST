package com.itrus.contract.demo.vo.req.enterprise;


import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2022/10/30/0030
 */
@Setter
@Getter
public class OrgListApiReq  {

    /**
     * 创建开始时间 yyyy-MM-dd HH:mm:ss
     */
    private String startTime;

    /**
     * 结束时间 yyyy-MM-dd HH:mm:ss
     */
    private String endTime;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 社会统一信用代码
     */
    private String socialCode;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 条数 最大50
     */
    private Integer pageSize;

}
