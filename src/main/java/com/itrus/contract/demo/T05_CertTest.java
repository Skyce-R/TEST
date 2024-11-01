package com.itrus.contract.demo;

import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.enums.account.UserTypeEnum;
import com.itrus.contract.demo.enums.cert.CertScopeEnum;
import com.itrus.contract.demo.enums.cert.CertTypeEnum;
import com.itrus.contract.demo.enums.cert.RaCertSubTypeEnum;
import com.itrus.contract.demo.enums.cert.UserByLableEnum;
import com.itrus.contract.demo.vo.req.cert.*;
import com.itrus.contract.demo.vo.resp.BaseResp;
import org.junit.Test;

import java.util.Collections;

/**
 * 五、证书接口
 * @author pjw
 * @date 2022/10/31/0031
 */
public class T05_CertTest extends BaseTest {

    /**
     * 5.1、申请证书
     */
    @Test
    public void applyCert() {
        ApplyCertApiReq req = new ApplyCertApiReq();
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setCertType(CertTypeEnum.ENTERPRISE.getIndex());

        sendPost(ApiUrl.USER_APPLY_CERT, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 5.2、查询证书
     */
    @Test
    public void queryCert() {
        QueryCertApiReq req = new QueryCertApiReq();
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setScope(CertScopeEnum.ALL.getIndex());
        req.setCategory(CertTypeEnum.ENTERPRISE.getIndex());

        sendPost(ApiUrl.CERT_QUERY, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 5.3、私钥授权
     */
    @Test
    public void saveAuthorizationRecord() {
        PrivateAuthApiReq req = new PrivateAuthApiReq();
        req.setContractId(Collections.singletonList(Long.parseLong(profile.getProperty(contractId))));
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId( profile.getProperty(enterpriseId));
        req.setIntentionId(profile.getProperty(intentionId));
        req.setSignerType(UserTypeEnum.ENTERPRISE.getIndex());

        sendPost(ApiUrl.SAVE_AUTHORIZATION_RECORD, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 5.4、私钥授权api页面
     */
    @Test
    public void startAuthorizationPage() {
        PagePrivateAuthApiReq req = new PagePrivateAuthApiReq();
        req.setContractId(Collections.singletonList(Long.parseLong(profile.getProperty(contractId))));
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId( profile.getProperty(enterpriseId));
        req.setSignerType(UserTypeEnum.PERSON.getIndex());
        req.setCallbackUrl("");

        sendPost(ApiUrl.START_AUTHORIZATION_PAGE, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

}
