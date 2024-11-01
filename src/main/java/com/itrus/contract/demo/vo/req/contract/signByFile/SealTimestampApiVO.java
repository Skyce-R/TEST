package com.itrus.contract.demo.vo.req.contract.signByFile;

import lombok.Data;

import java.util.List;

/**
 * @author pjw
 */
@Data
public class SealTimestampApiVO {

    /**
     * 是否所有印章、签名控件都加盖时间戳,默认true(所有印章、签名都加盖默认样式时间戳); 当为false,只在以下参数中指定的控件中加盖时间戳
     */
    private Boolean allAddTimestamp;

    /**
     * 当allAddTimestamp为true时,通过此参数来统一设置所有印章、签名控件下方时间戳样式(controlsId控件id参数可设置为0)
     */
    private TimestampStyleApiVO unitTimestampStyle;

    /**
     * 指定具体印章、签名控件下方时间戳样式参数,当allAddTimestamp为false时,通过此参数来设置某些印章、签名控件的时间戳样式
     */
    private List<TimestampStyleApiVO> someTimestampStyles;

}
