package com.itrus.contract.demo.vo.req.template.setControls;

import lombok.Data;
import java.util.List;

/**
 * @author pjw
 */
@Data
public class TemplateSignFileApiOld  {

    /**
     * 合同文档id
     */
    private Long docId;

    /**
     * 坐标轴控件
     */
    private List<XYControlApiOldVO> xySignControls;

    /**
     * 骑缝章控件
     */
    private List<CrossControlApiOldVO> crossSignControls;

}
