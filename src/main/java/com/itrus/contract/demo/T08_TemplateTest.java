package com.itrus.contract.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.UserTypeEnum;
import com.itrus.contract.demo.enums.contract.LastFileTypeEnum;
import com.itrus.contract.demo.enums.signet.ControlTypeEnum;
import com.itrus.contract.demo.enums.template.TemplateOperationEnum;
import com.itrus.contract.demo.utils.data.Now;
import com.itrus.contract.demo.vo.req.template.*;
import com.itrus.contract.demo.vo.req.template.create.AddTemplateSignerApiVO;
import com.itrus.contract.demo.vo.req.template.setControls.CrossControlApiOldVO;
import com.itrus.contract.demo.vo.req.template.setControls.SetTemplateSignersApiOld;
import com.itrus.contract.demo.vo.req.template.setControls.TemplateSignFileApiOld;
import com.itrus.contract.demo.vo.req.template.setControls.XYControlApiOldVO;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.template.DocumentApiVO;
import com.itrus.contract.demo.vo.resp.template.TemplateResp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 八、模板接口
 * @author pjw
 * @date 2022/7/22/0022
 */
public class T08_TemplateTest extends BaseTest {

    /**
     * 8.1、创建模板
     */
    @Test
    public void createTemplate() {
        CreateTemplateApiReq req = new CreateTemplateApiReq();
        req.setCode(new Now().toString());
        req.setName(ParamConstant.TEMPLATE_NAME + new Now().toString());
        req.setDocName(ParamConstant.TEMPLATE_NAME + new Now().toString());
        req.setCreator(configUtil.getSuperManagerId());
        req.setEnterpriseId(configUtil.getCompanyUuid());
        req.setBase64(Base64.encode(FileUtil.readBytes(pdfFile)));
        req.setLastFileType(LastFileTypeEnum.PDF.getIndex());
        req.setBizCode(ParamConstant.CONTRACT_SYS_TYPE);
        req.setNodeCode(ParamConstant.TEMPLATE_NODE_CODE);
        req.setValidDays(ParamConstant.VALID_DAYS);
        req.setSignSortable(Boolean.TRUE);
        req.setSyncUrl(ParamConstant.CONTRACT_SYNC_URL);
        req.setAsyncUrl(ParamConstant.CONTRACT_ASYNC_URL);
        req.setWaterMarkOff(Boolean.TRUE);
        req.setWaterMarkParams(getWaterMark());
        List<AddTemplateSignerApiVO> signers = new ArrayList<AddTemplateSignerApiVO>() {{
            add(new AddTemplateSignerApiVO("甲方", UserTypeEnum.PERSON.getIndex(), 1));
            add(new AddTemplateSignerApiVO("乙方", UserTypeEnum.ENTERPRISE.getIndex(), 2));
        }};
        req.setSigners(signers);

        BaseResp<TemplateResp> resp = sendPost(ApiUrl.TEMPLATE_CREATE, JSONUtil.parseObj(req), new TemplateResp());
        if (isOk(resp)) {
            TemplateResp data = resp.getData();
            profile.put(templateCode, data.getCode());
            profile.put(templateId, data.getTemplateId());
            for (DocumentApiVO documentApiVO : data.getDocList()) {
                profile.put(templateDocId, documentApiVO.getDocId());
            }
            saveProFile();
        }
    }

    /**
     * 8.2、上传模板文件
     */
    @Test
    public void uploadFile() {
        UploadTemplateFileApiReq req = new UploadTemplateFileApiReq();
        req.setCode(profile.getProperty(templateCode));
        req.setDocName(ParamConstant.TEMPLATE_NAME + new Now().toString());
        req.setTemplateFile(Base64.encode(FileUtil.readBytes(pdfFile)));
        req.setSequence(2);
        req.setEnterpriseId(configUtil.getCompanyUuid());

        BaseResp<TemplateResp> resp = sendPost(ApiUrl.TEMPLATE_UPLOAD_FILE, JSONUtil.parseObj(req), new TemplateResp());
        if (isOk(resp)) {
            TemplateResp data = resp.getData();
            for (DocumentApiVO documentApiVO : data.getDocList()) {
                profile.put(templateDocId, documentApiVO.getDocId());
            }
            saveProFile();
        }
    }

