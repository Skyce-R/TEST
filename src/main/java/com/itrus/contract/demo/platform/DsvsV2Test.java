package com.itrus.contract.demo.platform;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author pjw
 * @date 2023/12/21 0021
 */
public class DsvsV2Test extends BaseTest {

    /**
     * pdf签署
     */
    @Test
    public void dsvsV2Sign() {
        String apiUrl = "/v2/pdf/sign";

        JSONObject sealText = JSONUtil.createObj()
                .putOpt("text", "黑哦黑恩尽快送达")
                .putOpt("fontSize", 9)
                .putOpt("fontColor", "#000000")
//                .putOpt("lbX", 183.91881)
//                .putOpt("lbY", 4)
                .putOpt("width", 122)
                .putOpt("textAlign", "center")
                ;
        List<JSONObject> sealTexts = Collections.singletonList(sealText);

        JSONObject seal = JSONUtil.createObj()
                .putOpt("sealName", "1")
                .putOpt("sealWidth", 159.59999)
                .putOpt("sealHeight", 42)
                .putOpt("sealTexts", sealTexts)
                ;
        List<JSONObject> seals = new ArrayList<>(Collections.singletonList(seal));

        JSONObject sealSvg = JSONUtil.createObj()
                .putOpt("sealURI", "fss://168419644808364033")
                .putOpt("width", 107.71)
                .putOpt("height", 107.71)
                ;
        List<JSONObject> sealSvgs = Collections.singletonList(sealSvg);
        JSONObject seal2 = JSONUtil.createObj()
                .putOpt("sealName", "2")
                .putOpt("sealWidth", 107.71)
                .putOpt("sealHeight", 107.71)
                .putOpt("sealSvgs", sealSvgs)
                ;
        seals.add(seal2);

        JSONObject pagesSignature = JSONUtil.createObj()
                .putOpt("sealName", "1")
                .putOpt("pages", "1")
                .putOpt("x", 0.29157)
                .putOpt("y", 0.34577)
                .putOpt("userSealCenterForPositioning", true)
                ;
        List<JSONObject> pagesSignatures = new ArrayList<>(Collections.singletonList(pagesSignature));

        JSONObject pagesSignature2 = JSONUtil.createObj()
                .putOpt("sealName", "2")
                .putOpt("pages", "1")
                .putOpt("x", 0.29157)
                .putOpt("y", 0.34577)
                .putOpt("userSealCenterForPositioning", true)
                ;
        pagesSignatures.add(pagesSignature2);

        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("axisType", 2)
                .putOpt("pdfURI", "fss://168419584678821888")
                .putOpt("certId", 82643812577837056L)
                .putOpt("timestamp", true)
                .putOpt("tsaCode", "defaultTsaCode")
                .putOpt("returnType", "base64")
                .putOpt("seals", seals)
                .putOpt("pagesSignatures", pagesSignatures)
                ;
        JSONObject jsonObject = sendPost(apiUrl, requestJson);
        if (jsonObject.getInt("code") == 0) {
            JSONObject data = jsonObject.getJSONObject("data");
            FileUtil.writeBytes(Base64.decode(data.getStr("pdfData")), "D:/dsvsV2Sign.pdf");
        }
    }

}
