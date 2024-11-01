package com.itrus.contract.demo.vo.req;

/**
 * @author pjw
 * @date 2023/8/11/0011
 */
public class TimePeriodReq extends PageReq {

    /**
     * 创建开始时间 yyyy-MM-dd
     */
    private String startTime;
    /**
     * 创建结束时间 yyyy-MM-dd
     */
    private String endTime;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
