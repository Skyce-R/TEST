package com.itrus.contract.demo.vo.req.pagesign;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 */
@Getter
@Setter
public class PageSignReq {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 签署人
     */
    private AddContractSignerVO signer;

    /**
     * 签署类型：1 页面云端签署 2 页面ukey签署
     */
    private Integer signType = 1;

    /**
     * 链接有效期,单位分钟;默认30分钟,最小5分钟, 最大60*24分钟(24小时)
     */
    private Integer expire = 30;

    /**
     * 同步地址
     */
    private String syncUrl;

    /**
     * 异步地址
     */
    private String asyncUrl;

}
