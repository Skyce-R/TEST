package com.itrus.contract.demo.vo.req.template.create;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class ImageWaterMarkVO {

    /**
     * 图片文件base64
     */
    private String watermarkFileBase64;

    /**
     * 水印图片
     */
    private String imageFile;

    /**
     * 水印图片放在PDF上的宽度;如果不传,则为水印图片默认宽度;
     */
    private Float width;

    /**
     * 水印图片放在PDF上的高度;如果不传,则为水印图片默认高度;
     */
    private Float height;

    /**
     * 透明度;范围:0至1;0:透明,1:不透明;如果不传,默认为1;如果小于0,默认为0;如果大于1,默认为1;关键字
     */
    private Float opacity = 1F;

    /**
     * 旋转角度;正数:逆时针旋转,负数:顺时针旋转  默认(0°)
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

    /**
     * 水印图片名称
     */
    private String imageName;

}
