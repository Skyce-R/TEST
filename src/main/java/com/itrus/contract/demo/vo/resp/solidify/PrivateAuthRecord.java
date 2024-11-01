package com.itrus.contract.demo.vo.resp.solidify;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 私钥授权记录
 * @author pjw
 * @date 2022/10/30/0030
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PrivateAuthRecord {

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 签署人类型
     */
    private Integer signerType;

    /**
     * 意愿认证编号
     */
    private Long intentionId;

    /**
     * 授权方式
     */
    private Integer authorizationMethod;

    /**
     * 授权内容
     */
    private String authorizationContent;

    /**
     * 授权结果，0 失败，1 成功
     */
    private Boolean authorizationResult;

    /**
     * 授权时间
     */
    private LocalDateTime authorizationTime;

}
