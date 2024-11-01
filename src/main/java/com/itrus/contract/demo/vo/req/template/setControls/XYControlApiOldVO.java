package com.itrus.contract.demo.vo.req.template.setControls;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author pjw
 * @date 2022/10/4/0004
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class XYControlApiOldVO extends ControlApiOldVO {

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

    private String type;

    public XYControlApiOldVO(String pageNum, Float x, Float y, String type,Integer id) {
        this.pageNum = pageNum;
        this.x = x;
        this.y = y;
        this.type = type;
        super.setId(id);
    }

    public XYControlApiOldVO(Integer id, String key, String pageNum, Float x, Float y, String type, Float width, Float height) {
        this.setId(id);
        this.setKey(key);
        this.pageNum = pageNum;
        this.x = x;
        this.y = y;
        this.type = type;
        this.setWidth(width);
        this.setHeight(height);
    }

}
