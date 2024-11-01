package com.itrus.contract.demo.base;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.enums.signet.*;
import com.itrus.contract.demo.utils.config.ConfigUtil;
import com.itrus.contract.demo.utils.crypto.CertUtil;
import com.itrus.contract.demo.utils.crypto.HmacSha1Util;
import com.itrus.contract.demo.utils.http.PostUtil;
import com.itrus.contract.demo.utils.profile.ProfileUtil;
import com.itrus.contract.demo.vo.req.contract.createByTemplate.FontApiVO;
import com.itrus.contract.demo.vo.req.contract.signByFile.SealTimestampApiVO;
import com.itrus.contract.demo.vo.req.contract.signByFile.TextControlsFontVO;
import com.itrus.contract.demo.vo.req.contract.signByFile.TimestampStyleApiVO;
import com.itrus.contract.demo.vo.req.template.create.ImageWaterMarkVO;
import com.itrus.contract.demo.vo.req.template.create.QrWaterMarkVO;
import com.itrus.contract.demo.vo.req.template.create.TextWaterMarkVO;
import com.itrus.contract.demo.vo.req.template.create.WaterMarkBaseVO;
import com.itrus.contract.demo.vo.resp.BaseResp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @author pjw
 * @date 2022/7/22/0022
 */
public class BaseTest {

    public static ConfigUtil configUtil = Singleton.get(ConfigUtil.class);

    public static String profileName = "profile";

    public static Properties profile = ProfileUtil.findByAlias(profileName);


    public String pdfFile = "123.pdf";
    public String ofdFile = "contract.ofd";
    public String wordFile = "123.docx";
    public String autographFile = "autograph.png";
    public String blueStampFile = "blue.jpeg";
    public String sealFile = "seal.png";
    public String pfxFile = "test.pfx";
    public String cerFile = "test.cer";
    public String responseData = "data";
    public String status = "status";
    public String managerId = "managerId";
    public String userId = "userId";
    public String intentionId = "intentionId";
    public String userName = "name";
    public String phone = "phone";
    public String templateCode = "templateCode";
    public String templateId = "templateId";
    public String templateDocId = "templateDocId";
    public String contractId = "contractId";
    public String contractDocId = "docId";
    public String docName = "docName";
    public String signerId = "signerId";
    public String code = "code";
    public String uuid = "uuid";
    public String displayName = "displayName";
    public String email = "email";
    public String idCardNum = "idCardNum";
    public String idCardType = "idCardType";
    public String companyUuid = "companyUuid";
    public String enterpriseId = "enterpriseId";
    public String orgName = "orgName";
    public String sealId = "sealId";
    public String legalSealId = "legalSealId";
    public String autographId = "autographId";
    public String orgCode = "orgCode";
    public String signRecordCode = "signRecordCode";
    public String signValue = "signValue";
    public String content = "content";
    public String applyOrder = "applyOrder";
    public String keyPairCertEncoded = "certEncoded";
    public String keyPairPrivateKey = "private";
    public String hash = "hash";
    public String intermediateData = "intermediateData";
    public String signedHash = "signedHash";

