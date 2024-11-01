package com.itrus.contract.demo.vo.req.template.create;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class QrWaterMarkVO {

    /**
     * 二维码宽度,默认100px
     */
    private Float qrCodeWidth = 100.0F;
    /**
     *二维码高度,默认100px
     */
    private Float qrCodeHeight = 100.0F;
    /**
     * 二维码查看范围(0:公开文档;1:文件参与人与管理员可查看)
     */
    private Integer viewRange = 1;

    /**
     * 页面范围(V4.3.3增加)
     * 格式：“1~5,8,-3~-1”，
     * 说明如下：
     * 0：所有页（默认）
     * 1~5：第1页至第5页
     * -3~-1：倒数第3页至倒数第1页
     */
    private String pages = "0";

}
