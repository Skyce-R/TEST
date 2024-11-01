package com.itrus.contract.demo;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.enums.account.StageEnum;
import com.itrus.contract.demo.utils.Tools;
import com.itrus.contract.demo.vo.req.solidy.ApplyObtainEvidenceReportReq;
import com.itrus.contract.demo.vo.req.solidy.LegalInstrumentApiReq;
import com.itrus.contract.demo.vo.req.solidy.SolidifyMsgReq;
import com.itrus.contract.demo.vo.req.solidy.SolidifyReq;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.solidify.*;
import org.junit.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 十一、见证接口
 * @author fujp
 * @date 2023/2/6 14:33
 */
public class T11_SolidifyTest extends BaseTest {

    /**
     * 11.1、数据固化
     */
    @Test
    public void solidify() {
        SolidifyReq solidifyReq = new SolidifyReq();
//        solidifyReq.setApplyOrder("139128508579315712");
        solidifyReq.setEnterpriseId("M01193NSTILM0RX");
        solidifyReq.setUserId("M01193MV42KPSRV");
        solidifyReq.setContractIds(ListUtil.of(167774503877738505L));
//        solidifyReq.setSignerIds(ListUtil.of(139128508579315712L));
        solidifyReq.setLegalInstrumentType(3);
        solidifyReq.setFileType(1);
        solidifyReq.setSignLocation("北京");

        BaseResp<SolidifyResp> resp = sendPost(ApiUrl.CONTRACT_SOLIDIFY, JSONUtil.parseObj(solidifyReq), new SolidifyResp());
        if (isOk(resp)) {
            SolidifyResp data = resp.getData();
            profile.put(applyOrder, data.getApplyOrder());
            saveProFile();
        }
    }

    /**
     * 11.2、申请取证
     */
    @Test
    public void applyObtainEvidenceReport() {
        ApplyObtainEvidenceReportReq req = new ApplyObtainEvidenceReportReq();
        req.setApplyOrder(profile.getProperty(applyOrder));

        sendPost(ApiUrl.APPLY_OBTAIN_EVIDENCE_REPORT, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 11.3、获取见证报告
     */
    @Test
    public void getWitnessReport() throws IOException {
        ApplyObtainEvidenceReportReq req = new ApplyObtainEvidenceReportReq();
        req.setApplyOrder(profile.getProperty(applyOrder));
        BaseResp<WitnessReportResp> resp = sendPost(ApiUrl.WITNESS_REPORT, JSONUtil.parseObj(req), new WitnessReportResp());
        if (isOk(resp)) {
            WitnessReportResp data = resp.getData();
            if ("40".equals(data.getStage())) {
                Console.log("已受理,正在生成见证报告中,请稍后重试.......");
                return;
            }
            WitnessResp report = data.getReport();
            String fileContent = report.getFileContent();
            String name = "d:/" + report.getFileName() + "." + report.getFileType();
            Tools.bytesToFile(name,fileContent);
            Console.log("文件已经写入到 : " + name);
        }
    }

    /**
     * 11.4、获取取证报告
     */
    @Test
    public void getObtainEvidenceReport() throws IOException {
        ApplyObtainEvidenceReportReq req = new ApplyObtainEvidenceReportReq();
        req.setApplyOrder(profile.getProperty(applyOrder));
        BaseResp<ObtainEvidenceReportResp> resp = sendPost(ApiUrl.OBTAIN_EVIDENCE_REPORT, JSONUtil.parseObj(req), new ObtainEvidenceReportResp());
        if (isOk(resp)) {
            ObtainEvidenceReportResp data = resp.getData();
            String stage = data.getStage();
            if("79".equals(stage)){
                String fileContent = data.getPdf();
                String name = "d:/" + data.getFileName() + "." +data.getFileType();
                Tools.bytesToFile(name,fileContent);
                Console.log("文件已经写入到 : " + name);
            }else {
                StageEnum nameByCode = StageEnum.getNameByCode(stage);
                Console.log("当前状态 : [ " + nameByCode.getName() + " ] 请稍后重试");
                return;
            }
            Console.log("\n" + JSON.toJSONString(resp, true));
        }
    }

    /**
     * 11.5、查询法律文书
     */
    @Test
    public void getLegalInstrument() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse("2023-02-01 00:00:00", dateTimeFormatter);
        LocalDateTime endTime = LocalDateTime.parse("2023-09-05 23:59:59", dateTimeFormatter);

        LegalInstrumentApiReq legalInstrumentApiReq = new LegalInstrumentApiReq();
        legalInstrumentApiReq.setEnterpriseId("M0114PLTSSH8YLO");
        legalInstrumentApiReq.setUserId("M01RSYLDEXH5UG");
        legalInstrumentApiReq.setLegalInstrumentType(2);
        legalInstrumentApiReq.setPageNum(1);
        legalInstrumentApiReq.setPageSize(10);
        legalInstrumentApiReq.setStartTime(Timestamp.valueOf(startTime).getTime());
        legalInstrumentApiReq.setEndTime(Timestamp.valueOf(endTime).getTime());

        sendPost(ApiUrl.LEGAL_INSTRUMENT, JSONUtil.parseObj(legalInstrumentApiReq), new LegalInstrumentResp());
    }

    /**
     * 11.6、获取固化数据
     */
    @Test
    public void getSolidifyMsg() {

        SolidifyMsgReq req = new SolidifyMsgReq();
        req.setContractId(158521498846363660L);
        sendPost(ApiUrl.SOLIDIFY_MSG, JSONUtil.parseObj(req), new LawBusinessSolidifySyncResp());

    }


    /**
     * 11.7、获取存证报告
     */
    @Test
    public void getExistingReport() throws IOException {
        ApplyObtainEvidenceReportReq req = new ApplyObtainEvidenceReportReq();
        req.setApplyOrder(profile.getProperty(applyOrder));
        BaseResp<WitnessReportResp> resp = sendPost(ApiUrl.LAW_GET_EXISTING_REPORT, JSONUtil.parseObj(req), new WitnessReportResp());
        if (isOk(resp)) {
            WitnessReportResp data = resp.getData();
            if ("40".equals(data.getStage())) {
                Console.log("已受理,正在生成见证报告中,请稍后重试.......");
                return;
            }
            WitnessResp report = data.getReport();
            String fileContent = report.getFileContent();
            String name = "d:/" + report.getFileName() + "." + report.getFileType();
            Tools.bytesToFile(name,fileContent);
            Console.log("文件已经写入到 : " + name);
        }
    }

}
