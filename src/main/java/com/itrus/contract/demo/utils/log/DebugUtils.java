package com.itrus.contract.demo.utils.log;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pjw
 * @date 2021/6/1/0001
 */
public class DebugUtils {

    public static String reduce(JSONObject str) {
        final String s = JSON.toJSONString(str, new ParamFilter(), SerializerFeature.DisableCircularReferenceDetect);
        JSONObject jsonObject = JSONUtil.parseObj(s);
        return jsonObject.toStringPretty();
    }

    public static String reduce(String str) {
        String regex = "\"(doc|signedDoc|cert|csr|privateKey|sealImage|selfImg|idCardNum|transactorIdCardNum|mobile|transactorMobile|clientSignCert|certRequest|imageBase64|img|legalDoc|qrCode|pdf|content|video|autographBase64)\":\".*?\"";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String[] split = matcher.group().split(":");
            str = str.replace(matcher.group(),split[0] + ":\"...\"");
        }
        return str;
    }

}
