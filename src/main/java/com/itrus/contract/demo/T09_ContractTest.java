package com.itrus.contract.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.UserTypeEnum;
import com.itrus.contract.demo.enums.contract.*;
import com.itrus.contract.demo.enums.signet.*;
import com.itrus.contract.demo.utils.data.Now;
import com.itrus.contract.demo.vo.req.ApiLaunchNullifyContractReq;
import com.itrus.contract.demo.vo.req.contract.*;
import com.itrus.contract.demo.vo.req.contract.addSignerByFile.*;
import com.itrus.contract.demo.vo.req.contract.addSignerByTemplate.TemplateSignerApiVO;
import com.itrus.contract.demo.vo.req.contract.createByTemplate.TemplateFileApiVO;
import com.itrus.contract.demo.vo.req.contract.signByFile.*;
import com.itrus.contract.demo.vo.req.pagesign.AddContractSignerVO;
import com.itrus.contract.demo.vo.req.pagesign.AddTemplateSignerVO;
import com.itrus.contract.demo.vo.req.pagesign.PageSignReq;
import com.itrus.contract.demo.vo.req.pagesign.StartSignByFileTemplateRequestVO;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.contract.AddSignerApiResp;
import com.itrus.contract.demo.vo.resp.contract.ContractApiVO;
import com.itrus.contract.demo.vo.resp.contract.DownloadResp;
import com.itrus.contract.demo.vo.resp.contract.SignerApiVO;
import com.itrus.contract.demo.vo.resp.pagesign.PageSignResp;
import org.junit.Test;

import java.util.*;

/**
 * 九、合同接口
 * @author pjw
 * @date 2022/7/22/0022
 */
public class T09_ContractTest extends BaseTest {

    /**
     * 9.1、创建合同
     */
    @Test
    public void createByFile() {
        //合同信息
        CreateByFileApiReq req = new CreateByFileApiReq();
        req.setCode(new Now().toString());
        req.setName(ParamConstant.CONTRACT_NAME + new Now().toString());
        req.setSignCount(1);
        req.setSignValidDays(2);
        req.setSignSortable(false);
        req.setSend(true);
        req.setCreator(configUtil.getSuperManagerId());
        req.setEnterpriseId(configUtil.getCompanyUuid());
        req.setBizCode(ParamConstant.CONTRACT_SYS_TYPE);
        req.setLastFileType(LastFileTypeEnum.PDF.getIndex());
        req.setSyncUrl(ParamConstant.CONTRACT_SYNC_URL);
        req.setAsyncUrl(ParamConstant.CONTRACT_ASYNC_URL);
        req.setCheckSysBizType(true);
        //文件信息
        FileApiVO file = new FileApiVO();
        file.setDocName(req.getName());
        file.setBase64(req.getLastFileType() == LastFileTypeEnum.PDF.getIndex() ? getFileBase64(pdfFile) : getFileBase64(ofdFile));
        file.setFilePath("");
        file.setPathType(FilePathTypeEnum.FTP.getIndex());
        file.setWaterMarkOff(true);
        //水印信息
        file.setWaterMarkParams(getWaterMark());
        List<FileApiVO> files = new ArrayList<>();
        files.add(file);
        req.setFiles(files);

        BaseResp<ContractApiVO> resp = sendPost(ApiUrl.CONTRACT_CREATE_BY_FILE, JSONUtil.parseObj(req), new ContractApiVO());
        if (isOk(resp)) {
            ContractApiVO data = resp.getData();
            profile.put(contractId, data.getContractId());
            profile.put(contractDocId, data.getDocId());
            saveProFile();
        }
    }

