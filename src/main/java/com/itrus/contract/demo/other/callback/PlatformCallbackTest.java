package com.itrus.contract.demo.other.callback;

import com.alibaba.fastjson.JSONObject;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.enums.callback.InformationChangedTypeEnum;
import com.itrus.contract.demo.vo.req.callback.CallBackApiRequest;
import com.itrus.contract.demo.vo.req.callback.CallBackEnterpriseReq;
import com.itrus.contract.demo.vo.req.callback.CallBackUserReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class PlatformCallbackTest extends BaseTest {

    public static String callbackUrl = "/prefix/platform/callback";


    @Test
    public void test_person(){
        CallBackApiRequest callBackApiRequest = new CallBackApiRequest();
        callBackApiRequest.setOperationType(InformationChangedTypeEnum.PERSON_CHANGED.getIndex()+"");
        callBackApiRequest.setTs(System.currentTimeMillis());
        CallBackUserReq oldUserReq = new CallBackUserReq();
        oldUserReq.setAuthResult("1");
        oldUserReq.setEmail("20231115172416133@qq.com");
        oldUserReq.setUserUuid("L02195FIKOQ7RBC");
        oldUserReq.setPhone("13112340002");
        oldUserReq.setDisplayName("龙五");
        callBackApiRequest.setOldData(JSONObject.toJSONString(oldUserReq));

        CallBackUserReq newUserReq = new CallBackUserReq();
        newUserReq.setAuthResult("1");
        newUserReq.setEmail("20231115172416133@qq.com");
        newUserReq.setUserUuid("L02195FIKOQ7RBC");
        newUserReq.setPhone("13112340003");
        newUserReq.setDisplayName("龙五3");
        callBackApiRequest.setNewData(JSONObject.toJSONString(newUserReq));


        cn.hutool.json.JSONObject body = sendPost(callbackUrl, JSONObject.toJSONString(callBackApiRequest));

    }

    @Test
    public void test_enterprise(){
        CallBackApiRequest callBackApiRequest = new CallBackApiRequest();
        callBackApiRequest.setOperationType(InformationChangedTypeEnum.ENTERPRISE_CHANGED.getIndex()+"");
        callBackApiRequest.setTs(System.currentTimeMillis());
        CallBackEnterpriseReq oldData = new CallBackEnterpriseReq();
        oldData.setCompanyUuid("L02196J3Z3AF8QT");
        oldData.setOrgName("北京京东世纪贸易有限公司1");
        oldData.setAuthResult("0");
        oldData.setCreatorUuid("L02194JYTMNH1C51");
        oldData.setSocialCode("9111030266050151361");
        oldData.setLegalUuid("L02194JYTMNH1C51");
        callBackApiRequest.setOldData(JSONObject.toJSONString(oldData));

        CallBackEnterpriseReq newData = new CallBackEnterpriseReq();
        newData.setCompanyUuid("L02196J3Z3AF8QT");
        newData.setOrgName("北京京东世纪贸易有限公司");
        newData.setAuthResult("1");
        newData.setCreatorUuid("L02194JYTMNH1C5");
        newData.setSocialCode("911103026605015136");
        newData.setLegalUuid("L02194JYTMNH1C5");
        callBackApiRequest.setNewData(JSONObject.toJSONString(newData));


        cn.hutool.json.JSONObject body = sendPost(callbackUrl, JSONObject.toJSONString(callBackApiRequest));

    }
}
