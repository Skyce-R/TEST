package com.itrus.contract.demo.vo.resp.solidify;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 9:40 2020/10/23 0023
 */
@Getter
@Setter
public class LegalInstrumentResp {
    

    /**
     * 总数
     */
    private Long totalRecord;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页个数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 法律文书
     */
    private List<ApplyEvidenceResp> list;


}
