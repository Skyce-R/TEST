package com.itrus.contract.demo.enums.signet;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
public enum ControlAlignmentTypeEnum {

    /**
     * 签名字体
     */
    LEFT(0, "左对齐"),
    MID(1, "居中对齐"),
    RIGHT(2, "右对齐"),
    ;

    private final int index;
    private final String description;

    public int getIndex() {
        return index;
    }

    ControlAlignmentTypeEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
