package com.itrus.contract.demo.vo.req.realName;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Setter
@Getter
public class BranchListReq  {

    /**
     * 城市编号
     */
    private String cityCode;

    /**
     * 银行编号
     */
    private String bankCode;

}
