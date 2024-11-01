package com.itrus.contract.demo.other;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.utils.crypto.HmacSha1Util;
import com.itrus.contract.demo.utils.log.DebugUtils;
import org.junit.Test;

/**
 * 公共接口
 * @author pjw
 * @date 2022/9/25/0025
 */
public class PublicTest extends BaseTest {

    /**
     * 获取合同列表
     */
    @Test
    public void monitor() {
        String apiUrl = "/monitor";
        JSONObject requestJson = JSONUtil.createObj()
                ;
        sendPost(apiUrl, requestJson);
    }

    /**
     * 获取合同列表
     */
    @Test
    public void monitor2() {
        String apiUrl = "http://127.0.0.1:9001/apigate/uc/pc/productList";
//        String apiUrl = "http://192.168.101.159/apigate/platform-uc/portal/authority/role/getByRoleId";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("displayName", "pjw")
                ;
        sendPost2(apiUrl, requestJson);
    }

    public JSONObject sendPost2(String url, JSONObject requestJson) {
        Console.log("sendPostUrl: {}", url);
        Console.log("request: {}", DebugUtils.reduce(requestJson));

        String response = HttpRequest.post(url)
                .header("Content-Signature", "HMAC-SHA1 " + HmacSha1Util.getSignature(requestJson.toString(), configUtil.getServiceKye() + configUtil.getServiceCode()))
                .header("appId", configUtil.getAppId())
                .header("serviceCode", configUtil.getServiceCode())
                .header("Accept", "application/json; charset=utf-8")
                .header("companyUUID", configUtil.getCompanyUuid())
                .contentType("application/json;charset=UTF-8")
                .body(requestJson.toString())
                .execute().body();

        JSONObject responseJson = JSONUtil.parseObj(response);
        Console.log("response: {}", DebugUtils.reduce(responseJson));

        return responseJson;
    }

    @Test
    public void test() {
        long count = 1000;
        int pages = 1, page = 1;
        if (count > 100) {
            pages = (int) count / 100;
            if ((int)count % 100 > 0) {
                pages++;
            }
            page = RandomUtil.randomInt(1, pages + 1);
        }
        System.out.println("pages:" + pages);
        System.out.println("page:" + page);
    }

}
