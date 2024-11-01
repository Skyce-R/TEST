package com.itrus.contract.demo.vo.resp.contract;

import java.util.List;


public class AddSignerApiResp {


    private List<SignerApiVO> signers;

    public List<SignerApiVO> getSigners() {
        return signers;
    }

    public void setSigners(List<SignerApiVO> signers) {
        this.signers = signers;
    }
}
