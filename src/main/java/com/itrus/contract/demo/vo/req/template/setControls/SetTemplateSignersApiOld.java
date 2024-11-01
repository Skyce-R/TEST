package com.itrus.contract.demo.vo.req.template.setControls;

import lombok.Data;
import java.util.List;

/**
 * @author pjw
 */
@Data
public class SetTemplateSignersApiOld  {

    /**
     * 模板签署方（角色与签署人类型要匹配）
     */
    private String signerRole;

    /**
     * 签署方类型
     */
    private Integer signerType;

    /**
     * 文档控件
     */
    private List<TemplateSignFileApiOld> signFiles;

}
