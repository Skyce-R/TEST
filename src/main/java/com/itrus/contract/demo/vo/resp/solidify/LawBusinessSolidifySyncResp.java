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
public class LawBusinessSolidifySyncResp {
    /**
     * 业务固化数据
     */
    private LawBusinessSolidifyVO lawBusinessSolidifyVO;

    /**
     * 主体固化数据
     */
    private List<LawSubjectSolidifyVO> solidifyVO;

    /**
     * 授权记录
     */
    private List<PrivateAuthRecord> authorizationRecord;



}
