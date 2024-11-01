package com.itrus.contract.demo.enums.signet;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
public enum TimePatternTypeEnum {

    /**
     * 时间戳格式
     */
    STANDARD_DAY(1, "yyyy-MM-dd"),
    STANDARD_TIME(2, "yyyy-MM-dd hh:mm:ss"),
    STANDARD_DAY_WITH_CHINESE(3, "yyyy年MM月dd日"),
    STANDARD_TIME_WITH_CHINESE(4, "yyyy年MM月dd日 hh时mm分ss秒"),
    ;

    private final int index;
    private final String description;

    public int getIndex() {
        return index;
    }

    TimePatternTypeEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
