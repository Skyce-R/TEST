package com.itrus.contract.demo.constant;

/**
 * @author pjw
 * @date 2023/8/10/0010
 */
public class ApiUrl {

    /**
     * 1、用户接口
     */
    public static final String CREATE_PERSON = "/user/create";
    public static final String UPDATE_PERSON = "/user/update";
    public static final String INITIATION = "/upgrade/initiation";
    public static final String USER_DETAILS = "/user/userDetails";
    public static final String USER_LIST = "/user/pageQuery";
    public static final String JOIN_ENTERPRISE = "/user/joinEnterprise";
    public static final String REMOVE_ENTERPRISE_USER = "/user/removeUserEnterprise";
    public static final String RESET_PASSWORD = "/user/resetPassword";

    public static final String CREATE_LEGAL_SEAL_SIGN = "/enterprise/createLegalSealAndSign";

    /**
     * 2、企业接口
     */
    public static final String CREATE_ENTERPRISE = "/enterprise/create";
    public static final String UPDATE_ENTERPRISE = "/enterprise/update";
    public static final String ADD_OR_MODIFY_ADMIN = "/enterprise/addOrModifyAdmin";
    public static final String ADD_SUB_COMPANY = "/enterprise/addSubCompany";
    public static final String ENTERPRISE_PAGE = "/enterprise/pageQuery";
    public static final String ENTERPRISE_DETAILS = "/enterprise/orgDetails";
    public static final String CHANGE_LEGAL = "/enterprise/changeLegal";
    public static final String BIND_LEGAL = "/enterprise/bindLegal";

    /**
     * 3、意愿认证接口
     */
    public static final String INTENTION_LAUNCH = "/intention/launchIntention";
    public static final String INTENTION_VERIFY = "/intention/verifyIntention";

    /**
     * 4、实名接口
     */
    public static final String USER_REAL_NAME = "/user/realName";
    public static final String ENTERPRISE_REAL_NAME = "/enterprise/realName";
    public static final String ENTERPRISE_VERIFY_PAY_BANK = "/enterprise/verifyPayBank";
    public static final String START_USER_PAGE_AUTH = "/pageAuth/startUserPageAuth";
    public static final String START_ENTERPRISE_PAGE_AUTH = "/pageAuth/startEnterprisePageAuth";
    public static final String PROVINCE_LIST = "/bankProvince/provinceList";
    public static final String CITY_LIST = "/bankProvince/cityList";
    public static final String BANK_LIST = "/bankProvince/bankList";
    public static final String BRANCH_BANK_LIST = "/bankProvince/branchBankList";

    /**
     * 5、证书接口
     */
    public static final String USER_APPLY_CERT = "/user/applyCert";
    public static final String CERT_QUERY = "/cert/query";
    public static final String SAVE_AUTHORIZATION_RECORD = "/authorizationRecord/saveAuthorizationRecord";
    public static final String START_AUTHORIZATION_PAGE = "/authorizationRecord/startAuthorizationPage";

    /**
     * 6、签名接口
     */
    public static final String CREATE_AUTOGRAPH = "/user/createAutograph";
    public static final String STAMP_LIST = "/stamp/stampList";
    public static final String DELETE_STAMP = "/stamp/deleteStamp";

    /**
     * 7、印章类
     */
    public static final String CREATE_SEAL = "/enterprise/createSeal";
    public static final String CREATE_LEGAL_SEAL = "/enterprise/createLegalSeal";
    public static final String SEAL_STATUS_MANAGER = "/seal/sealStatusManager";
    public static final String DELETE_SEAL = "/seal/deleteSeal";
    public static final String AUTH_SEAL = "/user/authSeal";
    public static final String CANCEL_AUTH_SEAL = "/user/cancelAuthSeal";
    public static final String SEAL_LIST = "/seal/sealList";
    public static final String PAGE_SIGN_URL = "/pageSign/getPageSignUrl";

