package com.itrus.contract.demo.web;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseWebTest;
import org.junit.Test;

/**
 * 合同相关webapi
 * @author pjw
 * @date 2022/11/4/0004
 */
public class ContractTest extends BaseWebTest {

    @Test
    public void loginTest() {
        super.login();
    }

    /**
     * 合同列表
     */
    @Test
    public void contractList() {
        String apiUrl = "/contract/findList";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("status", 1)
                .putOpt("dataSource", 1)
                .putOpt("pageNumber", 1)
                .putOpt("pageSize", 10)
                ;
        sendWebPost(apiUrl, requestJson, 2);
    }

}
