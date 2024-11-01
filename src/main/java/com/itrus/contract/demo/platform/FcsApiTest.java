package com.itrus.contract.demo.platform;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import org.junit.Test;

/**
 * 文档转换 Api
 * @author pjw
 * @date 2023/8/7/0007
 */
public class FcsApiTest extends BaseTest {

    /**
     * ppt转pdf
     */
    @Test
    public void ppt2pdf() {
        String apiUrl = "/fcs/front/ppt2pdf";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("file", Base64.encode(FileUtil.readBytes("D:/Test/ppt.ppt")))
                ;
        sendPost(apiUrl, requestJson);
    }

    /**
     * 图片转pdf
     */
    @Test
    public void images2pdf() {
        String apiUrl = "/fcs/front/images2pdf";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("file", Base64.encode(FileUtil.readBytes("D:/test/777.png")))
                ;
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(requestJson);
        JSONObject responseJson = sendPost(configUtil.getBaseUrl(), apiUrl, jsonArray);
        String data = responseJson.getStr("data");
        FileUtil.writeBytes(Base64.decode(data), "D:/images2pdf.pdf");
    }

    /**
     * excel转pdf
     */
    @Test
    public void excel2pdf() {
        String apiUrl = "/fcs/front/excel2pdf";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("file", Base64.encode(FileUtil.readBytes("D:/Test/123.xlsx")))
                ;
        sendPost(apiUrl, requestJson);
    }

}
