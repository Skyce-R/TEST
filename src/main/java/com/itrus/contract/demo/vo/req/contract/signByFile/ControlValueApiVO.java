package com.itrus.contract.demo.vo.req.contract.signByFile;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pjw
 */
@Data
@NoArgsConstructor
public class ControlValueApiVO {

    /**
     * 控件ID
     */
    private Long controlsId;

    /**
     * 证书ID
     */
    private Long certId;

    /**
     * 签名ID
     */
    private Long stampId;

    /**
     * 印章ID
     */
    private Long sealId;

    /**
     * 签名、印章图片
     */
    private String imageBase64;

    /**
     * 文本
     */
    private String text;

    public ControlValueApiVO(Long controlsId, Long id) {
        this.controlsId = controlsId;
        this.stampId = id;
        this.sealId = id;
    }

}
