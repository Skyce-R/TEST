package com.itrus.contract.demo.vo.req.ukey;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author pjw
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetSignDataApiReq extends SignByFileApiReq {

    /**
     * 公钥
     */
    private String publicKey;

}
