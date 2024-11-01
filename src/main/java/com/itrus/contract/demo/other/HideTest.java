package com.itrus.contract.demo.other;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.enums.account.UserTypeEnum;
import com.itrus.contract.demo.enums.cert.CertTypeEnum;
import com.itrus.contract.demo.enums.cert.RaCertSubTypeEnum;
import com.itrus.contract.demo.enums.cert.UserByLableEnum;
import com.itrus.contract.demo.enums.intention.IntentionWayEnum;
import com.itrus.contract.demo.vo.req.cert.ApiRaCertConfigReq;
import com.itrus.contract.demo.vo.req.contract.ApiContractBatchSignReq;
import com.itrus.contract.demo.vo.req.contract.ContractBatchSignApiReq;
import com.itrus.contract.demo.vo.req.contract.ContractListApiReq;
import com.itrus.contract.demo.vo.req.contract.KeywordCoordinatesApiReq;
import com.itrus.contract.demo.vo.resp.BaseResp;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author pjw
 * @date 2023/4/17/0017
 */
public class HideTest extends BaseTest {

    /**
     * 获取pdf内容
     */
    @Test
    public void getPdfText() {
        String apiUrl = "/hide/getPdfText";

        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("base64", Base64.encode(FileUtil.readBytes(pdfFile)))
//                .putOpt("pages", Collections.singletonList(1))
                ;
        sendPost(apiUrl, requestJson);
    }

    /**
     * 获取pdf内容
     */
    @Test
    public void callback() {
        String apiUrl = "/hide/callback";

        JSONObject requestJson = JSONUtil.createObj()
                .putOpt(contractId, profile.getProperty(contractId))
                ;
        sendPost(apiUrl, requestJson);
    }

    /**
     * 三方Ra账号新增接口-阿里云
     */
    @Test
    public void insertCertConfigTripartite() {
        ApiRaCertConfigReq req = new ApiRaCertConfigReq();
        req.setCpaAppid("alyabc");
        req.setCpaSecret("aly123456");
        req.setServiceUrl("cn.bing.com");
        req.setAccountHash("aly001");
        req.setCertType(CertTypeEnum.PERSON.getIndex());
        req.setCertSubType(RaCertSubTypeEnum.RA_LONG.getIndex());
        req.setKeyAlgorithm("");
        req.setCertName("certName");
        req.setUseByLable(UserByLableEnum.TRUE.getIndex());

        sendPost("/sysServiceConfig/insertCertConfigTripartite", JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    //旧版本批量签署
    @Test
    public void batchSign() {
        ApiContractBatchSignReq req = new ApiContractBatchSignReq();

        req.setUserWishesWay(IntentionWayEnum.SIGN_PASSWORD.getIndex());
        req.setVerifyCode("123456");
        req.setSignerType(UserTypeEnum.ENTERPRISE.getIndex());
        req.setCodeNumber("");
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setContractIds(Arrays.asList(152110711038803978L, 152110668089131009L));
        req.setSignControlValue("sealId:149328696841338927");
        req.setAgentStampControlValue("sealId:152110606885847040");


        sendPost("/contract/batchSign", JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    //新批量签署接口
    @Test
    public void batchSignContract() {
        ContractBatchSignApiReq req = new ContractBatchSignApiReq();
        req.setVerificationCodeType(IntentionWayEnum.SIGN_PASSWORD.getIndex());
        req.setVerifyCode("123456");
        req.setUserType(UserTypeEnum.ENTERPRISE.getIndex());
        req.setIntentionId("");
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setContractIdList(Arrays.asList(152110711038803978L, 152110668089131009L));
        req.setSignSealId(149328696841338927L);
        // req.setLegalSealId();
        //  req.setAgentStampId();

        sendPost("/contract/batchSignContract", JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 获取关键字信息
     */
    @Test
    public void getKeywordCoordinates() {
        KeywordCoordinatesApiReq req = new KeywordCoordinatesApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setDocId(Long.parseLong(profile.getProperty(contractDocId)));
        req.setKeyword("甲方");
        //  req.setPageNo("");

        sendPost("/contract/getKeywordCoordinates", JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 合同列表
     */
    @Test
    public void list() {
        ContractListApiReq req = new ContractListApiReq();
        req.setUserId(profile.getProperty(userId));
//        req.setEnterpriseId(profile.getProperty(enterpriseId));
//        req.setBizCode("bizCode_e1fdf");
//        req.setCode("code_84t6s");
//        req.setStatus(ContractStatusEnum.UNSIGNED.getIndex());
        req.setBeginTime(DateUtil.beginOfMonth(DateUtil.date()).getTime());
        req.setEndTime(DateUtil.endOfMonth(DateUtil.date()).getTime());
        req.setPageSize(10);
        req.setPageNumber(1);
        sendPost("/contract/contractList", JSONUtil.parseObj(req), new BaseResp<Void>());

    }

}
