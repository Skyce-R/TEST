package com.itrus.contract.demo.vo.resp.solidify;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @Author: meng
 * @Description: 主体固化请求参数
 * @Date: Create in 15:47 2020/10/29 0029
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LawSubjectSolidifyVO {
    

    private String templateCode;
    private List<Map<String,Object>> nodeList;
}
