package com.itrus.contract.demo.vo.req.signet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
@Setter
@Getter
public class CreateSealReq {

    private String userId;
    private String enterpriseId;
    private Integer sealType;
    private String sealName;
    private String sealBase64;
    private String horizontalText;
    private String lowerText;
    private Integer shape;
    private Integer sealForm;
    private Integer color;
    private Integer alpha;
    private Boolean alphaDeal;
    private Integer width;
    private Integer fontType;
    private Integer status;
    private Integer createSealType;
    private Integer operationMode;
    private Boolean returnBase64;

}