    /**
     * 9.2、添加签署人
     */
    @Test
    public void addSignerByFile() {
        AddSignerByFileApiReq req = new AddSignerByFileApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        //签署人信息
        AddSignerApiVO signer = new AddSignerApiVO();
        signer.setSignerType(UserTypeEnum.ENTERPRISE.getIndex());
        signer.setUserId("M01193MV42KPSRV");
        signer.setEnterpriseId("M01193NSTILM0RX");
        signer.setSequence(1);
        signer.setSendMsg(false);
        signer.setSetting(true);
        signer.setControlsType(ControlTypeEnum.getCodeSet());
        //坐标轴控件
        List<XYControlApiVO> xySignControls = new ArrayList<XYControlApiVO>() {{
            add(new XYControlApiVO(1, ControlTypeEnum.SIGNET.getCode(), "1", 0.5f, 0.3f, null, null));
        }};
        //关键字控件
        List<KeywordControlApiVO> keywordSignControls = new ArrayList<KeywordControlApiVO>() {{
//            add(new KeywordControlApiVO(2, ControlTypeEnum.SIGNET.getCode(), "1", "乙方", null, null));
        }};
        //骑缝章控件
        List<CrossControlApiVO> crossSignControls = new ArrayList<CrossControlApiVO>() {{
//            add(new CrossControlApiVO(3, "0", 0.2f));
        }};
        //签署文件信息
        List<SignFileApiVO> signFiles = new ArrayList<SignFileApiVO>() {{
            add(new SignFileApiVO(Long.parseLong(profile.getProperty(contractDocId)), xySignControls, keywordSignControls, crossSignControls));
        }};
        signer.setSignFiles(signFiles);

        List<AddSignerApiVO> signers = new ArrayList<>();
        signers.add(signer);
        req.setSigners(signers);

        BaseResp<AddSignerApiResp> resp = sendPost(ApiUrl.CONTRACT_ADD_SIGNER_BY_FILE, JSONUtil.parseObj(req), new AddSignerApiResp());
        if (isOk(resp)) {
            AddSignerApiResp data = resp.getData();
            for (int i = 0; i < data.getSigners().size(); i++) {
                if (i == 0) {
                    profile.put(signerId, data.getSigners().get(i).getSignerId());
                } else {
                    profile.put(signerId + i, data.getSigners().get(i).getSignerId());
                }
            }
            saveProFile();
        }
    }

    /**
     * 9.3、模板创建合同
     */
    @Test
    public void createByTemplate() {
        CreateByTemplateApiReq req = new CreateByTemplateApiReq();
        req.setCode(RandomUtil.randomString(32));
        req.setTemplateCode(profile.getProperty(templateCode));
        req.setName(ParamConstant.CONTRACT_TEMPLATE_NAME + new Now().toString());
        req.setEnterpriseId(configUtil.getCompanyUuid());
        req.setCreator(configUtil.getSuperManagerId());
        req.setSyncUrl(ParamConstant.CONTRACT_SYNC_URL);
        req.setAsyncUrl(ParamConstant.CONTRACT_ASYNC_URL);

        List<TemplateFileApiVO> docList = new ArrayList<>();
        TemplateFileApiVO doc = new TemplateFileApiVO();
        doc.setTemplateDocId(Long.parseLong(profile.getProperty(templateDocId)));
        doc.setDocName(req.getName());
        Map<String, String> params = new HashMap<String, String>(1) {{
            put("key", "value");
        }};
        doc.setParams(params);
        doc.setFonts(getFonts(3));
        docList.add(doc);
        req.setDocList(docList);

        BaseResp<ContractApiVO> resp = sendPost(ApiUrl.CONTRACT_CREATE_BY_TEMPLATE, JSONUtil.parseObj(req), new ContractApiVO());
        if (isOk(resp)) {
            ContractApiVO data = resp.getData();
            profile.put(contractId, data.getContractId());
            profile.put(contractDocId, data.getDocuments().get(0).getDocId());
            saveProFile();
        }
    }

