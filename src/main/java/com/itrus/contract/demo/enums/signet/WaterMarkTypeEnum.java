package com.itrus.contract.demo.enums.signet;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2022/5/10/0010
 */
@Getter
@AllArgsConstructor
public enum WaterMarkTypeEnum {

    /**
     * 水印类型
     */
    TEXT_MARK(1,"文本水印"),
    IMAGE_MARK(2,"图片水印"),
    QRCODE_MARK(3,"二维码水印"),
    TEXT_QRCODE_MARK(4,"文本和二维码水印")
    ;

    private final Integer code;
    private final String name;

}
