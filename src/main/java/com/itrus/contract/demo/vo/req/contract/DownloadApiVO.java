package com.itrus.contract.demo.vo.req.contract;

import lombok.Data;
import java.util.List;

/**
 * @author pjw
 */
@Data
public class DownloadApiVO {

    /**
     * 下载类型  1 单个 2 批量
     */
    private Integer type;

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同id集合 type为2时必填
     */
    private List<Long> contractIds;

}
