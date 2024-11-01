package com.itrus.contract.demo.vo.resp.solidify;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 17:01 2020/10/29 0029
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LawBusinessSolidifyVO {
    
    /**
     *业务固化链编码
     */
    private String chainCode;
    /**
     * 客户业务唯一单号
     */
    private String evidenceChainOrderCode;
    /**
     * 请求参数
     */
    private List<Object> nodeList;
}
