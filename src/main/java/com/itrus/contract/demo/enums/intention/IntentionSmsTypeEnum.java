package com.itrus.contract.demo.enums.intention;






public enum IntentionSmsTypeEnum {

    /**
     * 认证方式
     */
    TEXT(1, "文本验证"),
    VOICE(2, "语音验证"),
    TEXT_VOICE(3, "文本+语音验证"),
    ;

    private final int index;
    private final String description;


    IntentionSmsTypeEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}
