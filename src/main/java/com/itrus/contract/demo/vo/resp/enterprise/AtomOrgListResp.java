package com.itrus.contract.demo.vo.resp.enterprise;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author pjw
 * @date 2022/10/30/0030
 */
@Setter
@Getter
public class AtomOrgListResp {

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 企业信息列表
     */
    private List<GetCompanyResp> companyList;

}
