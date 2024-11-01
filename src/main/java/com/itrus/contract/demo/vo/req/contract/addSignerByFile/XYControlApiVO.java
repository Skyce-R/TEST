package com.itrus.contract.demo.vo.req.contract.addSignerByFile;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author pjw
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class XYControlApiVO extends ControlApiVO {

    /**
     * 签章页码范围，格式：“1~5,8,-3~-1”，说明如下：0：所有页（默认）,1~5：第1页至第5页,-3~-1：倒数第3页至倒数第1页
     */
    private String pageNum;

    /**
     * 签署控件x坐标,pdf位置比例
     */
    private Float x;

    /**
     * 签署控件y坐标,pdf位置比例
     */
    private Float y;


    public XYControlApiVO() {
    }

    public XYControlApiVO(Integer id, String type, String pageNum, Float x, Float y, Float width, Float height) {
        super.setId(id);
        super.setType(type);
        super.setWidth(width);
        super.setHeight(height);
        this.pageNum = pageNum;
        this.x = x;
        this.y = y;
    }

}
