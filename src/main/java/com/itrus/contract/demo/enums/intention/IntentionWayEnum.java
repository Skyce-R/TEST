package com.itrus.contract.demo.enums.intention;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pjw
 */
@Getter
@AllArgsConstructor
public enum IntentionWayEnum  {

    /**
     * 认证方式
     */
    PHONE(1, "手机验证码验证"),
    SIGN_PASSWORD(2, "签署密码"),
    EMAIL(3, "邮箱验证码验证"),
    FACE_AUTHENTICATION(4, "人脸认证"),
    PIN_CODE_AUTHENTICATION(5, "PIN码认证"),
    ;

    private final int index;
    private final String description;

}
