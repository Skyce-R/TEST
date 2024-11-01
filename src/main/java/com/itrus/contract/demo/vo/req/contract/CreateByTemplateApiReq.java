package com.itrus.contract.demo.vo.req.contract;

import com.itrus.contract.demo.vo.req.contract.createByTemplate.TemplateFileApiVO;
import lombok.Data;

import java.util.List;

/**
 * @author pjw
 */
@Data
public class CreateByTemplateApiReq {

    /**
     * 合同编号，如果用户没有传递系统会自动生成合同编号。合同编号不能重复（1-64字符）
     */
    private String code;

    /**
     * 合同名称 1-64字符，支持中文、英文大小写，数字、特殊字符，如果业务类型未设置合同名称策略，则合同名称必传；如业务类型已设置合同名称策略，则该参数可以不传，系统自动按照业务类型设置的合同名称策略生成合同名称
     */
    private String name;

    /**
     * 模板编号
     */
    private String templateCode;

    /**
     * 创建人（发起用户id）（创建人必须实名，并且加入到此企业）
     */
    private String creator;

    /**
     * 合同发起方企业id
     */
    private String enterpriseId;

    /**
     * 合同文件
     */
    private List<TemplateFileApiVO> docList;

    /**
     * 页面同步通知地址;页面签有效
     */

    private String syncUrl;

    /**
     * 后台异步通知地址;页面签有效
     */
    private String asyncUrl;

}
