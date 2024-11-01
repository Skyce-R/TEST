package com.itrus.contract.demo.vo.req.contract.signByFile;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class TextControlsFontVO {

    /**
     * 模板文本控件key
     */
    private String controlsKey;

    /**
     * 文本控件id不能为空
     */
    private Long controlsId;

    /**
     * 字体类型:1宋体、2楷体、3黑体、4微软雅黑、
     */

    private Integer fontType;

    /**
     * 字体大小(字号)
     */
    private Float fontSize;

    /**
     * 字体颜色
     */
    private String fontColor;

    /**
     * 文本水平对齐方式 0:左对齐、1:居中对齐、2:右对齐,默认:0
     * 仅文本域支持
     */
    private Integer alignment;

    /**
     * 文本垂直对齐方式 0:顶部对齐、1居中对齐、2:底部对齐,默认:0,仅文本域支持
     */
    private Integer verticalAlignment;

    /**
     * 是否单行显示,若为true则该控件文本单行自适应,否则多行自适应
     */
    private Boolean singleLine;

}
