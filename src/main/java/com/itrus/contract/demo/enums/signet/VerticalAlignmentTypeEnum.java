package com.itrus.contract.demo.enums.signet;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
public enum VerticalAlignmentTypeEnum {

    /**
     * 文本垂直对齐方式 0:顶部对齐、1居中对齐、2:底部对齐,默认:0,仅文本域支持
     */
    TOP(0, "左对齐"),
    MID(1, "居中对齐"),
    RIGHT(2, "右对齐"),
    ;

    private final int index;
    private final String description;

    public int getIndex() {
        return index;
    }

    VerticalAlignmentTypeEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
