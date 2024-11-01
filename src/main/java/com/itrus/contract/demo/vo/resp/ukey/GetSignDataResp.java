package com.itrus.contract.demo.vo.resp.ukey;


import com.itrus.contract.demo.vo.view.DocumentHashVO;

import java.util.List;

public class GetSignDataResp {

    private List<DocumentHashVO> ukeyHashList;

    public List<DocumentHashVO> getUkeyHashList() {
        return ukeyHashList;
    }

    public void setUkeyHashList(List<DocumentHashVO> ukeyHashList) {
        this.ukeyHashList = ukeyHashList;
    }
}
