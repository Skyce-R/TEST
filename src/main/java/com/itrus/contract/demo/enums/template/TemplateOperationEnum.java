package com.itrus.contract.demo.enums.template;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2022/6/2/0002
 */
@Getter
@AllArgsConstructor
public enum TemplateOperationEnum   {

    /**
     * 模板状态
     */
    OPEN(1, "开启"),
    CLOSE(2, "关闭"),
    DELETE(3, "删除")
    ;

    private final int index;
    private final String description;

}
