package com.itrus.contract.demo.constant;

import cn.hutool.core.date.DateUtil;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author pjw
 * @date 2023/8/11/0011
 */
public class ParamConstant {

    public static final int PAGE_NUM = 1;
    public static final int PAGE_SIZE = 10;

    public static final String START_TIME = DateUtil.format(DateUtil.beginOfMonth(DateUtil.date()), "yyyy-MM-dd");
    public static final String END_TIME = DateUtil.format(DateUtil.endOfMonth(DateUtil.date()), "yyyy-MM-dd");

    public static String MAIL_SUFFIX = "@qq.com";
    public static String OTHER_CARD_NAME = "其他证件类型名称";
    public static String USER_LABEL = "001";
    public static String ORG_LABEL = "002";

    public static String REAL_NAME_SUCCESS_LOCATION = "http://www.baidu.com";
    public static String REAL_NAME_CALLBACK_URL = "http://www.baidu.com";

    public static Integer EXPIRE = 30;

    public static String CONTRACT_NAME = "测试合同";
    public static String CONTRACT_TEMPLATE_NAME = "模板测试合同";
    public static String CONTRACT_SYS_TYPE = "common";
    public static String CONTRACT_SYNC_URL = "http://www.baidu.com";
    public static String CONTRACT_ASYNC_URL = "http://www.baidu.com";

    public static String TEMPLATE_NAME = "测试模板";
    public static String TEMPLATE_NODE_CODE = "100100";
    public static Integer VALID_DAYS = 180;

}
