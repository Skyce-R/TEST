package com.itrus.contract.demo.enums.account;

/**
 * @author fjp
 */
public enum StageEnum {

    /**
     * 见证状态
     */
    STAGE_40("40","已受理"),
    STAGE_51("51","复核未通过"),
    STAGE_60("60","人工审核中"),
    STAGE_65("65","证书异常"),
    STAGE_72("72","不出具取证报告"),
    STAGE_79("79","已出具见证报告，此状态会返回见证报告"),
    STAGE_90("90","已撤回"),
    ;

    private final String code;
    private final String name;

    StageEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static StageEnum getNameByCode(String code){
        StageEnum[] values = values();
        for (StageEnum value : values) {
            if(value.getCode().equals(code)){
                return value;
            }
        }
        return null;
    }

}
