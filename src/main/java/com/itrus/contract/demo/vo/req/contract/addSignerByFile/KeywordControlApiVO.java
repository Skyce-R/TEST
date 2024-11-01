package com.itrus.contract.demo.vo.req.contract.addSignerByFile;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author pjw
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordControlApiVO extends ControlApiVO {

    /**
     * 签署页
     */
    private String pageNum;

    /**
     * 签署关键字
     */
    private String keyword;

    /**
     * 水平偏移距离(单位cm)
     */
    private Float offsetX = 0f;

    /**
     * 垂直偏移距离(单位cm)
     */
    private Float offsetY = 0f;

    private String type;


    public KeywordControlApiVO() {
    }

    public KeywordControlApiVO(Integer id, String type, String pageNum, String keyword, Float offsetX, Float offsetY) {
        super.setId(id);
        this.pageNum = pageNum;
        this.keyword = keyword;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.type = type;
    }

}
