package com.itrus.contract.demo.enums.ukey;



public enum UkeyBindOperationEnum   {

    BIND(0, "绑定"),
    UN_BIND(1, "解绑");




    private int index;
    private String description;


    UkeyBindOperationEnum(int index, String description ) {
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
