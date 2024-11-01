package com.itrus.contract.demo.utils;

import java.security.SecureRandom;

/**
 * @author pjw
 * @date 2021/12/2/0002
 */
public class UUIDUtil {

    private static final Integer DEFAULT_RADIX = 36;

    /**
     * uuid : centerUuid + 36进制雪花ID
     * <p>
     * 雪花ID： 符号位(1bit) - 时间戳(33bit=272年) - 机器ID(5bit,值:0~31) - 数据标识ID(5bit,值0~31) - 秒内序列(20bit,1048576个)
     * <p>
     * 判断是否企业id：uuid去掉centerUuid 前缀之后，获取十进制的雪花id
     * 企业唯一标识设置数据标识ID为1，十进制雪花ID右移20位 然后 & ~(-1L << 5)) 获取数据标识ID的5bit
     *
     * @param uuid       企业唯一标识
     * @param centerUuid 数据中心唯一标识
     * @return
     */
    public static boolean isCompanyUuid(String uuid, String centerUuid) {
        String subUuid = uuid.substring(centerUuid.length());
        try{
            long id = Long.parseLong(subUuid, DEFAULT_RADIX);
            return 1 == ((id >> 20) & ~(-1L << 5));
        }catch (NumberFormatException e){
            // unreach ignore
        }
        return false;
    }

    public static String randomPassword() {
        SecureRandom random = new SecureRandom();
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()_+-=[]{}|;':\"<>?,./";
        String characterSet = uppercaseLetters + lowercaseLetters + numbers + specialCharacters;
        StringBuilder passwordBuilder = new StringBuilder();

        int length = 10; // 密码长度

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            char randomChar = characterSet.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }

        return passwordBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "L53Z8AMRBX48GJ";
        String s1 = "L53Z8ANVS1AVVL";
        System.out.println(isCompanyUuid(s, "L53"));
        System.out.println(isCompanyUuid(s1, "L53"));
    }

}
