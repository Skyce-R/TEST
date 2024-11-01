package com.itrus.contract.demo.vo.req.template.create;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class WaterMarkBaseVO  {

    /**
     * 水印名称
     */
    private String markName;

    /**
     * 水印类型:1文字2图片3二维码
     */
    private Integer markType;

    /**
     * 水印位置:1左上,2右上,3 左下 ,4右下, 5居中,6平铺,7填充(默认1左上)(注意二维码仅支持1左上,2右上,3 左下 ,4右下)
     */
    private Integer position = 1;

    /**
     * 文本水印
     */
    private TextWaterMarkVO pdfTextMarkParams;

    /**
     * 图片水印
     */
    private ImageWaterMarkVO pdfImageMarkParams;

    /**
     * 二维码水印
     */
    private QrWaterMarkVO pdfQrCodeMarkParams;

}
