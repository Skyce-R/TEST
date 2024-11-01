package com.itrus.contract.demo.other;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Console;
import cn.hutool.crypto.SecureUtil;
import com.itrus.contract.demo.base.BaseTest;
import org.junit.Test;

/**
 * @author pjw
 * @date 2022/12/30/0030
 */
public class PasswordTest extends BaseTest {

    private final String aesKey = "1234567812345678";

    @Test
    public void encryption() {
        String encode = Base64.encode(SecureUtil.aes(aesKey.getBytes()).encrypt("1"));
        Console.log(encode);
        profile.put("password", encode);
        saveProFile();
    }

    @Test
    public void decrypt() {
//        String password = profile.getProperty("password");
        String password = "6ha1jA8GvVF1SUldBKfVUg==";
        String s = SecureUtil.aes(aesKey.getBytes()).decryptStr(Base64.decode(password));
        Console.log(s);
    }

}
