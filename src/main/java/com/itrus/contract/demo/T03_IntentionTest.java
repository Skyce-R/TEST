package com.itrus.contract.demo;

import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.enums.intention.IntentionPurposeEnum;
import com.itrus.contract.demo.enums.intention.IntentionTypeEnum;
import com.itrus.contract.demo.enums.intention.IntentionWayEnum;
import com.itrus.contract.demo.vo.req.intention.LaunchIntentionApiReq;
import com.itrus.contract.demo.vo.req.intention.VerifyIntentionApiReq;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.intention.LaunchIntentionApiResp;
import com.itrus.contract.demo.vo.resp.intention.VerifyIntentionApiResp;
import org.junit.Test;

/**
 * 三、意愿认证接口
 * @author pjw
 * @date 2022/10/13/0013
 */
public class T03_IntentionTest extends BaseTest {

    /**
     * 3.1、发起意愿认证
     */
    @Test
    public void launchIntention() {
        LaunchIntentionApiReq req = new LaunchIntentionApiReq();
        req.setIntentionPurpose(IntentionPurposeEnum.ORG_REAL_NAME.getIndex());
        req.setIntentionWay(IntentionWayEnum.PHONE.getIndex());
        req.setType(IntentionTypeEnum.PHONE.getIndex());
        req.setUserId(profile.getProperty(userId));
        req.setPhone(profile.getProperty(phone));

        BaseResp<LaunchIntentionApiResp> resp = sendPost(ApiUrl.INTENTION_LAUNCH, JSONUtil.parseObj(req), new LaunchIntentionApiResp());
        if (isOk(resp)) {
            LaunchIntentionApiResp data = resp.getData();
            profile.put(intentionId, data.getIntentionId());
            saveProFile();
        }
    }

    /**
     * 3.2、校验意愿认证
     */
    @Test
    public void verifyIntention() {
        VerifyIntentionApiReq req = new VerifyIntentionApiReq();
        req.setIntentionWay(IntentionWayEnum.PHONE.getIndex());
        req.setIntentionId(profile.getProperty(intentionId));
        req.setVerifyCode("636620");
        req.setSignPassword("123456");
        req.setUserId(profile.getProperty(userId));

        BaseResp<VerifyIntentionApiResp> resp = sendPost(ApiUrl.INTENTION_VERIFY, JSONUtil.parseObj(req), new VerifyIntentionApiResp());
        if (isOk(resp)) {
            VerifyIntentionApiResp data = resp.getData();
            profile.put(intentionId, data.getIntentionId());
            saveProFile();
        }
    }

}
