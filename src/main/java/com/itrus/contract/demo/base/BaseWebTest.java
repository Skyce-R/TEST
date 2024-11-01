package com.itrus.contract.demo.base;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.utils.ItrusCloudHttpWebUtil;
import com.itrus.contract.demo.utils.log.DebugUtils;
import com.itrus.contract.demo.utils.profile.ProfileUtil;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.Map;

/**
 * @author pjw
 * 日期 2021/2/5 0005
 */
public class BaseWebTest extends BaseTest {

    public static String CONTRACT_WEB = "/contractweb";

    public static String CONTRACT_WE_APP = "/contractweapp";

    public String responseToken = "itrustoken";

    public String responseUserId = "useruuid";

    public String token = "token";


    /**
     * 登录
     * cookie中返回token和userId
     */
    public void login() {
        String apiUrl = "/platform-uc/public/authentication/login";

        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("captcha", "sq4a")
                .putOpt("captchaToken", "2478b962ce320a66d95fc67a3826839c")
                .putOpt("passwd", configUtil.getLoginPassword())
                .putOpt("phone", configUtil.getLoginName())
                .putOpt("type", "namepwd")
                ;
        Console.log(requestJson.toStringPretty());

        HttpResponse httpResponse = ItrusCloudHttpWebUtil.post(
                configUtil.getBaseUCUrl() + apiUrl,
                requestJson,
                configUtil.getPlatformType(),
                configUtil.getAppCode(),
                configUtil.getCompanyUuid(),
                null,
                null);

        HttpCookie tokenCookie = httpResponse.getCookie(responseToken);
//        HttpCookie userIdCookie = httpResponse.getCookie(responseUserId);

        requestJson.putOpt(token, tokenCookie.getValue());
        requestJson.putOpt(managerId, configUtil.getSuperManagerId());
        try {
            ProfileUtil.save(profileName, JSONUtil.toBean(requestJson, Map.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Console.log(JSONUtil.parseObj(httpResponse.body()).toStringPretty());
    }

    /**
     *
     */
    public void loadUserAuthority() {
        String apiUrl = CONTRACT_WEB + "/loadUserAuthority";

        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("companyUuid", configUtil.getCompanyUuid())
                .putOpt("type", "company")
                ;
        Console.log(requestJson.toStringPretty());

        sendWebPost(apiUrl, requestJson, 1);
    }

    public HttpResponse sendWebPost(String apiUrl, JSONObject requestJson) {
        return ItrusCloudHttpWebUtil.post(
                configUtil.getBaseWebUrl() + apiUrl,
                requestJson,
                configUtil.getPlatformType(),
                configUtil.getAppCode(),
                configUtil.getCompanyUuid(),
                profile.getProperty(token),
                profile.getProperty(managerId));
    }

    public HttpResponse sendWebPost(String apiUrl, JSONObject requestJson, Integer userType) {
        Console.log("request: {}", DebugUtils.reduce(requestJson));
        HttpResponse execute = HttpRequest.post(configUtil.getBaseWebUrl() + apiUrl)
                .header("platformType", configUtil.getPlatformType())
                .header("appCode", configUtil.getAppCode())
                .header("companyUUID", userType == 1 ? null : configUtil.getCompanyUuid())

                .header("userUUID", configUtil.getSuperManagerId())
                .header("phone", configUtil.getLoginName())
                .header("requestId", "123")

//                .cookie(ObjectUtil.isNotEmpty(token)?new HttpCookie("itrustoken", token):null, ObjectUtil.isNotEmpty(userId)?new HttpCookie("useruuid", userId):null)
                .cookie(ObjectUtil.isNotEmpty(profile.getProperty(token)) ? new HttpCookie("itrustoken", profile.getProperty(token)) : null, ObjectUtil.isNotEmpty(profile.getProperty(managerId)) ? new HttpCookie("useruuid", profile.getProperty(managerId)) : null)
                .body(requestJson.toString())
                .execute();
        Console.log("response: {}", DebugUtils.reduce(JSONUtil.parseObj(execute.body())));
        return execute;
    }

}
