package com.itrus.contract.demo.enums.contract;



/**
 * @author pjw
 * @date 2022/5/10/0010
 */
public enum ContractVerifyWayEnum {

    /**
     * 验证方式 1合同id验证 2b ase64验证
     * @required
     */
    CONTRACT_ID(1,"合同id验证"),
    BASE64(2," base64验证"),
    ;


    private final int index;
    private final String description;

    ContractVerifyWayEnum(int index, String description) {
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
