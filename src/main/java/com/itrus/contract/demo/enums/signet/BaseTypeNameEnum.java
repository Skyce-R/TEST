package com.itrus.contract.demo.enums.signet;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum BaseTypeNameEnum {

    /**
     * 签名文件类型
     */
    png(".png", "png（默认）"),
    jpg(".jpg", "jpg"),
    jpeg(".jpeg", "jpeg"),
    ;

    private final String index;
    private final String description;

}
