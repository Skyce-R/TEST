package com.itrus.contract.demo.vo.req.contract.signByFile;

import lombok.Data;
import java.util.List;

/**
 * @author pjw
 */
@Data
public class SignSignerApiVO {

    /**
     * 签署人ID（添加签署人接口返回）
     */
    private Long signerId;

    /**
     * 是否要做意愿认证;false 否 用户自己做意愿认证, true 是 需要天威诚信做意愿认证;
     */
    private Boolean isUserWishes;

    /**
     * 认证编号
     */
    private String intentionId;

    /**
     * 签署人合同文件参数不能为空
     */
    private List<SignSignerFileApiVO> signFiles;

    /**
     * 签章备注
     */
    private String remark;

}
