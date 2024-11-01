package com.itrus.contract.demo.vo.resp.solidify;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: fujp
 * @Date: 2023/2/3 14:56
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObtainEvidenceReportResp {
    /**
     * 当前的状态
     */
    private String stage;
    /**
     * 一般为一组文件,自动压缩为base64编码zip文件。
     */
    private String pdf;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 取证报告名称
     */
    private String fileName;
    /**
     * 错误消息
     */
    private String errorMsg;

}