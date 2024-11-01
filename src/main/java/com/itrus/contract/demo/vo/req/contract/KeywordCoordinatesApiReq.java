package com.itrus.contract.demo.vo.req.contract;


public class KeywordCoordinatesApiReq   {
    
    /**
     * 合同id
     */
    private Long contractId;
    /**
     * 文档id
     */
    private Long docId;
    /**
     * 关键字
     */

    private String keyword;
    /**
     * 页码(不填则默认所有)
     */
    private String pageNo;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }
}
