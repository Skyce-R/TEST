package com.itrus.contract.demo;

import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.CertificateTypeEnum;
import com.itrus.contract.demo.enums.enterprise.AdminModifyTypeEnum;
import com.itrus.contract.demo.enums.enterprise.EnterpriseTypeEnum;
import com.itrus.contract.demo.utils.data.*;
import com.itrus.contract.demo.vo.req.enterprise.*;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.enterprise.CreateOrgApiResp;
import com.itrus.contract.demo.vo.resp.enterprise.UpdateOrgApiResp;
import org.junit.Test;

/**
 * 二、企业接口
 * @author pjw
 * @date 2022/7/22/0022
 */
public class T02_EnterpriseTest extends BaseTest {

    /**
     * 2.1、创建企业
     */
    @Test
    public void createEnterprise() {
        CreateOrgApiReq createOrgApiReq = new CreateOrgApiReq();
        createOrgApiReq.setUserId(profile.getProperty(userId));
        createOrgApiReq.setEnterpriseLabel(ParamConstant.ORG_LABEL);
        createOrgApiReq.setOrgName(new ChineseOrgName().toString());
        createOrgApiReq.setEnterpriseType(EnterpriseTypeEnum.ET_PE.getCode());
        createOrgApiReq.setIdType(CertificateTypeEnum.ORGANIZATION_CODE_CERTIFICATE.getCode());
        createOrgApiReq.setOrgCode(new OrgCode().toString());
        createOrgApiReq.setAuthentication(true);
        createOrgApiReq.setOtherCardName(ParamConstant.OTHER_CARD_NAME);
        createOrgApiReq.setLegalName(new ChineseName().toString());
        createOrgApiReq.setLegalPhone(new Mobile().toString());
        createOrgApiReq.setLegalIdCardType(CertificateTypeEnum.OTHER.getCode());
        createOrgApiReq.setLegalIdCard(new IdCardNum().toString());

        BaseResp<CreateOrgApiResp> resp = sendPost(ApiUrl.CREATE_ENTERPRISE, JSONUtil.parseObj(createOrgApiReq), new CreateOrgApiResp());
        if (isOk(resp)) {
            CreateOrgApiResp data = resp.getData();
            profile.put(enterpriseId, data.getEnterpriseId());
            profile.put(orgName, createOrgApiReq.getOrgName());
            profile.put(orgCode, createOrgApiReq.getOrgCode());
            saveProFile();
        }
    }

    /**
     * 2.2、更新企业
     */
    @Test
    public void updateEnterprise() {
        UpdateOrgApiReq req = new UpdateOrgApiReq();
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setOrgName(new ChineseOrgName().toString());
        req.setEnterpriseLabel(ParamConstant.ORG_LABEL);

        BaseResp<UpdateOrgApiResp> resp = sendPost(ApiUrl.UPDATE_ENTERPRISE, JSONUtil.parseObj(req), new UpdateOrgApiResp());
        if (isOk(resp)) {
            profile.put(orgName, req.getOrgName());
            saveProFile();
        }
    }

    /**
     * 2.3、查询企业
     */
    @Test
    public void orgDetails() {
        OrgDetailsApiReq orgDetailsApiReq = new OrgDetailsApiReq();
        orgDetailsApiReq.setEnterpriseId(profile.getProperty(enterpriseId));

        sendPost(ApiUrl.ENTERPRISE_DETAILS, JSONUtil.parseObj(orgDetailsApiReq),new BaseResp<Void>());
    }

    /**
     * 2.4、查询企业列表
     */
    @Test
    public void orgList() {
        OrgListApiReq req = new OrgListApiReq();
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setCompanyName(profile.getProperty(orgName));
        req.setSocialCode("");
        req.setStartTime(ParamConstant.START_TIME);
        req.setEndTime(ParamConstant.END_TIME);
        req.setPageNum(ParamConstant.PAGE_NUM);
        req.setPageSize(ParamConstant.PAGE_SIZE);

        sendPost(ApiUrl.ENTERPRISE_PAGE, JSONUtil.parseObj(req),new BaseResp<Void>());
    }

    /**
     * 2.5、添加子企业
     */
    @Test
    public void addSubCompany() {
        AddSubCompanyApiReq addSubCompanyApiReq = new AddSubCompanyApiReq();
        addSubCompanyApiReq.setEnterpriseId(configUtil.getCompanyUuid());
        addSubCompanyApiReq.setSubCompanyUuid(profile.getProperty(enterpriseId));

        sendPost(ApiUrl.ADD_SUB_COMPANY, JSONUtil.parseObj(addSubCompanyApiReq),new BaseResp<Void>());
    }

    /**
     * 2.6、添加或变更主管理员
     */
    @Test
    public void addOrModifyAdmin() {
        AddOrModifyAdminApiReq addOrModifyAdminApiReq = new AddOrModifyAdminApiReq();
        addOrModifyAdminApiReq.setNewUserId(configUtil.getSuperManagerId());
        addOrModifyAdminApiReq.setEnterpriseId(profile.getProperty(enterpriseId));
        addOrModifyAdminApiReq.setIntentionId(profile.getProperty(intentionId));
        addOrModifyAdminApiReq.setType(AdminModifyTypeEnum.CHANGE.getIndex());
        addOrModifyAdminApiReq.setOriginalUserId(profile.getProperty(userId));
        addOrModifyAdminApiReq.setSmsNotice(Boolean.TRUE);

        sendPost(ApiUrl.ADD_OR_MODIFY_ADMIN, JSONUtil.parseObj(addOrModifyAdminApiReq),new BaseResp<Void>());
    }

    /**
     * 2.7、企业绑定法定代表人
     */
    @Test
    public void bindLegal() {
        BindLegalReq bindLegalReq = new BindLegalReq();
        bindLegalReq.setEnterpriseId(profile.getProperty(enterpriseId));
        bindLegalReq.setLegalUserId(configUtil.getSuperManagerId());
        bindLegalReq.setOperatorUserId(profile.getProperty(userId));

        sendPost(ApiUrl.BIND_LEGAL, JSONUtil.parseObj(bindLegalReq),new BaseResp<Void>());
    }

    /**
     * 2.8、变更企业法定代表人
     */
    @Test
    public void changeLegal() {
        ApiChangeLegalReq apiChangeLegalReq = new ApiChangeLegalReq();
        apiChangeLegalReq.setEnterpriseId(profile.getProperty(enterpriseId));
        apiChangeLegalReq.setLegalUserId(configUtil.getSuperManagerId());
        apiChangeLegalReq.setOperatorUserId(profile.getProperty(userId));

        sendPost(ApiUrl.CHANGE_LEGAL, JSONUtil.parseObj(apiChangeLegalReq),new BaseResp<Void>());
    }

}
