package com.itrus.contract.demo.utils.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;

/**
 * 创建者 pjw
 * 日期 2020/7/15 0015
 */
public class HmacSha1Util {

    public static String getSignature(String content, String key) {
        HMac hMac = new HMac(HmacAlgorithm.HmacSHA1, key.getBytes());
        return Base64.encode(hMac.digest(content));
    }
}
