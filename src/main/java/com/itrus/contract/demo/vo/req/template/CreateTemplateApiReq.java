package com.itrus.contract.demo.vo.req.template;


import com.itrus.contract.demo.vo.req.template.create.AddTemplateSignerApiVO;
import com.itrus.contract.demo.vo.req.template.create.WaterMarkBaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author pjw
 */
@Setter
@Getter
public class CreateTemplateApiReq   {

    /**
     * 模板编号，如果用户没有传递系统会自动生成模板编号。模板编号不能重复（1-32字符）
     */
    private String code;

    /**
     * 模板名称 1-64字符，支持中文、英文大小写，数字、特殊字符
     */
    private String name;

    /**
     * 模板合同文档名称1-64字符，支持中文、英文大小写，数字、特殊字符
     */
    private String docName;

    /**
     * 模板创建者
     */
    private String creator;

    /**
     * 模板创建企业
     */
    private String enterpriseId;

    /**
     * 业务分类
     */
    private String bizCode = "common";

    /**
     * 模板分类节点编号，不传该参数，则模板默认归属为默认分类节点
     */
    private String nodeCode;

    /**
     * 模板合同文件base64，最大不超过5MB，支持pdf/doc/docx文件格式
     */
    private String base64;

    /**
     * 签署有效期（天）默认180天。范围1-365天。当未传该参数时，看业务类型是否已设置，如未设置，则取业务类型中设置的签署有效期；
     */
    private Integer validDays;

    /**
     * 是否顺序签署:false无序（默认）、true有序
     */
    private Boolean signSortable;

    /**
     * 模板签署方
     */
    private List<AddTemplateSignerApiVO> signers;

    /**
     * 合同终版文件类型：1PDF（默认）,2OFD；当该参数未传时，取业务类型中设置的合同终版文件类型，若业务类型中也未设置，则取系统默认设置（PDF）类型
     */
    private Integer lastFileType;

    /**
     * 页面同步通知地址;页面签有效
     */
    private String syncUrl;

    /**
     * 后台异步通知地址;页面签有效
     */
    private String asyncUrl;

    /**
     * 扩展数据
     */
    private String extendData;

    /**
     * 是否需要签署:0不需要、1需要
     */
    private Boolean needSign = true;

    /**
     * html文件base64
     */
    private String htmlBase64;

    /**
     * 是否开启水印(0:不开启;1:开启)
     */
    private Boolean waterMarkOff = false;

    /**
     * 水印集合设置参数
     */
    private List<WaterMarkBaseVO> waterMarkParams;

}
