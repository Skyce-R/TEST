package com.itrus.contract.demo.other;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.utils.config.ConfigUtil;
import com.itrus.contract.demo.utils.crypto.CertUtil;
import org.junit.Test;

import java.security.PublicKey;
import java.security.cert.X509Certificate;

/**
 * @author pjw
 * @date 2022/10/31/0031
 */
public class PjwTest extends BaseTest {

    @Test
    public void test1() {
        System.out.println(Base64.encode(SecureUtil.aes("1234567812345678".getBytes()).encrypt("123456")));
    }

    @Test
    public void test2() {
        System.out.println(Base64.encode(FileUtil.readBytes("C:\\Users\\pjw\\Desktop\\Snipaste_2022-11-14_16-58-30.png")));
    }

    @Test
    public void test3() {
        int total = 129266;
        int pageSize = 1000;
        int pages = 1;
        if (total > pageSize) {
            pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        }
        System.out.println(pages);
    }

    @Test
    public void test4() {
        Integer[] integers = Convert.toIntArray("1,2,3");
        System.out.println(Convert.toInt("1,2,3"));
    }

    @Test
    public void test5() {
        String start = DateUtil.format(DateUtil.beginOfMonth(DateUtil.date()), "yyyy-MM-dd");
        String end = DateUtil.format(DateUtil.endOfMonth(DateUtil.date()), "yyyy-MM-dd");
        System.out.println(start);
        System.out.println(end);
    }

    @Test
    public void test6() {
        ConfigUtil configUtil = Singleton.get(ConfigUtil.class);
        System.out.println(configUtil.getBaseUrl());
    }

    @Test
    public void test7() {
        int randomOffset = (int) Math.floor((Math.max(0, 100 - 20)) * Math.random());
        System.out.println(randomOffset);
    }

    @Test
    public void test8() {
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("processInstanceId", "M01W8T114YRQBT")
                .putOpt("businessNumber", "M01Z5PVFCENMLF")
                .putOpt("startUserId", "M01Z5PVFCENMLF")
                .putOpt("status", 1) // 文件类型 1 hash 2 原文 本期只支持hash
                ;

        String response = HttpRequest.post("http://127.0.0.1:7727/webgate/contractall/contractweb/contractApproval/callbackContract")
                .header("Accept", "application/json; charset=utf-8")
                .contentType("application/json;charset=UTF-8")
                .body(requestJson.toString())
                .execute().body();
        System.out.println(response);
    }

    @Test
    public void verifyCert() {
        String cert = "MIIEFDCCAvygAwIBAgIUIwH/4T7czPXQG3vWH9GmwjAkNIYwDQYJKoZIhvcNAQELBQAwVzEkMCIGA1UEAwwbaVRydXNDaGluYSBSU0EgVGVzdCBVc2VyIENBMQ0wCwYDVQQLDARUZXN0MRMwEQYDVQQKDAppVHJ1c0NoaW5hMQswCQYDVQQGEwJDTjAeFw0yMzA4MTYwNzQyMjFaFw0yNDA4MTUwNzQyMjFaMG8xCzAJBgNVBAYMAkNOMRgwFgYDVQQKDA/lpKnlqIHor5rkv6FSU0ExCzAJBgNVBAsMAlJBMTkwNwYDVQQDDDDkuK3lm73nlLXlu7rpm4blm6LkuIrmtbfog73mupDoo4XlpIfmnInpmZDlhazlj7gwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCWBYFLO30AI2ITzpE1rdhscAqe0Xy9PFvchlt0s5d55rD/zNoj1CXX6lBy9iAvqItdjLnJpV9wGtVWVAv8O9nggcGDFYo6DcNHNUccGO9TF9KQHdPdTN2Gt1Q3GN8OKQMEoX8ZMIQ/Pq2jEST6dKS8QXE5hrcDz+d4MbBmVYByGVZk6jjyzOtT66sM2hvoRcKtJieLaI/qCWHGzIXGfx6GUqBe3oMcYuO6EuyMqCrfrusqkeqsE6lO/68+eyChde46UPTw3DY8PI9O4hqnz2g/1ks4sjp91iLww6utfzuTgqmnXZMSlOE1kd69sAAba+geyYIKq7xLqUcAjewu8NDrAgMBAAGjgb8wgbwwCQYDVR0TBAIwADALBgNVHQ8EBAMCBPAwYgYDVR0fBFswWTBXoFWgU4ZRaHR0cDovL2l0cnVzY2hpbmEuY29tL3B1YmxpYy9pdHJ1c2NybD9DQT0yRTM2RjBFOUQxOTA1MkFDMjJENThDN0MyODdFNTIyMzIyMjg5M0JEMB8GA1UdIwQYMBaAFLvrVqmqF2Ex5zE3C/zD6MNqN/jnMB0GA1UdDgQWBBRBYdlUaGf7zQab3jqmyP1cOHF6PTANBgkqhkiG9w0BAQsFAAOCAQEArYgyDYnpIsQQ2cWIIkNEiW55dq5iW7AZ51zb1c2t8ihTtsStTprkh1aXTD5ghV4bqMSoti9//URkHKT/fKCvHADsb7SLNmXXVn0gk4IC/P21O3GwSpsc5nhDP9sztvueYfRE55oNlTiHRB1YXZ/7oTmrKy9TuI1BauenzY5HoGINW+uuohYDUsEyvZAKGo8RwP3f+THmVKsprKuprE4OIYDMLpAkVs2Z/UbkUdIpUjkD20CjAfc8Plrc4F/bqUNdyZ5oqyOoGxtIE1+DkcRIC7rR5GjffKKgpZjF3JDtUdLpnF/9yTQKtOIYvaGHA4jkiRSE8uxG7iO554BzMMb21w==";
        System.out.println("sn:" + CertUtil.getSn(cert));
        System.out.println("subject:" + CertUtil.getSubject(cert));
        System.out.println("issuer:" + CertUtil.getIssuer(cert));
        System.out.println("过期时间notBefore:" + LocalDateTimeUtil.format(CertUtil.getCertificateNorBeforeTime(CertUtil.getCertificate(cert)), DatePattern.NORM_DATETIME_PATTERN));
        System.out.println("过期时间notAfter:" + LocalDateTimeUtil.format(CertUtil.getCertificateExpirationTime(CertUtil.getCertificate(cert)), DatePattern.NORM_DATETIME_PATTERN));
    }

    @Test
    public void verify() {
        String cert = Base64.encode(FileUtil.readBytes("D:/aaa.cer"));
        X509Certificate certificate = CertUtil.getCertificate(cert);
        String name = certificate.getSubjectDN().getName();
        System.out.println(name.toLowerCase());
        System.out.println(name.toLowerCase().contains("BOEVT (HONG KONG) CO., LIMITED".toLowerCase()));
    }

    @Test
    public void getPublicKey() {
        String cert = Base64.encode(FileUtil.readBytes("D:/aaa.cer"));
        X509Certificate certificate = CertUtil.getCertificate(cert);
        PublicKey publicKey = certificate.getPublicKey();
        System.out.printf(Base64.encode(publicKey.getEncoded()));
    }

    @Test
    public void getCerFile() {
        System.out.println(getFileBase64(blueStampFile));
    }

}
