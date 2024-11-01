package com.itrus.contract.demo.utils.crypto;

import cn.hutool.core.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author pjw
 * @date 2023/5/30/0030
 */
public class AesUtil {

    /**
     * 使用AES-128-CBC加密模式，key需要为16位,key和iv可以相同！
     */
    private static final String KEY = "crypt20230112key";
    private static final String IV = "crypt20230112-iv";

    /**
     * 加密方法
     * @param data  要加密的数据
     * @param key 加密key
     * @param iv 加密iv
     * @return 加密的结果
     */
    public static String encrypt(String data, String key, String iv) {
        try {
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return Base64.encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密方法
     * @param data 要解密的数据
     * @param key  解密key
     * @param iv 解密iv
     * @return 解密的结果
     */
    public static String desEncrypt(String data, String key, String iv) {
        try {
            byte[] encrypted1 = Base64.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            //转载其他文章发现这里没有trim，而在外部调用时trim，个人觉得没有必要
            return new String(original).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用默认的key和iv加密
     */
    public static String encrypt(String data) {
        return encrypt(data, KEY, IV);
    }

    /**
     * 使用默认的key和iv解密
     */
    public static String desEncrypt(String data) {
        return desEncrypt(data, KEY, IV);
    }

}
