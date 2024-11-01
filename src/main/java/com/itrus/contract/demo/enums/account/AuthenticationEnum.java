package com.itrus.contract.demo.enums.account;


/**
 * @author pjw
 */
public enum AuthenticationEnum {

    /**
     * 账号类型
     */
    THIRD(true, "第三方实名"),
    ITRUS(false, "天威实名"),
    ;

    private final Boolean index;
    private final String description;

    public Boolean getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    AuthenticationEnum(Boolean index, String description) {
        this.index = index;
        this.description = description;
    }
}
