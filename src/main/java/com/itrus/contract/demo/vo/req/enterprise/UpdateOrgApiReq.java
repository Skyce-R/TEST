package com.itrus.contract.demo.vo.req.enterprise;


import lombok.Getter;
import lombok.Setter;

/**
 * 企业信息VO
 * @author pjw
 * @date 2022/4/29/0029
 */
@Setter
@Getter
public class UpdateOrgApiReq  {

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 企业名称
     */
    private String orgName;

    /**
     * 企业标签
     */
    private String enterpriseLabel;

}
