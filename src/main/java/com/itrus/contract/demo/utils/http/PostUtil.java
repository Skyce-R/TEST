package com.itrus.contract.demo.utils.http;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.utils.config.ConfigUtil;
import com.itrus.contract.demo.utils.crypto.HmacSha1Util;
import com.itrus.contract.demo.utils.log.DebugUtils;

/**
 * @author pjw
 * @date 2023/9/13/0013
 */
public class PostUtil extends HttpRequest {

    public PostUtil(UrlBuilder url) {
        super(url);
    }

    public static JSONObject toPost(String baseUrl, String url, String req) {
        PostUtil postUtil = new PostUtil(UrlBuilder.of(baseUrl + url));
        return postUtil.sendPost(req);
    }

    public JSONObject sendPost(String req) {
        ConfigUtil configUtil = Singleton.get(ConfigUtil.class);

        this.setMethod(Method.POST);
        this.header("Content-Signature", "HMAC-SHA1 " + HmacSha1Util.getSignature(req, configUtil.getServiceKye() + configUtil.getServiceCode()));
        this.header("appId", configUtil.getAppId());
        this.header("serviceCode", configUtil.getServiceCode());
        this.header("Accept", "application/json; charset=utf-8");
        this.header("companyUUID", configUtil.getCompanyUuid());
        this.contentType("application/json;charset=UTF-8");
        this.body(req);

        Console.log("sendPostUrl: {}", this.getUrl());
        Console.log("header: {}", JSONUtil.parse(this.headers));
        Console.log("request: {}", DebugUtils.reduce(JSONUtil.parseObj(req)));

        String response = this.execute().body();

        JSONObject responseJson = null;
        try {
            responseJson = JSONUtil.parseObj(response);
        } catch (Exception e) {
            Console.log("response: {}", response);
        }
        Console.log("response: {}", DebugUtils.reduce(responseJson));

        return responseJson;
    }

    public JSONObject sendPost(String req, String appId, String appSecret, String serviceCode) {
        ConfigUtil configUtil = Singleton.get(ConfigUtil.class);

        this.setMethod(Method.POST);
        this.header("Content-Signature", "HMAC-SHA1 " + HmacSha1Util.getSignature(req, appSecret + serviceCode));
        this.header("appId", appId);
        this.header("serviceCode", serviceCode);
        this.header("Accept", "application/json; charset=utf-8");
        this.header("companyUUID", configUtil.getCompanyUuid());
        this.contentType("application/json;charset=UTF-8");
        this.body(req);

        Console.log("sendPostUrl: {}", this.getUrl());
        Console.log("header: {}", JSONUtil.parse(this.headers));
        Console.log("request: {}", DebugUtils.reduce(JSONUtil.parseObj(req)));

        String response = this.execute().body();

        JSONObject responseJson = null;
        try {
            responseJson = JSONUtil.parseObj(response);
        } catch (Exception e) {
            Console.log("response: {}", response);
        }
        Console.log("response: {}", DebugUtils.reduce(responseJson));

        return responseJson;
    }

}
