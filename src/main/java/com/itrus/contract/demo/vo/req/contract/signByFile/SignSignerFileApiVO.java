package com.itrus.contract.demo.vo.req.contract.signByFile;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author pjw
 */
@Data
public class SignSignerFileApiVO {

    /**
     * 合同文档id
     */
    private Long docId;

    /**
     * 控件参数值
     */
    private List<ControlValueApiVO> controlValues;

    /**
     * 印章、签名控件下方是否加盖时间戳,默认false不显示
     */
    private Boolean showTimestamp;

    /**
     * 印章、签名控件时间戳参数,当showTimestamp为true时,此参数必填
     */
    private SealTimestampApiVO sealTimestamp;

    /**
     * 文本控件字体属性
     */
    private List<TextControlsFontVO> fonts;

    /**
     * 控件参数值
     */
    private Map<String, String> signControl;

}
