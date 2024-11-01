package com.itrus.contract.demo.vo.req.pagesign;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author meng
 * @version 1.0
 * @date 2021/5/11 0011
 * @description
 */
@Getter
@Setter
public class StartSignByFileTemplateRequestVO implements Serializable {
    /**
     * 1 页面云端签署 2 页面ukey签署
     */
    private Integer signType = 1;

    /**
     * 合同id
     */
    private Long contractId;
    /**
     * 合同签署人
     */
    private AddTemplateSignerVO signer;
    /**
     * 链接有效期,单位分钟;默认30分钟,最小5分钟,<br />最大60*24分钟(24小时);
     */
    private Integer expire = 30;

    /**
     * 是否发短信
     * 20231121
     */
    private Boolean sendMsg;


}
