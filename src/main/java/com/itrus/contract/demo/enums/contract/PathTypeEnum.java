package com.itrus.contract.demo.enums.contract;

/**
 * @author pjw
 * @date 2023/8/29/0029
 */
public enum PathTypeEnum {

    /**
     * 路径类型
     */
    PERSON(1, "ftp路径(默认)"),
    ENTERPRISE(2, "http路径"),
    ;

    private final int index;
    private final String description;

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    PathTypeEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }
}
