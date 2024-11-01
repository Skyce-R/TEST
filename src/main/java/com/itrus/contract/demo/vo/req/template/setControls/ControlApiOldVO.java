package com.itrus.contract.demo.vo.req.template.setControls;

import lombok.Data;

/**
 * @author pjw
 */
@Data
public class ControlApiOldVO {

    /**
     * 控件id，不可重复
     */
    private Integer id;

    /**
     * 控件类型
     * autograph:签名类型，个人控件
     * signet:印章类型，企业控件
     * text:文本类型， value为要填写的文本内容
     * date:日期类型，非必传， 系统会取当前系统时间来填写，传值的话，value为空即可
     * pic:图片类型
     */
    private String type;

    /**
     * 控件宽(单位:cm),印章、图片控件,可不填,默认为图片的宽度
     */
    private Float width;

    /**
     * 控件高(单位:cm),印章、图片控件,可不填,默认为图片的高度
     */
    private Float height;

    /**
     * 控件key：模板补充变量时必填
     */
    private String key;

    /**
     * 控件值
     */
    private String value;

}
