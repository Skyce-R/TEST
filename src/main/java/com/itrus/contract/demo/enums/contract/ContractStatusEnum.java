package com.itrus.contract.demo.enums.contract;




import java.util.Arrays;
import java.util.List;


public enum ContractStatusEnum  {

    //兼容旧版本：com.itrus.contract.tools.enums.ContractStatusEnum

//    DRAFT(0,"草稿"),
//    WAITING(1,"待签署"),
//    SIGNING(2,"签署中"),
//    FINISH(3,"完成"),
//    EXPIRED(4,"过期"),
//    REVOKE(5,"撤销"),
//    REFUSAL(6,"拒签"),
//
//    RESCIND_SUCCESS(11,"解约成功"),
//    RESCIND_APPLY(12,"申请解约"),
//    RESCIND_FAIL(13,"解约失败"),
//    ;

    RECENT(-1,"最近文件"),
    ALL(99,"全部文件"),
    DRAFT(0,"草稿"),
    UNSIGNED(1,"已发起"),
    SIGNING(2,"签署中"),
    SIGNED(3,"已完成"),
    EXPIRED(4,"已过期"),
    REVOKE(5,"已撤回"),
    DENY(6,"已拒签"),
    WITH_ME(7,"待我签署"),
    WITH_OTHER(8,"代他人签署"),
    ABNORMAL(9,"异常"),
    CC_MINE(10,"抄送我的"),
    RESCINDED(11,"已解约"),
    RESCINDING(12,"解约申请中"),
    ;


    private int index;
    private String description;


    ContractStatusEnum(int index, String description) {
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
