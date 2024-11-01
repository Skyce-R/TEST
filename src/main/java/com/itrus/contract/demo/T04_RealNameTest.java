package com.itrus.contract.demo;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.CertificateTypeEnum;
import com.itrus.contract.demo.enums.realName.OrgAuthTypeEnum;
import com.itrus.contract.demo.enums.realName.UserAuthTypeEnum;
import com.itrus.contract.demo.utils.data.CreditCode;
import com.itrus.contract.demo.vo.req.pageauth.EnterpriseInfoReq;
import com.itrus.contract.demo.vo.req.pageauth.StartEnterprisePageAuthReq;
import com.itrus.contract.demo.vo.req.pageauth.StartUserPageAuthReq;
import com.itrus.contract.demo.vo.req.pageauth.UserInfoReq;
import com.itrus.contract.demo.vo.req.realName.*;
import com.itrus.contract.demo.vo.resp.BaseResp;
import org.junit.Test;

import java.util.Arrays;

/**
 * 四、实名接口
 * @author pjw
 * @date 2022/7/22/0022
 */
public class T04_RealNameTest extends BaseTest {

    /**
     * 4.1、个人实名
     */
    @Test
    public void personRealName() {
        AuthUserApiReq req = new AuthUserApiReq();
        req.setUserId(profile.getProperty(userId));
        req.setIntentionId(profile.getProperty(intentionId));
        req.setDisplayName(profile.getProperty(displayName));
        req.setIdCardNum(profile.getProperty(idCardNum));
        req.setIdCardType(CertificateTypeEnum.IDENTITY_CARD.getCode());
        req.setBankCard("");
        req.setRealNameType(UserAuthTypeEnum.AUTH_TYPE_PHONE_3.getIndex());
        req.setPhone(profile.getProperty(phone));

        sendPost(ApiUrl.USER_REAL_NAME, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 4.2、企业实名
     */
    @Test
    public void orgRealName() {
        OrgRealNameApiReq req = new OrgRealNameApiReq();
        req.setAgentUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setIntentionId(profile.getProperty(intentionId));
        req.setAuthType(OrgAuthTypeEnum.AUTH_TYPE_LEGAL_PHONE.getIndex());
        req.setInOneType(true);
        req.setSocialCode(CreditCode.randomCreditCode());
        req.setUnitCode("");
        req.setRegisteredNo("");
        req.setLegalPersonName(profile.getProperty(displayName));
        req.setLegalIdCardNum( profile.getProperty(idCardNum));
        req.setLegalPhone(profile.getProperty(phone));
        req.setBankAccount("8663817197100011");
        req.setBankName("招商银行");
        req.setBranchBankName("招商银行股份有限公司北京大运村支行");
        req.setBankCode("CMB");
        req.setProvinceCode("110");
        req.setCityCode("1000");

        sendPost(ApiUrl.ENTERPRISE_REAL_NAME, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 4.3、验证企业打款金额
     */
    @Test
    public void verifyPayBank() {
        VerifyPaymentApiReq req = new VerifyPaymentApiReq();
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setPaymentAmount("1.2");

        sendPost(ApiUrl.ENTERPRISE_VERIFY_PAY_BANK, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 4.4、个人实名页面
     */
    @Test
    public void startSignByFile() {
        StartUserPageAuthReq startUserPageAuthReq = new StartUserPageAuthReq();
        startUserPageAuthReq.setUserId(profile.getProperty(userId));
        startUserPageAuthReq.setRealNameTypes(Arrays.asList(1,2,3));
        startUserPageAuthReq.setCantEditFields(ListUtil.of());
        startUserPageAuthReq.setExpire(ParamConstant.EXPIRE);
        startUserPageAuthReq.setSuccessLocation(ParamConstant.REAL_NAME_SUCCESS_LOCATION);
        startUserPageAuthReq.setCallbackUrl(ParamConstant.REAL_NAME_CALLBACK_URL);

        UserInfoReq userInfo = new UserInfoReq();
        userInfo.setDisplayName(profile.getProperty(displayName));
        userInfo.setPhone(profile.getProperty(phone));
        userInfo.setIdCardNum(profile.getProperty(idCardNum));
        userInfo.setIdCardType(CertificateTypeEnum.IDENTITY_CARD.getCode());
        userInfo.setBankCard("");
        startUserPageAuthReq.setUserInfo(userInfo);

        sendPost(ApiUrl.START_USER_PAGE_AUTH, JSONUtil.parseObj(startUserPageAuthReq), new BaseResp<Void>());
    }

    /**
     * 4.5、企业实名页面
     */
    @Test
    public void starEnterprisePageAuth() {
        StartEnterprisePageAuthReq req = new StartEnterprisePageAuthReq();
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setRealNameTypes(Arrays.asList(1,2));
        req.setCantEditFields(ListUtil.of());
        req.setExpire(ParamConstant.EXPIRE);
        req.setSuccessLocation(ParamConstant.REAL_NAME_SUCCESS_LOCATION);
        req.setCallbackUrl(ParamConstant.REAL_NAME_CALLBACK_URL);

        EnterpriseInfoReq enterpriseInfo = new EnterpriseInfoReq();
        enterpriseInfo.setEnterpriseName(profile.getProperty(orgName));
        enterpriseInfo.setOrgCode(profile.getProperty(orgCode));
        enterpriseInfo.setLegalPersonName(profile.getProperty(displayName));
        enterpriseInfo.setLegalIdcardNum( profile.getProperty(idCardNum));
        enterpriseInfo.setLegalPhone(profile.getProperty(phone));
        enterpriseInfo.setAgentName("");
        enterpriseInfo.setAgentIdcardNum("");
        enterpriseInfo.setBankAccount("");

        req.setEnterpriseInfo(enterpriseInfo);
        sendPost(ApiUrl.START_ENTERPRISE_PAGE_AUTH, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 4.6、省份列表
     */
    @Test
    public void provinceList() {
        sendPost(ApiUrl.PROVINCE_LIST, JSONUtil.parseObj(new Object()), new BaseResp<Void>());
    }

    /**
     * 4.7、城市列表
     */
    @Test
    public void cityList() {
        CityListReq req = new CityListReq();
        req.setProvinceCode("110");
        sendPost(ApiUrl.CITY_LIST, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 4.8、银行列表
     */
    @Test
    public void bankList() {
        sendPost(ApiUrl.BANK_LIST, JSONUtil.parseObj(new Object()), new BaseResp<Void>());
    }

    /**
     * 4.9、支行列表
     */
    @Test
    public void branchBankList() {
        BranchListReq req = new BranchListReq();
        req.setCityCode("2490");
        req.setBankCode("CCB");

        sendPost(ApiUrl.BRANCH_BANK_LIST, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

}
