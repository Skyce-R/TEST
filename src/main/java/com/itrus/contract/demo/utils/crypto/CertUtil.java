package com.itrus.contract.demo.utils.crypto;

import cn.com.itrus.itext.enums.DigestAlgEnum;
import cn.com.itrus.itext.tools.CertTools;
import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.springframework.util.Base64Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author pjw
 * @date 2022/10/25/0025
 */
@Slf4j
public class CertUtil {

    /**
     * 根据公钥生成证书
     */
    public static X509Certificate getCertificate(String publicKey) {
        X509Certificate certificate = null;
        try {
            //转换成二进制流
            certificate = CertTools.getInstance(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificate;
    }

    public static String getSn(String publicKey) {
        X509Certificate certificate = CertUtil.getCertificate(publicKey);
        return certificate.getSerialNumber().toString(16).toUpperCase();
    }

    public static String getIssuer(String publicKey) {
        X509Certificate certificate = CertUtil.getCertificate(publicKey);
        return certificate.getIssuerDN().getName();
    }

    public static String getSubject(String publicKey) {
        X509Certificate certificate = CertUtil.getCertificate(publicKey);
        return certificate.getSubjectDN().getName();
    }

    /**
     * 校验证书是否过期
     */
    public static void checkCertificateExpired(X509Certificate certificate) {
        try {
            certificate.checkValidity(new Date());
        } catch (CertificateExpiredException | CertificateNotYetValidException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取过期时间
     */
    public static LocalDateTime getCertificateNorBeforeTime(X509Certificate certificate){
        return Instant.ofEpochMilli(certificate.getNotBefore().getTime()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 获取过期时间
     */
    public static LocalDateTime getCertificateExpirationTime(X509Certificate certificate){
        return Instant.ofEpochMilli(certificate.getNotAfter().getTime()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 获取过期时间 date
     */
    public static LocalDateTime getCertificateExpirationTime(Date time){
        return Instant.ofEpochMilli(time.getTime()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 获取证书算法名称
     */
    public static DigestAlgEnum getSigAlgName(X509Certificate certificate) {
        DigestAlgEnum digestAlgEnum = DigestAlgEnum.SHA256;
        String sigAlgName = certificate.getSigAlgName();
        if(ObjectUtil.isNotEmpty(sigAlgName)){
            if(sigAlgName.toUpperCase().contains("RSA")){
                if(sigAlgName.toUpperCase().contains("SHA1")){
                    digestAlgEnum = DigestAlgEnum.SHA1;
                }
            }
            if(sigAlgName.toUpperCase().contains("SM3")){
                digestAlgEnum = DigestAlgEnum.SM3;
            }
        }
        return digestAlgEnum;
    }

    /**
     * 转换sm2签名值
     */
    public static String convertSm2(String signedHash) {
        byte[] r64 = new byte[0];
        byte[] s64 = new byte[0];
        try {
            ASN1Sequence seq = (ASN1Sequence) ASN1Sequence.fromByteArray(Base64Utils.decodeFromString(signedHash));
            ASN1Integer r = (ASN1Integer) seq.getObjectAt(0);
            ASN1Integer s = (ASN1Integer) seq.getObjectAt(1);

            r64 = new byte[64];
            int len = r.getPositiveValue().toByteArray().length;
            System.arraycopy(r.getPositiveValue().toByteArray(), 0, r64, 64 - len, len);
            s64 = new byte[64];
            len = s.getPositiveValue().toByteArray().length;
            System.arraycopy(s.getPositiveValue().toByteArray(), 0, s64, 64 - len, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] join = join(r64, s64);
        return Base64Utils.encodeToString(join);
    }

    private static byte[] join(byte[]... params) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] res = null;
        try {
            for (int i = 0; i < params.length; i++) {
                baos.write(params[i]);
            }
            res = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
