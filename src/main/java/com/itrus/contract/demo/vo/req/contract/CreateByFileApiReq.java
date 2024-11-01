package com.itrus.contract.demo.vo.req.contract;


import com.itrus.contract.demo.vo.req.contract.addSignerByFile.FileApiVO;
import com.itrus.contract.demo.vo.req.template.create.WaterMarkBaseVO;
import lombok.Data;

import java.util.List;

/**
 * @author pjw
 */
@Data
public class CreateByFileApiReq  {

    /**
     * 合同编号，如果用户没有传递系统会自动生成合同编号。合同编号不能重复（1-64字符）
     */
    private String code;

    /**
     * 合同名称 1-64字符，支持中文、英文大小写，数字、特殊字符
     */
    private String name;

    /**
     * 签约人数 0-10人，0代表不限制签署人个数。需要调用强制结束接口结束合同签署。
     */
    private Integer signCount;

    /**
     * 签署有效期（天）默认90天。范围1-365天
     */
    private Integer signValidDays;

    /**
     * 是否顺序签署:false无序(默认)、true有序
     */
    private Boolean signSortable;

    /**
     * 是否立即发起合同:false不发起、true立即发起(默认)
     */
    private Boolean send;

    /**
     * 页面同步通知地址;页面签有效
     */
    private String syncUrl;

    /**
     * 后台异步通知地址
     */
    private String asyncUrl;

    /**
     * 最终文件类型 1:PDF 2:OFD
     */
    private Integer lastFileType;

    /**
     * 创建人（发起用户id）（创建人必须实名，并且加入到此企业）
     */
    private String creator;

    /**
     * 发起方企业id
     */
    private String enterpriseId;

    /**
     * 业务类型
     */
    private String bizCode;

    /**
     * 合同文档
     */
    private List<FileApiVO> files;

    /**
     * 是否检查业务类型
     */
    private Boolean checkSysBizType;

}
