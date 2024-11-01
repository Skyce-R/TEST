package com.itrus.contract.demo.utils.crypto;

import javax.security.cert.X509Certificate;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @author pjw
 * @date 2022/3/31/0031
 */
public class CertTools {

    public static byte[] getPrivateKeyEncode(String pfxPath, String password) throws Exception {
        return getPrivateKeyEncode(new FileInputStream(pfxPath), password.toCharArray());
    }

    public static PrivateKey getPrivateKey(InputStream in, char[] password) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(in, password);

        String alias = ks.aliases().nextElement();
        return (PrivateKey) ks.getKey(alias, password);
    }

    public static byte[] getPrivateKeyEncode(InputStream in, char[] password) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException {
        PrivateKey pk = getPrivateKey(in, password);
        return pk.getEncoded();
    }

    public static PrivateKey getPrivateKey(byte[] privateKeyEncoded) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyEncoded);
        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

    public static Certificate[] getCertificate(InputStream in, char[] password) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(in, password);
        String alias = ks.aliases().nextElement();
        return ks.getCertificateChain(alias);
    }

    public static byte[] getCertificate(String cerPath) throws FileNotFoundException, javax.security.cert.CertificateException {
        return getCertificate(new FileInputStream(cerPath));
    }

    public static byte[] getCertificate(InputStream in) throws javax.security.cert.CertificateException {
        X509Certificate signer = X509Certificate.getInstance(in);
        return signer.getEncoded();
    }

    public static PublicKey getPublicKey(byte[] certBytes) throws javax.security.cert.CertificateException {
        X509Certificate x509Certificate = X509Certificate.getInstance(new ByteArrayInputStream(certBytes));
        return x509Certificate.getPublicKey();
    }

}
