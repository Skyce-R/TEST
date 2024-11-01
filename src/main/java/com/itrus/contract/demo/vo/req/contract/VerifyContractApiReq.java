package com.itrus.contract.demo.vo.req.contract;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class VerifyContractApiReq {

    /**
     * 验证方式 1合同id验证 2b ase64验证
     */
    private Integer verifyWay;

    /**
     * 合同id 验证方式选合同id,必填,若为base64 则不填
     */
    private Long contractId;

    /**
     * 已签名PDF文档Base64,若验证方式为id验证,此项可不填
     */
    private String base64;

    /**
     * 是否验证批注,验证签章后是否添加批注:true:验证 false:不验证
     */
    private Boolean checkAnnot;

    /**
     * 是否验证吊销列表:true:验证 false:不验证
     */
    private Boolean checkCRL;

    /**
     * 是否验证书颁发者:true:验证 false:不验证
     */
    private Boolean checkIssuer;

}
