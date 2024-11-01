package com.itrus.contract.demo;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.AccountTypeEnum;
import com.itrus.contract.demo.enums.account.CertificateTypeEnum;
import com.itrus.contract.demo.enums.account.VerifySourceEnum;
import com.itrus.contract.demo.utils.UUIDUtil;
import com.itrus.contract.demo.utils.data.ChineseName;
import com.itrus.contract.demo.utils.data.IdCardNum;
import com.itrus.contract.demo.utils.data.Mobile;
import com.itrus.contract.demo.utils.data.Now;
import com.itrus.contract.demo.vo.req.enterprise.RemoveUserApiReq;
import com.itrus.contract.demo.vo.req.user.*;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.user.PersonResp;
import org.junit.Test;

/**
 * 一、用户接口
 * @author pjw
 * @date 2022/7/22/0022
 */
public class T01_UserTest extends BaseTest {

    /**
     * 1.1、创建用户
     */
    @Test
    public void createPerson() {
        CreatePersonReq req = new CreatePersonReq();
        req.setDisplayName(new ChineseName().toString());
        req.setIdCardType(CertificateTypeEnum.IDENTITY_CARD.getCode());
        req.setIdCardNum(new IdCardNum().toString());
        req.setOtherCardName(ParamConstant.OTHER_CARD_NAME);
        req.setType(AccountTypeEnum.PHONE.getIndex());
        req.setPhone(new Mobile().toString());
        req.setAccount(RandomUtil.randomString(32));
        req.setEmail(new Now().toString() + ParamConstant.MAIL_SUFFIX);
        req.setPasswd(RandomUtil.randomString(16));
        req.setAuthentication(true);
        req.setUserLabel(ParamConstant.USER_LABEL);

        BaseResp<PersonResp> resp = sendPost(ApiUrl.CREATE_PERSON, JSONUtil.parseObj(req), new PersonResp());
        if (isOk(resp)) {
            PersonResp data = resp.getData();
            profile.put(userId, data.getUserId());
            profile.put(displayName, req.getDisplayName());
            profile.put(phone, req.getPhone());
            profile.put(idCardNum, req.getIdCardNum());
            saveProFile();
        }
    }

    /**
     * 1.2、更新用户
     */
    @Test
    public void updatePerson() {
        UpdatePersonReq req = new UpdatePersonReq();
        req.setUserId(profile.getProperty(userId));
        req.setDisplayName(new ChineseName().toString());
        req.setPhone(new Mobile().toString());
        req.setEmail(new Now().toString() + ParamConstant.MAIL_SUFFIX);
        req.setUserLabel(ParamConstant.USER_LABEL);
        req.setPasswd(UUIDUtil.randomPassword());

        BaseResp<PersonResp> resp = sendPost(ApiUrl.UPDATE_PERSON, JSONUtil.parseObj(req), new PersonResp());
        if (isOk(resp)) {
            PersonResp data = resp.getData();
            profile.put(userId, data.getUserId());
            profile.put(displayName, req.getDisplayName());
            profile.put(phone, req.getPhone());
            saveProFile();
        }
    }

    /**
     * 1.3、用户查询
     */
    @Test
    public void userDetails() {
        UserIdReq req = new UserIdReq();
        req.setUserId(profile.getProperty(userId));

        sendPost(ApiUrl.USER_DETAILS, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 1.4、用户列表查询
     */
    @Test
    public void userList() {
        UserListReq req = new UserListReq();
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setPhone(profile.getProperty(phone));
        req.setIdCardNum(profile.getProperty(idCardNum));
        req.setStartTime(ParamConstant.START_TIME);
        req.setEndTime(ParamConstant.END_TIME);
        req.setPageNum(ParamConstant.PAGE_NUM);
        req.setPageSize(ParamConstant.PAGE_SIZE);

        sendPost(ApiUrl.USER_LIST, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 1.5、邀请用户加入企业
     */
    @Test
    public void joinEnterprise() {
        JoinOrgReq req = new JoinOrgReq();
        req.setInviteUserId(configUtil.getSuperManagerId());
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));

        sendPost(ApiUrl.JOIN_ENTERPRISE, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 1.6、移除企业下用户
     */
    @Test
    public void removeUserEnterprise() {
        RemoveUserApiReq req = new RemoveUserApiReq();
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setUserId(configUtil.getSuperManagerId());

        sendPost(ApiUrl.REMOVE_ENTERPRISE_USER, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 1.7、设置签署密码
     */
    @Test
    public void setPwd() {
        SetPwdReq req = new SetPwdReq();
        req.setUserId(profile.getProperty(userId));
        req.setSignPassword(RandomUtil.randomNumbers(3)+"a@");
        req.setVerifySource(VerifySourceEnum.TRIPARTITE.getIndex());
        req.setIntentionId(profile.getProperty(intentionId));

        sendPost(ApiUrl.RESET_PASSWORD, JSONUtil.parseObj(req), new BaseResp<Void>());
    }


    @Test
    public void initiation() {
        UpdatePersonReq req = new UpdatePersonReq();
        sendPost(ApiUrl.INITIATION, JSONUtil.parseObj(req), new PersonResp());

    }

}
