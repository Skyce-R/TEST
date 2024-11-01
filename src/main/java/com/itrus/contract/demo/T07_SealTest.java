package com.itrus.contract.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.signet.*;
import com.itrus.contract.demo.vo.req.signet.*;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.signet.CreateSealResp;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 七、印章接口
 * @author pjw
 * @date 2022/7/22/0022
 */
public class T07_SealTest extends BaseTest {

    /**
     * 7.1、创建印章
     */
    @Test
    public void createSeal() {
        CreateSealReq req = new CreateSealReq();
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setSealType(CreateTypeEnum.CUSTOM.getIndex());
        req.setCreateSealType(CreateSignetTypeEnum.ORDINARY.getIndex());
        req.setOperationMode(OperationModeEnum.CREATE.getIndex());
        req.setStatus(SealStatusEnum.ENABLE.getIndex());
        req.setSealBase64(getFileBase64(blueStampFile));
        req.setShape(SealShapeEnum.CIRCULAR.getIndex());
        req.setSealName(profile.getProperty(orgName) + RandomUtil.randomNumbers(3));
        req.setHorizontalText(SealForm.OFFICIAL.getDescription());
        req.setLowerText(RandomUtil.randomNumbers(16));
        req.setColor(ColorEnum.BLUE.getIndex());
        req.setAlpha(AlphaEnum.A10.getIndex());
        req.setAlphaDeal(true);
        req.setWidth(WidthEnum.W58.getIndex());
        req.setSealForm(SealForm.CONTRACTUAL.getIndex());
        req.setFontType(FontTypeEnum.SONG.getIndex());
        req.setReturnBase64(false);

        BaseResp<CreateSealResp> resp = sendPost(ApiUrl.CREATE_SEAL, JSONUtil.parseObj(req), new CreateSealResp());
        if (isOk(resp)) {
            CreateSealResp data = resp.getData();
            profile.put(sealId, data.getSealId());
            saveProFile();
        }
    }

    /**
     * 7.2、创建法人章
     */
    @Test
    public void createLegalSeal() {
        CreateLegalSealReq req = new CreateLegalSealReq();
//        req.setUserId("L02171M1CFGZLQP");
//        req.setEnterpriseId("L02158YOPLPLFR7");


        req.setUserId("M01RSYLDEXH5UG");
        req.setEnterpriseId("M0114PLTSSH8YLO");

        req.setOperatorUserId("L0215KOG8XRBRWW");
        req.setOperationMode(OperationModeEnum.CREATE.getIndex());
        req.setName(profile.getProperty(displayName) + RandomUtil.randomNumbers(3));
        req.setCreateMode(CreateTypeEnum.IMAGE.getIndex());
        req.setSealBase64(Base64.encode(FileUtil.readBytes(blueStampFile)));
        req.setAlphaDeal(false);
        req.setShapeType(StampShapeEnum.SINGLE.getIndex());
        req.setColor(ColorEnum.RED.getIndex());
        req.setSuffixName(SuffixNameEnum.ONE.getDescription());
        req.setFrame(BorderEnum.HAVE.getIndex());
        req.setWidth(Float.valueOf(WidthEnum.W38.getIndex()));
        req.setFont(FontTypeEnum.WEIRUANYAHEI.getIndex());
        req.setSyncUrl("www.baidu.com");
        ArrayList<Integer> integers = new ArrayList<Integer>() {
            {
                add(1);
                add(4);
            }
        };
        req.setIntentionWays(integers);

        BaseResp<CreateSealResp> resp = sendPost(ApiUrl.CREATE_LEGAL_SEAL_SIGN, JSONUtil.parseObj(req), new CreateSealResp());
        if (isOk(resp)) {
            CreateSealResp data = resp.getData();
            profile.put(sealId, data.getSealId());
            saveProFile();
        }
    }

    /**
     * 7.3、印章状态管理
     */
    @Test
    public void statusManager() {
        StatusManagerReq req = new StatusManagerReq();
        req.setSealId(Long.parseLong(profile.getProperty(sealId)));
        req.setUserId(profile.getProperty(userId));
        req.setStatus(false);
        req.setTypeOfSeal(TypeOfSealEnum.ORG.getIndex());
        req.setOperationType(OperationTypeEnum.STATUS.getIndex());

        sendPost(ApiUrl.SEAL_STATUS_MANAGER, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 7.4、删除印章
     */
    @Test
    public void deleteSeal() {
        DeleteSealReq req = new DeleteSealReq();
        req.setSealId(Long.parseLong(profile.getProperty(sealId)));
        req.setUserId(profile.getProperty(userId));

        sendPost(ApiUrl.DELETE_SEAL, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 7.5、印章授权
     */
    @Test
    public void authSeal() {
        AuthSealReq req = new AuthSealReq();
        req.setSealId(Long.parseLong(profile.getProperty(sealId)));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setAuthUserId(profile.getProperty(userId));
        req.setToAuthUserId(configUtil.getSuperManagerId());
        req.setToAuthManagerId(configUtil.getSuperManagerId());

        sendPost(ApiUrl.AUTH_SEAL, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 7.6、解除印章授权
     */
    @Test
    public void cancelAuthSeal() {
        CancelAuthSealReq req = new CancelAuthSealReq();
        req.setSealId(Long.parseLong(profile.getProperty(sealId)));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setUserId(profile.getProperty(userId));
        req.setAuthUserId(configUtil.getSuperManagerId());
        req.setManagerId(configUtil.getSuperManagerId());

        sendPost(ApiUrl.CANCEL_AUTH_SEAL, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 7.7、印章列表
     */
    @Test
    public void sealList() {
        SealListReq req = new SealListReq();
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setId(Long.parseLong(profile.getProperty(sealId)));
        req.setRequiredBase64(true);
        req.setRequiredAuthorizer(true);
        req.setPageNum(ParamConstant.PAGE_NUM);
        req.setPageSize(ParamConstant.PAGE_SIZE);

        sendPost(ApiUrl.SEAL_LIST, JSONUtil.parseObj(req), new BaseResp<Void>());
    }


    @Test
    public void getPageSignUrl() {
        PageSignUrlApiReq req = new PageSignUrlApiReq();
        req.setSealId(160116741001707641L);

        sendPost(ApiUrl.PAGE_SIGN_URL, JSONUtil.parseObj(req), new BaseResp<Void>());
    }






}