    /**
     * 9.4、模板创建合同添加签署人
     */
    @Test
    public void addSignerByTemplate() {
        AddSignerByTemplateApiReq req = new AddSignerByTemplateApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));

        List<TemplateSignerApiVO> templateSigners = new ArrayList<>();
        TemplateSignerApiVO singer = new TemplateSignerApiVO();
        singer.setSignerRole("甲方");
        singer.setUserId(profile.getProperty(userId));
        singer.setSendMsg(Boolean.FALSE);
        templateSigners.add(singer);
        req.setTemplateSigners(templateSigners);

        BaseResp<AddSignerApiResp> resp = sendPost(ApiUrl.CONTRACT_ADD_SIGNER_BY_TEMPLATE, JSONUtil.parseObj(req), new AddSignerApiResp());
        if (isOk(resp)) {
            AddSignerApiResp data = resp.getData();
            List<SignerApiVO> signers = data.getSigners();
            for (int i = 0; i < signers.size(); i++) {
                SignerApiVO signer = signers.get(i);
                if (i == 0) {
                    profile.put(signerId, signer.getSignerId());
                } else {
                    profile.put(signerId + i, signer.getSignerId());
                }
            }
            saveProFile();
        }
    }

    /**
     * 9.5、合同签署
     */
    @Test
    public void signByFile() {
        SignByFileOrTemplateApiReq req = new SignByFileOrTemplateApiReq();
        //设置合同
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        //设置签署人
        SignSignerApiVO signer = new SignSignerApiVO();
        signer.setSignerId(Long.parseLong(profile.getProperty(signerId)));
        signer.setIntentionId(profile.getProperty(intentionId));
        //设置签署文件
        List<SignSignerFileApiVO> signFiles = new ArrayList<>();
        SignSignerFileApiVO signFile = new SignSignerFileApiVO();
        signFile.setDocId(Long.parseLong(profile.getProperty(contractDocId)));
        //设置控件
        List<ControlValueApiVO> controlValues = new ArrayList<ControlValueApiVO>() {{
            add(new ControlValueApiVO(1L, Long.parseLong(profile.get(legalSealId).toString())));
            add(new ControlValueApiVO(2L, Long.parseLong(profile.get(sealId).toString())));
            add(new ControlValueApiVO(3L, Long.parseLong(profile.get(sealId).toString())));
        }};

        signFile.setControlValues(controlValues);
        signFile.setFonts(getSignFonts(1));
        signFile.setShowTimestamp(true);
        signFile.setSealTimestamp(getSealTimeStampStyle());

        signFiles.add(signFile);
        signer.setSignFiles(signFiles);

        req.setSigner(signer);
        sendPost(ApiUrl.CONTRACT_SIGN_BY_FILE, JSONUtil.parseObj(req), new AddSignerApiResp());
    }

    /**
     * 9.6、页面签署
     */
    @Test
    public void startSignByFile() {
        PageSignReq pageSignReq = new PageSignReq();
        pageSignReq.setContractId(Long.valueOf(profile.getProperty(contractId)));

        AddContractSignerVO addContractSignerVO = new AddContractSignerVO();
        addContractSignerVO.setSignerType(2);
        addContractSignerVO.setUserId("M01193MV42KPSRV");
        addContractSignerVO.setEnterpriseId("M01193NSTILM0RX");
        addContractSignerVO.setIsUserWishes(true);
        addContractSignerVO.setSequence(1);
        addContractSignerVO.setSendMsg(false);
        addContractSignerVO.setSetting(true);
        Set<String> controlsType = new HashSet<>();
        controlsType.add(ControlTypeEnum.SIGNET.getCode());
        controlsType.add(ControlTypeEnum.DATE.getCode());
        addContractSignerVO.setControlsType(controlsType);

        List<SignFileApiVO> signFiles = new ArrayList<>();
        SignFileApiVO signFileApiVO = new SignFileApiVO();
        signFileApiVO.setDocId(Long.valueOf(profile.getProperty(contractDocId)));

        // 坐标轴
        List<XYControlApiVO> xySignControls = new ArrayList<>();
        XYControlApiVO xyControlApiVO = new XYControlApiVO();
        xyControlApiVO.setPageNum("1");
        xyControlApiVO.setX(0.5F);
        xyControlApiVO.setY(0.5F);
        xyControlApiVO.setId(1);
        xyControlApiVO.setType(ControlTypeEnum.SIGNET.getCode());
        xyControlApiVO.setValue("");
        xySignControls.add(xyControlApiVO);

        signFileApiVO.setXySignControls(xySignControls);


//        // 关键字
//        List<KeywordControlApiVO> keywordControlApiVOS = new ArrayList<>();
//        KeywordControlApiVO keywordControlApiVO = new KeywordControlApiVO();
//        keywordControlApiVO.setPageNum("1");
//        keywordControlApiVO.setKeyword("建元装饰股份");
//        keywordControlApiVO.setOffsetX(2F);
//        keywordControlApiVO.setOffsetY(2F);
//        keywordControlApiVO.setId(2);
//        keywordControlApiVO.setType(ControlTypeEnum.SIGNET.getCode());
//        keywordControlApiVO.setValue("145046113311785080");
//        keywordControlApiVOS.add(keywordControlApiVO);

//        signFileApiVO.setKeywordSignControls(keywordControlApiVOS);

//        // 骑缝章
//        List<CrossControlApiVO> crossControlApiVOS = new ArrayList<>();
//        CrossControlApiVO crossControlApiVO = new CrossControlApiVO();
//        crossControlApiVO.setPageNum("0");
//        crossControlApiVO.setY(5F);
//        crossControlApiVO.setId(3);
//        crossControlApiVOS.add(crossControlApiVO);
//
//        signFileApiVO.setCrossSignControls(crossControlApiVOS);
        signFiles.add(signFileApiVO);

        addContractSignerVO.setSignFiles(signFiles);

        pageSignReq.setSigner(addContractSignerVO);
        pageSignReq.setSignType(1);
        pageSignReq.setExpire(30);
        pageSignReq.setSyncUrl("http://www.baidu.com");
        pageSignReq.setAsyncUrl("http://www.baidu.com");

        sendPost(ApiUrl.START_SIGN_BY_FILE, JSONUtil.parseObj(pageSignReq), new PageSignResp());
    }

    /**
     * 9.7、上传合同文件
     */
    @Test
    public void uploadFile() {
        UploadFileApiReq req = new UploadFileApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setDocName(ParamConstant.CONTRACT_NAME + new Now().toString());
        req.setContractFile(getFileBase64(pdfFile));
        req.setFilePath("filePath");
        req.setPathType(FilePathTypeEnum.FTP.getIndex());
        req.setSequence(1);
        sendPost(ApiUrl.CONTRACT_UPLOAD_FILE, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.8、下载合同
     */
    @Test
    public void downloadContract() {
        DownloadApiVO req = new DownloadApiVO();
        req.setType(ContractDownloadTypeEnum.SINGLE.getIndex());
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setContractIds(ListUtil.of(Long.parseLong(profile.getProperty(contractId))));

        BaseResp<DownloadResp> resp = sendPost(ApiUrl.CONTRACT_DOWNLOAD, JSONUtil.parseObj(req), new DownloadResp());
        if (isOk(resp)) {
            DownloadResp data = resp.getData();
            FileUtil.writeBytes(Base64.decode(data.getData()), configUtil.getDownloadPath() + data.getFileName());
        }
    }

    /**
     * 9.9、合同详情
     */
    @Test
    public void search() {
        ContractDetailsApiReq req = new ContractDetailsApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setResponseContractFile(true);

        sendPost(ApiUrl.CONTRACT_SEARCH, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.10、合同发起、撤回、结束
     */
    @Test
    public void operateContractStatus() {
        ContractStatusApiReq req = new ContractStatusApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setOperationType(ContractCheckStatusEnum.SEND.getIndex());

        sendPost(ApiUrl.CONTRACT_OPERATE_CONTRACT_STATUS, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.11、合同催签
     */
    @Test
    public void urgeSign() {
        ContractDetailsApiReq req = new ContractDetailsApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));

        sendPost(ApiUrl.CONTRACT_URGE_SIGN, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.12、添加抄送人
     */
    @Test
    public void addCc() {
        AddCCApiReq req = new AddCCApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setCcType(UserTypeEnum.ENTERPRISE.getIndex());
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));

        sendPost(ApiUrl.CONTRACT_ADD_CC, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.13、合同验证
     */
    @Test
    public void verifyContract() {
        VerifyContractApiReq req = new VerifyContractApiReq();
        req.setVerifyWay(ContractVerifyWayEnum.CONTRACT_ID.getIndex());
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setBase64(Base64.encode(FileUtil.readBytes(pdfFile)));
//        req.setCheckAnnot(Boolean.FALSE);
//        req.setCheckCRL(Boolean.FALSE);
        req.setCheckIssuer(false);

        sendPost(ApiUrl.CONTRACT_VERIFY, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.14、合同草稿删除
     */
    @Test
    public void deleteContract() {
        ContractDetailsApiReq req = new ContractDetailsApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));

        sendPost(ApiUrl.CONTRACT_DELETE_CONTRACT, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.15、发起合同解约
     */
    @Test
    public void launchNullify() {
        ApiLaunchNullifyContractReq req = new ApiLaunchNullifyContractReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setIntentionId(profile.getProperty(intentionId));
        req.setUserType(UserTypeEnum.PERSON.getIndex());
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setNotice(Boolean.FALSE);
        req.setReason("Reason");

        sendPost(ApiUrl.CONTRACT_LAUNCH_NULLIFY, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.16、确认合同解约
     */
    @Test
    public void confirmNullify() {
        ApiNullifyContractReq req = new ApiNullifyContractReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setIntentionId("");
        req.setUserType(UserTypeEnum.PERSON.getIndex());
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setReason("Reason");

        sendPost(ApiUrl.CONTRACT_CONFIRM_NULLIFY, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 9.17、获取解约URL
     */
    @Test
    public void getConfirmNullifyUrl() {
        ApiNullifyUrlReq req = new ApiNullifyUrlReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setUserType(UserTypeEnum.ENTERPRISE.getIndex());
        req.setUserId(profile.getProperty(userId));
        req.setEnterpriseId(profile.getProperty(enterpriseId));
        req.setAsyncUrl("baidu.com");
        req.setSyncUrl("cn.bing.com");
        req.setExpire(ParamConstant.EXPIRE);

        sendPost(ApiUrl.CONTRACT_GET_CONFIRM_NULLIFY_URL, JSONUtil.parseObj(req), new BaseResp<Void>());
    }


    @Test
    public void startSignByTemplateFile() throws Exception {
        StartSignByFileTemplateRequestVO requestVO= new StartSignByFileTemplateRequestVO();
        //1 页面云端签署(默认) 2 页面ukey签署
        requestVO.setSignType(1);
        //合同id
        requestVO.setContractId(166217132059656197L);
        //链接超时时间
        requestVO.setExpire(1440);
        requestVO.setSendMsg(true);

        AddTemplateSignerVO signers = new AddTemplateSignerVO();
        signers.setSignerType(2);
        signers.setEnterpriseId("M01193NSTILM0RX");
        signers.setUserId("M01193MV42KPSRV");
        signers.setIsUserWishes(true);
        List<Integer> ways = new ArrayList<>();
        ways.add(1);
        signers.setUserWishesWay(ways);

        requestVO.setSigner(signers);


        sendPost(ApiUrl.START_SIGN_BY_FILE_TEMPLATE, JSONUtil.parseObj(requestVO), new PageSignResp());
    }

}