    /**
     * 8、模板接口
     */
    public static final String TEMPLATE_CREATE = "/template/createTemplate";
    public static final String TEMPLATE_SET_SIGN_CONTROLS = "/template/setSignControls";
    public static final String TEMPLATE_UPLOAD_FILE = "/template/uploadFile";
    public static final String TEMPLATE_STATUS = "/template/templateStatus";
    public static final String TEMPLATE_DETAILS = "/template/templateDetails";
    public static final String TEMPLATE_UPDATE = "/template/updateTemplate";

    /**
     * 9、合同接口
     */
    public static final String CONTRACT_CREATE_BY_FILE = "/contract/createByFile";
    public static final String CONTRACT_ADD_SIGNER_BY_FILE = "/contract/addSignerByFile";
    public static final String CONTRACT_CREATE_BY_TEMPLATE = "/contract/createByTemplate";
    public static final String CONTRACT_ADD_SIGNER_BY_TEMPLATE = "/contract/addSignerByTemplate";
    public static final String CONTRACT_SIGN_BY_FILE = "/contract/signByFile";
    public static final String START_SIGN_BY_FILE = "/pageSign/startSignByFile";
    public static final String START_SIGN_BY_FILE_TEMPLATE = "/pageSign/startSignByTemplateFile";


    public static final String CONTRACT_UPLOAD_FILE = "/contract/uploadFile";
    public static final String CONTRACT_DOWNLOAD = "/contract/downloadContract";
    public static final String CONTRACT_SEARCH = "/contract/search";
    public static final String CONTRACT_OPERATE_CONTRACT_STATUS = "/contract/operateContractStatus";
    public static final String CONTRACT_URGE_SIGN = "/contract/urgeSign";
    public static final String CONTRACT_ADD_CC = "/contract/addContractCc";
    public static final String CONTRACT_VERIFY = "/contract/verifyContract";
    public static final String CONTRACT_DELETE_CONTRACT = "/contract/deleteContract";
    public static final String CONTRACT_LAUNCH_NULLIFY = "/contract/launchNullify";
    public static final String CONTRACT_CONFIRM_NULLIFY = "/contract/confirmNullify";
    public static final String CONTRACT_GET_CONFIRM_NULLIFY_URL = "/contract/getConfirmNullifyUrl";

    /**
     * 10、客户端证书(UKey)接口
     */
    public static final String BIND = "/contract/bindUkey";
    public static final String GET_SIGN_DATA = "/ukeyCert/getSignData";
    public static final String SIGN_BY_UKEY = "/ukeyCert/signByUkey";
    public static final String OFD_GET_OFD_SEAL_HASH = "/ofdUkey/getOfdSealHash";
    public static final String OFD_BUILD_OFD_SEAL = "/ofdUkey/buildOfdSeal";
    public static final String OFD_CONTRACT_HASH = "/ofdUkey/ofdContractHash";
    public static final String OFD_BUILD_OFD_CONTRACT = "/ofdUkey/buildOfdContract";

    /**
     * 11、见证接口
     */
    public static final String CONTRACT_SOLIDIFY = "/law/solidify";
    public static final String APPLY_OBTAIN_EVIDENCE_REPORT = "/law/applyObtainEvidenceReport";
    public static final String WITNESS_REPORT = "/law/getWitnessReport";
    /**
     * 获取存证报告
     */
    public static final String LAW_GET_EXISTING_REPORT = "/law/getExistingReport";
    public static final String OBTAIN_EVIDENCE_REPORT = "/law/getObtainEvidenceReport";
    public static final String LEGAL_INSTRUMENT = "/law/getLegalInstrument";
    public static final String SOLIDIFY_MSG = "/law/getSolidifyMsg";

    /**
     * 12、数据签名接口
     */
    public static final String DATA_SIGN = "/digestSign/dataSign";
    public static final String DIGEST_VERIFY = "/digestSign/digestVerify";

}
