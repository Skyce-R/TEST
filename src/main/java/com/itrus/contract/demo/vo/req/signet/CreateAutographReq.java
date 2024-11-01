package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
@Setter
@Getter
public class CreateAutographReq {

    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 签名类型1自定义2图片
     */
    private Integer autographType;

    /**
     * 签名名称(长度1-32字符)
     */
    private String autographName;

    /**
     * 签名图片(签名为图片类型时必选)文件格式:1Jpg2png3jpeg
     */
    private String autographBase64;

    /**
     * 文件后缀名称(印章为图片类型时必选)1Jpg2png3jpeg
     */
    private String baseTypeName;

    /**
     * 签名颜色,1:红色(默认) ,2:绿色 ,3:蓝色 ,4:黑色
     */
    private Integer color;

    /**
     * 签名宽度(38mm-58mm) 默认40
     */
    private Integer width;

    /**
     * 印章透明度(0-10),值越小透明度越大,
     */
    private Integer alpha;

    /**
     * 边框:1有边框(默认)、2没有边框 到时候2会转换成0
     */
    private Integer border;

    /**
     * 签名字体,1:微软雅黑(默认), 2:黑体, 3:宋体,<br/>4:华文行楷, 5:方正舒体(印章类型是自定义时必选)
     */
    private Integer fontType;

    /**
     * 创建印章类型  1:普通印章（默认） 2:OFD印章
     */
    private Integer createStampType;

    /**
     * 是否做透明化处理
     */
    private Boolean limpid;

    /**
     * 操作类型： 0：创建（默认）， 1：预览
     */
    private Integer operationMode;

}
