package com.itrus.contract.demo.vo.req.contract.signByFile;


public class TimestampStyleApiVO   {

    /**
     * 控件id
     */
    private Integer controlsId;

    /**
     * 时间戳格式:1表示"yyyy-MM-dd"(默认)、2表示 "yyyy-MM-dd hh:mm:ss"、3表示“yyyy年MM月dd日”、4“yyyy年MM月dd日 hh时mm分ss秒”
     */
    private Integer pattern = 1;

    /**
     * 时间戳字体颜色,格式:#FF0000
     */
    private String color;

    public Integer getControlsId() {
        return controlsId;
    }

    public void setControlsId(Integer controlsId) {
        this.controlsId = controlsId;
    }

    public Integer getPattern() {
        return pattern;
    }

    public void setPattern(Integer pattern) {
        this.pattern = pattern;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
