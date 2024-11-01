package com.itrus.contract.demo.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;

import java.net.HttpCookie;

/**
 * @author pjw
 * 日期 2021/2/5 0005
 */
public class ItrusCloudHttpWebUtil {

    public static HttpResponse post(String url, JSONObject requestJson, String platformType, String appCode, String companyUuid, String token, String userId) {
        return HttpRequest.post(url)
                .header("platformType", platformType)
                .header("appCode", appCode)
                .header("companyUUID", companyUuid)
                .cookie(ObjectUtil.isNotEmpty(token)?new HttpCookie("itrustoken", token):null, ObjectUtil.isNotEmpty(userId)?new HttpCookie("useruuid", userId):null)
//                .setProxy(new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1", 8090)))
                .body(requestJson.toString())
                .execute();
    }

    public static HttpResponse formPost(String url, String platformType, String appCode, String companyUuid, String token, String userId, String paramName, String paramValue) {
        return HttpRequest.post(url)
                .header("platformType", platformType)
                .header("appCode", appCode)
                .header("companyUUID", companyUuid)
                .cookie(ObjectUtil.isNotEmpty(token)?new HttpCookie("itrustoken", token):null, ObjectUtil.isNotEmpty(userId)?new HttpCookie("useruuid", userId):null)
                .form(paramName, paramValue)
                .execute();
    }

}
