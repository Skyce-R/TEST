package com.itrus.contract.demo.vo.resp.solidify;


/**
 * @Author: fujp
 * @Date: 2023/2/3 14:06
 */
public class WitnessReportResp {

    /**
     * 当前的状态
     */
    private String stage;
    /**
     * 天威见证服务单号
     */
    private String itrusOrderCode;
    /**
     * 见证报告
     */
    private WitnessResp report;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getItrusOrderCode() {
        return itrusOrderCode;
    }

    public void setItrusOrderCode(String itrusOrderCode) {
        this.itrusOrderCode = itrusOrderCode;
    }

    public WitnessResp getReport() {
        return report;
    }

    public void setReport(WitnessResp report) {
        this.report = report;
    }
}
