package com.itrus.contract.demo.enums.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 * @date 2022/5/10/0010
 */
@Getter
@AllArgsConstructor
public enum ContractCheckStatusEnum {

    /**
     * 合同状态
     */
    UPLOAD_FILE(0,"上传合同文件"),
    ADD_SIGNERS(1,"添加签署人"),
    SIGN(2,"签署"),
    DOWNLOAD(3,"下载"),
    SEND(4,"发送"),
    REVOKE(5,"撤销"),
    FINISHED(6,"结束"),
    URGE(7,"催签"),
    DELETE(8,"删除"),
    ;

    private final int index;
    private final String description;

}
