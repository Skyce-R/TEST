package com.itrus.contract.demo.other;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import org.junit.Test;

/**
 * 文件相关API
 * @author pjw
 * @date 2022/10/13/0013
 */
public class FileTest extends BaseTest {

    private final String controllerName = "/file";

    /**
     * 根据fssId下载文件
     */
    @Test
    public void downloadByFssId() {
        String apiUrl = controllerName + "/downloadByFssId";

        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("fssId", 159724933147000846L)
                ;
        JSONObject responseJson = sendPost(apiUrl, requestJson);
        if (isOk(responseJson)) {
            JSONObject data = responseJson.getJSONObject("data");
            FileUtil.writeBytes(data.getBytes("fileBytes"), "D:/" + data.getStr("fileName") + ".pdf");
        }
    }
}
