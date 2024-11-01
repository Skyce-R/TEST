package com.itrus.contract.demo.enums.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */

@Getter
@AllArgsConstructor
public enum LastFileTypeEnum   {

    /**
     * 最终文件类型
     */
    PDF(1,"pdf","pdf"),
    OFD(2,"ofd","ofd")
    ;

    private final int index;
    private final String name;
    private final String description;

}