    static {
        File file = ProfileUtil.getProfileFile(profileName);
        if (file.exists()) {
            try {
                profile = ProfileUtil.loadProfile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            profile = new Properties();
            profile.put(ProfileUtil.PROFILE_ALIAS_KEY, profileName);
        }
        configUtil = Singleton.get(ConfigUtil.class);
    }



    public void saveProFile() {
        try {
            ProfileUtil.save(profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject sendPost(String baseUrl, String url, JSONObject requestJson) {
        return PostUtil.toPost(baseUrl, url, requestJson.toString());
    }

    public JSONObject sendPost(String baseUrl, String url, JSONArray jsonArray) {
        return PostUtil.toPost(baseUrl, url, jsonArray.toString());
    }

    public JSONObject sendPost(String url, JSONObject requestJson) {
        return sendPost(configUtil.getBaseUrl(), url, requestJson);
    }
    public JSONObject sendPost(String url, String requestBodyJson) {
        return PostUtil.toPost(configUtil.getBaseUrl(), url, requestBodyJson);
    }

    public <T> BaseResp<T> sendPost(String url, JSONObject requestJson, T t) {
        JSONObject responseJson = sendPost(configUtil.getBaseUrl(), url, requestJson);
        BaseResp<T> tBaseResp = JSONUtil.toBean(responseJson, new TypeReference<BaseResp<T>>() {}, false);
        Object o = JSONUtil.toBean(JSONUtil.parseObj(tBaseResp.getData()), t.getClass());
        t = (T) o;
        tBaseResp.setData(t);
        return tBaseResp;
    }

    public Boolean isOk(JSONObject responseJson) {
        return responseJson.getInt(status) == 1;
    }

    public Boolean isOk(BaseResp<?> resp) {
        return resp.getCode() == 0;
    }

    public String getFileBase64(String url) {
        return Base64.encode(FileUtil.readBytes(System.getProperty("user.dir") + "/src/main/resources/" + url));
    }

    public String getPublicKeyFromCer(String cerFile){
        byte[] bytes = FileUtil.readBytes(System.getProperty("user.dir") + "/src/main/resources/" + cerFile);
        String cert = Base64.encode(bytes);
        return cert;
//        X509Certificate certificate = CertUtil.getCertificate(cert);
//        PublicKey publicKey = certificate.getPublicKey();
//        return Base64.encode(publicKey.getEncoded());
    }

    public Map<String, Object> getPublicKeyFromPfx(String pfxFile,String password){
        Map<String, Object> map = new HashMap<>();
        byte[] bytes = FileUtil.readBytes(System.getProperty("user.dir") + "/src/main/resources/" + pfxFile);
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new ByteArrayInputStream(bytes), password.toCharArray());
            String alias = ks.aliases().nextElement();
            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, password.toCharArray());
            Certificate[] chain = ks.getCertificateChain(alias);
            X509Certificate certificates = (X509Certificate) chain[0];
            PublicKey publicKey = certificates.getPublicKey();
            String certEncoded = Base64.encode(certificates.getEncoded());

            map.put("private", privateKey);
            map.put("public", publicKey);
            map.put("certEncoded", certEncoded);
            map.put("chain", chain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Object> getKeyPair() {
        Map<String, Object> map = new HashMap<>();
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new ByteArrayInputStream(FileUtil.readBytes(System.getProperty("user.dir") + "/src/main/resources/" + pfxFile)), "1234".toCharArray());
            String alias = ks.aliases().nextElement();
            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, "1234".toCharArray());
            Certificate[] chain = ks.getCertificateChain(alias);
            X509Certificate certificates = (X509Certificate) chain[0];
            PublicKey publicKey = certificates.getPublicKey();
            String certEncoded = Base64.encode(certificates.getEncoded());
            map.put("private", privateKey);
            map.put("public", publicKey);
            map.put("certEncoded", certEncoded);
            map.put("chain", chain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public List<WaterMarkBaseVO> getWaterMark() {
        WaterMarkBaseVO waterMark = new WaterMarkBaseVO();
        waterMark.setMarkName("水印名称");
        waterMark.setMarkType(WaterMarkTypeEnum.TEXT_MARK.getCode());
        waterMark.setPosition(WaterMarkAlignEnum.RIGHT_TOP.getCode());
        //文本水印
        TextWaterMarkVO textMark = new TextWaterMarkVO();
        textMark.setText("文本水印");
        textMark.setFontSize(26f);
        textMark.setColor("#FF0000");
        textMark.setOpacity(WaterMarkOpacityEnum.FALSE.getCode());
        textMark.setRotation(60f);
        textMark.setPages("0");
        waterMark.setPdfTextMarkParams(textMark);
        //图片水印
        ImageWaterMarkVO imageMark = new ImageWaterMarkVO();
        imageMark.setWatermarkFileBase64(Base64.encode(FileUtil.readBytes(sealFile)));
        imageMark.setWidth(20f);
        imageMark.setHeight(20f);
        imageMark.setOpacity(WaterMarkOpacityEnum.FALSE.getCode());
        imageMark.setRotation(60f);
        imageMark.setPages("0");
        waterMark.setPdfImageMarkParams(imageMark);
        //二维码水印
        QrWaterMarkVO qrCodeMark = new QrWaterMarkVO();
        qrCodeMark.setQrCodeWidth(100f);
        qrCodeMark.setQrCodeHeight(100f);
        qrCodeMark.setViewRange(ViewRangeTypeEnum.COMMONCDOC.getIndex());
        qrCodeMark.setPages("0");
        waterMark.setPdfQrCodeMarkParams(qrCodeMark);

        List<WaterMarkBaseVO> waterMarkParams = new ArrayList<>();
        waterMarkParams.add(waterMark);
        return waterMarkParams;
    }

    public List<FontApiVO> getFonts(Integer id) {
        List<FontApiVO> fonts = new ArrayList<>();
        FontApiVO fontApiVO = new FontApiVO();
        fontApiVO.setControlKey(id.toString());
        fontApiVO.setFontType(SignFontTypeEnum.SONG.getIndex());
        fontApiVO.setFontSize(12f);
        fontApiVO.setFontColor("#FF0000");
        fontApiVO.setAlignment(ControlAlignmentTypeEnum.MID.getIndex());
        fontApiVO.setVerticalAlignment(VerticalAlignmentTypeEnum.MID.getIndex());
        fontApiVO.setSingleLine(true);
        fonts.add(fontApiVO);
        return fonts;
    }

    public List<TextControlsFontVO> getSignFonts(Integer id) {
        List<TextControlsFontVO> fonts = new ArrayList<>();
        TextControlsFontVO textControlsFont = new TextControlsFontVO();
        textControlsFont.setControlsId(id.longValue());
        textControlsFont.setFontType(SignFontTypeEnum.SONG.getIndex());
        textControlsFont.setFontSize(12f);
        textControlsFont.setFontColor("#FF0000");
        textControlsFont.setAlignment(ControlAlignmentTypeEnum.MID.getIndex());
        textControlsFont.setVerticalAlignment(VerticalAlignmentTypeEnum.MID.getIndex());
        textControlsFont.setSingleLine(true);
        fonts.add(textControlsFont);
        return fonts;
    }

    public SealTimestampApiVO getSealTimeStampStyle() {
        SealTimestampApiVO sealTimestamp = new SealTimestampApiVO();
        sealTimestamp.setAllAddTimestamp(true);
        TimestampStyleApiVO unitTimestampStyle = new TimestampStyleApiVO();
        unitTimestampStyle.setControlsId(0);
        unitTimestampStyle.setPattern(TimePatternTypeEnum.STANDARD_DAY.getIndex());
        unitTimestampStyle.setColor("#5C3317");
        sealTimestamp.setUnitTimestampStyle(unitTimestampStyle);
        return sealTimestamp;
    }

}