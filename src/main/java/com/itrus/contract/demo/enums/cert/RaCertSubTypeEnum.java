package com.itrus.contract.demo.enums.cert;



public enum RaCertSubTypeEnum   {

    RA_LONG(1, "长期证书",1),
    RA_EVENT(2, "事件证书",2);




    private int index;
    private String description;
    private int atomIndex;

    RaCertSubTypeEnum(int index, String description, int atomIndex) {
        this.index = index;
        this.description = description;
        this.atomIndex = atomIndex;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    public int getAtomIndex() {
        return atomIndex;
    }
}
