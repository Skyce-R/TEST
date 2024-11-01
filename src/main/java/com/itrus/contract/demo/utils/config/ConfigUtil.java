package com.itrus.contract.demo.utils.config;

import cn.hutool.setting.dialect.Props;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pjw
 * 日期 2020/7/14 0014
 */
@Setter
@Getter
public class ConfigUtil {

    Props props = new Props("application.yml");

    String baseUrl = props.getStr("baseUrl");

    String baseWebUrl = props.getStr("baseWebUrl");

    String baseUCUrl = props.getStr("baseUCUrl");

    String appId = props.getStr("appId");

    String serviceKye = props.getStr("serviceKye");

    String platformType = props.getStr("platformType");

    String appCode = props.getStr("appCode");

    String companyUuid = props.getStr("companyUUID");

    String serviceCode = props.getStr("serviceCode");

    String loginName = props.getStr("loginName");

    String loginPassword = props.getStr("loginPassword");

    String superManagerId = props.getStr("superManagerId");

    String toSealFilePath = props.getStr("toSealFilePath");

    String downloadPath = props.getStr("downloadPath");

}
