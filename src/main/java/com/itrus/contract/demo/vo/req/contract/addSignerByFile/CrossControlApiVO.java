package com.itrus.contract.demo.vo.req.contract.addSignerByFile;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author pjw
 * @date 2022/10/4/0004
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CrossControlApiVO extends ControlApiVO {

    /**
     * 签署页
     */
    private String pageNum = "0";

    /**
     * 签署控件y坐标,印章中心距离文档下边缘的距离(比例)
     */
    private Float y;


    public CrossControlApiVO() {
    }

    public CrossControlApiVO(Integer id,String pageNum, Float y) {
        super.setId(id);
        this.pageNum = pageNum;
        this.y = y;
    }

}
