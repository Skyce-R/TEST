package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;


/**
 * @author pjw
 * @date 2022/10/26/0026
 */
@Getter
@Setter
public class PageSignUrlApiReq {

    /**
     * 印章id
     * @required
     */
    private Long sealId;


    private Integer expire = 30;

}
