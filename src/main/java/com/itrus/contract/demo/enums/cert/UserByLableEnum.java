package com.itrus.contract.demo.enums.cert;


public enum UserByLableEnum {
    TRUE(1,"使用默认标签"),
    FALSE(0,"不使用默认标签"),
    ;

    private int index;
    private String description;

    UserByLableEnum(int index, String description) {
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
