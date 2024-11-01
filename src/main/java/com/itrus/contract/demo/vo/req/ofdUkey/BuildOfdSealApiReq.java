package com.itrus.contract.demo.vo.req.ofdUkey;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class BuildOfdSealApiReq {

    /**
     * 签章id
     */
    private Long signatureId;

    /**
     * 签署完成的hash
     */
    private String signedHash;

}
