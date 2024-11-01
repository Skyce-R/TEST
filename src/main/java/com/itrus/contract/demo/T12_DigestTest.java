package com.itrus.contract.demo;

import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.vo.req.datasign.DataSignReq;
import com.itrus.contract.demo.vo.req.datasign.DigestVerifyReq;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.datasign.DataSignApiResp;
import org.junit.Test;

/**
 * 十二、数据签名接口
 * @author pjw
 * @date 2022/8/12/0012
 */
public class T12_DigestTest extends BaseTest {

    /**
     * 12.1、P7签名
     */
    @Test
    public void dataSign() {
        DataSignReq dataSignReq = new DataSignReq();
        dataSignReq.setTitle("标题");
        dataSignReq.setContent("待签名数据");
        dataSignReq.setDigestType(1);
        dataSignReq.setUserId("M01RSYLDEXH5UG");
        dataSignReq.setEnterpriseId("M0114PLTSSH8YLO");
        dataSignReq.setSignerType(2);
        dataSignReq.setDesireType(true);

        BaseResp<DataSignApiResp> resp = sendPost(ApiUrl.DATA_SIGN, JSONUtil.parseObj(dataSignReq), new DataSignApiResp());
        if (isOk(resp)) {
            DataSignApiResp data = resp.getData();
            profile.put(signRecordCode, data.getSignRecordCode());
            profile.put(signValue, data.getSignValue());
            profile.put(content, dataSignReq.getContent());
            saveProFile();
        }
    }

    /**
     * 12.2、P7验签
     */
    @Test
    public void digestVerify() {
        DigestVerifyReq digestVerifyReq = new DigestVerifyReq();
        digestVerifyReq.setSignRecordCode(Long.valueOf(profile.getProperty(signRecordCode)));
        digestVerifyReq.setSignValue(profile.getProperty(signValue));
        digestVerifyReq.setContent(profile.getProperty(content));

        sendPost(ApiUrl.DIGEST_VERIFY, JSONUtil.parseObj(digestVerifyReq), new DataSignApiResp());
    }

}
