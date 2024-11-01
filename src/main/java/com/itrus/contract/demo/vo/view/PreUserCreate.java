package com.itrus.contract.demo.vo.view;

import com.itrus.contract.demo.enums.account.AccountTypeEnum;
import com.itrus.contract.demo.enums.account.AuthenticationEnum;
import com.itrus.contract.demo.enums.account.CertificateTypeEnum;
import com.itrus.contract.demo.enums.account.UserTypeEnum;

/**
 * @author pjw
 * @date 2023/8/15/0015
 */
public class PreUserCreate {

    private String displayName;
    private String idCardType;
    private String idCardNum;
    private String otherCardName;
    private Integer type;
    private String phone;
    private String account;
    private String email;
    private String passwd;
    private Boolean authentication;
    private String userLabel;
    private SelectData selectData;

    public static class SelectData {
        public AccountTypeEnum[] getAccountTypeList() {
            return AccountTypeEnum.values();
        }
        public CertificateTypeEnum[] getCertificateTypeList() {
            return CertificateTypeEnum.getList(UserTypeEnum.PERSON);
        }
        public AuthenticationEnum[] getAuthenticationList() {
            return AuthenticationEnum.values();
        }
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getOtherCardName() {
        return otherCardName;
    }

    public void setOtherCardName(String otherCardName) {
        this.otherCardName = otherCardName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Boolean getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Boolean authentication) {
        this.authentication = authentication;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public SelectData getSelectData() {
        return selectData;
    }

    public void setSelectData(SelectData selectData) {
        this.selectData = selectData;
    }
}
