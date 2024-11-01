package com.itrus.contract.demo.vo.req.contract.addSignerByFile;

import lombok.Data;
import java.util.List;

@Data
public class SignFileApiVO   {

    /**
     * 合同文档id
     */
    private Long docId;

    /**
     * 可选 坐标系类型: 1:左下角为原点,单位为像素(默认) 2:左上角为原点,单位为百分比
     */
    private Integer axisType = 1;

    /**
     * 坐标轴控件
     */
    private List<XYControlApiVO> xySignControls;

    /**
     * 关键字控件
     */
    private List<KeywordControlApiVO> keywordSignControls;

    /**
     * 骑缝章控件
     */
    private List<CrossControlApiVO> crossSignControls;

    public SignFileApiVO() {
    }

    public SignFileApiVO(Long docId, List<XYControlApiVO> xySignControls, List<KeywordControlApiVO> keywordSignControls, List<CrossControlApiVO> crossSignControls) {
        this.docId = docId;
        this.xySignControls = xySignControls;
        this.keywordSignControls = keywordSignControls;
        this.crossSignControls = crossSignControls;
    }

}
