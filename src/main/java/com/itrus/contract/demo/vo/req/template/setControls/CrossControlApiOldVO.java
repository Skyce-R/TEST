package com.itrus.contract.demo.vo.req.template.setControls;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CrossControlApiOldVO extends ControlApiOldVO {

    /**
     * 签署页
     */
    private String pageNum = "0";

    /**
     * x
     */
    private Float x = 0.90476F;

    /**
     * 签署控件y坐标,印章中心距离文档下边缘的距离(比例)
     */
    private Float y;


    public CrossControlApiOldVO(Float y, String type,Integer id) {
        this.y = y;
        super.setId(id);
        super.setType(type);
    }

}
