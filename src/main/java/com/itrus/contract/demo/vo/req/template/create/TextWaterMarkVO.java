package com.itrus.contract.demo.vo.req.template.create;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class TextWaterMarkVO {

    /**
     * 文本内容
     */
    private String text;

    /**
     * 文字大小:默认为12
     */
    private Float fontSize = 12F;

    /**
     * 文字颜色 (色号)
     */
    private String color;

    /**
     *透明度;范围:0至1;0:透明,1:不透明;默认为1;
     */
    private Float opacity = 1F;

    /**
     *旋转角度;正数:逆时针旋转,负数:顺时针旋转 默认(0°)
     */
    private Float rotation = 0F;

    /**
     * 页面范围(V4.3.3增加)
     * 格式：“1~5,8,-3~-1”，
     * 说明如下：
     * 0：所有页（默认）
     * 1~5：第1页至第5页
     * -3~-1：倒数第3页至倒数第1页
     */
    private String pages = "0";

}
