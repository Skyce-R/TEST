package com.itrus.contract.demo.vo.req;

import com.itrus.contract.demo.vo.req.contract.ApiNullifyContractReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author pjw
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiLaunchNullifyContractReq extends ApiNullifyContractReq {

    /**是否通知解约方，true=通知、false=不通知（默认）**/
    private boolean notice;

}
