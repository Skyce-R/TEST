package com.itrus.contract.demo.other;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.utils.crypto.PKCS7Tools;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.cert.Certificate;
import java.util.Map;

/**
 * @author pjw
 * @date 2023/7/20/0020
 */
public class CertSignTest extends BaseTest {

    @Test
    public void sign() throws Exception {
        Map<String, Object> keyPair = getKeyPair();
        //Sha256WithRsa或者Sm3WithSm2
        Signature signature = Signature.getInstance("Sha256WithRsa");
        signature.initSign((PrivateKey) keyPair.get("private"));
        signature.update("2023-09-30".getBytes());
        System.out.println(Base64.encode(signature.sign()));
    }

    @Test
    public void verify() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Map<String, Object> keyPair = getKeyPair();
//        String certBase64 = "MIIECDCCAvCgAwIBAgIUaejJAMLNAqUSTK0/G9Qq5KabW+IwDQYJKoZIhvcNAQELBQAwVzEkMCIGA1UEAwwbaVRydXNDaGluYSBSU0EgVGVzdCBVc2VyIENBMQ0wCwYDVQQLDARUZXN0MRMwEQYDVQQKDAppVHJ1c0NoaW5hMQswCQYDVQQGEwJDTjAeFw0yMzA2MDkxMDM5NTVaFw0yNDA2MDgxMDM5NTVaMGMxCzAJBgNVBAYMAkNOMRgwFgYDVQQKDA/lpKnlqIHor5rkv6FSU0ExCzAJBgNVBAsMAlJBMS0wKwYDVQQDDCTljJfkuqzkuqzkuJzkuJbnuqrotLjmmJPmnInpmZDlhazlj7gwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDXUeBMRyVvRi3/+eZBmvRYE4h5hTdHJMTMtfTrtCExYel7o+e6w0jXkH4rKrS0G21HG1lvopbLtJgrjdSGh4i3T3g0IXaorgDe8U9QnL1Jxc77WFeH5KEFRkkgOlYtcbWIJnI7VWXl6XhjjtZdUPv0P2HcXvP90g5xQ1x63yRZY/uijcxONFguAksc+ocMWREYIKkHGjBfqpdL2APfJUVCK+a732Aui6PMpuGO+gilznpkNu0TLsKkil3D8313H1/zzqTxDXHMrNPLbc5YYs5yFaKO17HbnW3WGfv3iJI/GvhA6ugxVKSMA7ds/mVJUTkCZ59E/SEcR4ehXRVNRzk9AgMBAAGjgb8wgbwwCQYDVR0TBAIwADALBgNVHQ8EBAMCBPAwYgYDVR0fBFswWTBXoFWgU4ZRaHR0cDovL2l0cnVzY2hpbmEuY29tL3B1YmxpYy9pdHJ1c2NybD9DQT0yRTM2RjBFOUQxOTA1MkFDMjJENThDN0MyODdFNTIyMzIyMjg5M0JEMB8GA1UdIwQYMBaAFLvrVqmqF2Ex5zE3C/zD6MNqN/jnMB0GA1UdDgQWBBQ5ahbDQjPSi6JpP9NYYpkskz2eTTANBgkqhkiG9w0BAQsFAAOCAQEADwFvSdvQ32S6F5ZBIEIDVk1AYi41ZhIM/KRfrqnsJ8YtY/LAGd1HQDpV2us7/XRm89g+Mf34U1l+GpgMenVmyEVxA+bgE+cRvkqqW7sewUyfFBVn8xp/CBgbh1zz5yiw/+66gig2LGH5FIkqR4KzQCxd66lH+WPWkivdP8y4gI5txjFuq0ftk1facsPtqRsozctvmMcIN1pAf3rvtit3Xwd0uYzdsQaJIpAWHhpTwfP4eeVQq3ySqvNRNem1Tk+JlPE+dK1uH1tcenyXDUHRTTS4vmSpYEFkGjC+2mDY7zMgmzm/nMrXhZiIJrd9BjpxQdeLreNiAfUgKLnoZuxu4w==";
//        String originData = "MWkwGAYJKoZIhvcNAQkDMQsGCSqGSIb3DQEHATAcBgkqhkiG9w0BCQUxDxcNMjMwNzE5MDQzMTQxWjAvBgkqhkiG9w0BCQQxIgQg3nM8j98Z+SegmuAioPkHlWTuY1oOVDtxsQw0Xepg1/0=";
        String signedData = "qBYHFOnbQNovYaLvVyLbjHDLWKNjKZhGsmXn+CkbdcOuSyY2rZUFBbZ+toazZwHMGJGvlCbFVI5dfI9ZFZ6GNYGxJCA3R/+Dpesvz+DARqV3rjx+xr97HTfoTlKvde3Bl5SA7Al0e41Aq+S0BetIGJZugy+6U9+vmrbO6HjKpVU6oLbjQeJ4yybGBBysa01Ec0+kmVyyJSZamZT3cl5PhKAtczISIQno4oVF1WQM73OaLrxdRJ4oSg/2OxA02GZR/xGyj2z986wrnDhd8H4RAj8Uo2HJxEuODI0qAzvy6ki6TxVKGMzUAZlBVFBNHOPIh/mSpiCh09BVDN9dQvwDrw==";

//        certBase64 = certBase64.replaceAll("-----.{1,50}-----|\r|\n", "");
//        X509Certificate x509Certificate = CertTools.getInstance(java.util.Base64.getDecoder().decode(certBase64));
//        PublicKey publicKey = x509Certificate.getPublicKey();

        Signature signature = Signature.getInstance("SHA256WithRSA", "BC");
        signature.initVerify((PublicKey) keyPair.get("public"));
//        signature.update(Base64.decode(originData.getBytes()));
        signature.update("2023-12-31".getBytes());
        boolean verify = signature.verify(Base64.decode(signedData));
        System.out.println(verify);
    }

    @Test
    public void signP7() throws Exception {
        Map<String, Object> keyPair = getKeyPair();
        JSONObject licenseJson = JSONUtil.createObj();
        licenseJson.putOpt("endTime", "2023-12-29");

        Certificate[] chain = (Certificate[]) keyPair.get("chain");
        byte[] licenseBytes = PKCS7Tools.sign(licenseJson.toString().getBytes(), (PrivateKey) keyPair.get("private"), chain, "SHA1withRSA");
        System.out.println(Base64.encode(licenseBytes));
    }

    @Test
    public void verifyP7() throws Exception {
        String signed = "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";
        String verify = PKCS7Tools.verify(Base64.decode(signed));
        JSONObject jsonObject = JSONUtil.parseObj(verify);
        System.out.println(jsonObject);
    }
}
