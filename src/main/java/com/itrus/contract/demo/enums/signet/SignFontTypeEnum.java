package com.itrus.contract.demo.enums.signet;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
public enum SignFontTypeEnum {

    /**
     * 签名字体
     */
    SONG(1, "宋体"),
    HUAWEN(2, "华文行楷"),
    HEI(3, "黑体"),
    ;

    private final int index;
    private final String description;

    public int getIndex() {
        return index;
    }

    SignFontTypeEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