    /**
     * 8.3、设置模板控件
     */
    @Test
    public void setSignControls() {
        SetTemplateControlsApiReq req = new SetTemplateControlsApiReq();
        req.setEnterpriseId(configUtil.getCompanyUuid());
        req.setCode(profile.getProperty(templateCode));

        SetTemplateSignersApiOld xyTemplateSigner = new SetTemplateSignersApiOld();
        xyTemplateSigner.setSignerRole("甲方");
        TemplateSignFileApiOld xySignFile = new TemplateSignFileApiOld();
        List<XYControlApiOldVO> xySignControls = new ArrayList<XYControlApiOldVO>() {{
            add(new XYControlApiOldVO("1", 1f, 0.2f, ControlTypeEnum.AUTOGRAPH.getCode(), 1));
            add(new XYControlApiOldVO("2", 0.2f, 0.2f, ControlTypeEnum.AUTOGRAPH.getCode(), 2));
        }};
        xySignFile.setXySignControls(xySignControls);
        xySignFile.setDocId(Long.parseLong(profile.getProperty("templateDocId")));
        xyTemplateSigner.setSignFiles(Collections.singletonList(xySignFile));

        SetTemplateSignersApiOld crossTemplateSigner = new SetTemplateSignersApiOld();
        crossTemplateSigner.setSignerRole("乙方");
        TemplateSignFileApiOld crossSignFile = new TemplateSignFileApiOld();
        crossSignFile.setDocId(Long.parseLong(profile.getProperty("templateDocId")));
        List<CrossControlApiOldVO> crossSignControls = new ArrayList<CrossControlApiOldVO>() {{
            add(new CrossControlApiOldVO(02f, ControlTypeEnum.SIGNET.getCode(), 1));
        }};
        crossSignFile.setCrossSignControls(crossSignControls);
        crossTemplateSigner.setSignFiles(Collections.singletonList(crossSignFile));

        SetTemplateSignersApiOld supplyVarTemplateSigner = new SetTemplateSignersApiOld();
        supplyVarTemplateSigner.setSignerRole("文本补充变量");
        TemplateSignFileApiOld supplyVarSignFile = new TemplateSignFileApiOld();
        supplyVarSignFile.setDocId(Long.parseLong(profile.getProperty("templateDocId")));
        List<XYControlApiOldVO> supplyVarSignControls = new ArrayList<XYControlApiOldVO>() {{
            add(new XYControlApiOldVO(1, "key", "1", 0.3f, 0.3f, ControlTypeEnum.TEXT.getCode(), 2f, 1f));
        }};
        supplyVarSignFile.setXySignControls(supplyVarSignControls);
        supplyVarTemplateSigner.setSignFiles(Collections.singletonList(supplyVarSignFile));

        List<SetTemplateSignersApiOld> signers = new ArrayList<>();
        signers.add(xyTemplateSigner);
        signers.add(crossTemplateSigner);
        signers.add(supplyVarTemplateSigner);
        req.setSigners(signers);

        sendPost(ApiUrl.TEMPLATE_SET_SIGN_CONTROLS, JSONUtil.parseObj(req), new BaseResp<>());
    }

    /**
     * 8.4、启用、停用、删除模板
     */
    @Test
    public void templateStatus() {
        TemplateStatusApiReq req = new TemplateStatusApiReq();
        req.setCode(profile.getProperty(templateCode));
        req.setEnterpriseId(configUtil.getCompanyUuid());
        req.setStatus(TemplateOperationEnum.OPEN.getIndex());

        sendPost(ApiUrl.TEMPLATE_STATUS, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 8.5、模板详情
     */
    @Test
    public void templateDetails() {
        TemplateDetailsApiReq req = new TemplateDetailsApiReq();
        req.setCode(profile.getProperty(templateCode));
        req.setEnterpriseId(configUtil.getCompanyUuid());

        sendPost(ApiUrl.TEMPLATE_DETAILS, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 8.6、编辑模板api页面
     */
    @Test
    public void updateTemplate() {
        UpdateTemplateApiReq req = new UpdateTemplateApiReq();
        req.setCode(profile.getProperty(templateCode));
        req.setEnterpriseId(configUtil.getCompanyUuid());

        sendPost(ApiUrl.TEMPLATE_UPDATE, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

}
