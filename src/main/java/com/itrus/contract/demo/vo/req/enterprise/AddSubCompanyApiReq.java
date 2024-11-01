package com.itrus.contract.demo.vo.req.enterprise;


import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2022/10/30/0030
 */
@Setter
@Getter
public class AddSubCompanyApiReq   {

    /**
     * 邀请企业ID
     */
    private String enterpriseId;

    /**
     * 受邀企业ID
     */
    private String subCompanyUuid;

}
