package com.itrus.contract.demo.enums.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Getter
@AllArgsConstructor
public enum FilePathTypeEnum {

    /**
     * 路径类型
     */
    FTP(1, "ftp路径"),
    HTTP(2, "http路径"),
    ;

    private final int index;
    private final String description;

}
