package com.itrus.contract.demo.platform;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.utils.http.PostUtil;
import org.junit.Test;

/**
 * @author pjw
 * @date 2023/12/18 0018
 */
public class GateApiTest extends BaseTest {

    /**
     * 计数
     */
    @Test
    public void count() {
        String apiUrl = "https://demo-open.itruscloud.com/charging/count";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("appId", "2e82db24f17d40")
                .putOpt("serviceCode", "contractSDK0003")
                ;
        PostUtil postUtil = new PostUtil(UrlBuilder.of(apiUrl));
        postUtil.sendPost(requestJson.toString(),"2e82db24f17d40","4fab3a63d41846bfb1a3a5e94b87863e", "contractSDK0003");
    }

}
