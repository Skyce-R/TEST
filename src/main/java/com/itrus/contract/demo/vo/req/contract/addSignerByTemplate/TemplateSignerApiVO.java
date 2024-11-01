package com.itrus.contract.demo.vo.req.contract.addSignerByTemplate;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class TemplateSignerApiVO   {

    /**
     * 模板签署方（角色与签署人类型要匹配）
     */
    private String signerRole;

    /**
     * 签署人用户id，签署人可以未实名
     */
    private String userId;

    /**
     * 签署企业D(当签署人为企业时,必填)
     */
    private String enterpriseId;

    /**
     * 是否发送短信通知到诚信签-前置系统签署,false不发送(默认)、true发送
     */
    private Boolean sendMsg;

}
