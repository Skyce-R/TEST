package com.itrus.contract.demo.utils.crypto;

import cn.tca.TopBasicCrypto.jce.provider.BouncyCastleProvider;
import cn.topca.security.sm.TopSMProvider;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.*;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.Store;

import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author pjw
 * @date 2022/4/13/0013
 */
public class PKCS7Tools {

    static {
        Security.addProvider(new TopSMProvider());
        Security.addProvider(new BouncyCastleProvider());
    }

    public static byte[] sign(byte[] data, PrivateKey privateKey, Certificate[] chain, String signAlg) throws OperatorCreationException, CertificateEncodingException, CMSException, IOException {
        Store certs = new JcaCertStore(Arrays.asList(chain));

        ContentSigner sha1Signer = new JcaContentSignerBuilder(signAlg)
                .setProvider("BC")
                .build(privateKey);

        CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
        generator.addCertificates(certs);
        generator.addSignerInfoGenerator(
                new JcaSignerInfoGeneratorBuilder(
                        new JcaDigestCalculatorProviderBuilder().setProvider("BC").build())
                        .build(sha1Signer, (X509Certificate) chain[0]));

        CMSTypedData msg = new CMSProcessableByteArray(data);
        CMSSignedData sigData = generator.generate(msg, true);
        return sigData.getEncoded();
    }

    public static String verify(byte[] signData) throws CMSException, CertificateException, OperatorCreationException, IOException {
        CMSSignedData cms = new CMSSignedData(signData);
        Store store = cms.getCertificates();
        SignerInformationStore signers = cms.getSignerInfos();
        Collection c = signers.getSigners();
        for (Object o : c) {
            SignerInformation signer = (SignerInformation) o;
            Collection certCollection = store.getMatches(signer.getSID());

            Iterator certIt = certCollection.iterator();
            X509CertificateHolder certHolder = (X509CertificateHolder) certIt.next();
            X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC").getCertificate(certHolder);
            if (signer.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider("BC").build(cert))) {
                CMSTypedData signedContent = cms.getSignedContent();
                return new String((byte[]) signedContent.getContent());
            }
        }
        return null;
    }

    public static byte[] signMsg(byte[] data, byte[] rsaPrivateKeyBytes) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException, InvalidKeySpecException {
        Signature signature = Signature.getInstance("SHA1WithRSA", "BC");
        signature.initSign(CertTools.getPrivateKey(rsaPrivateKeyBytes));
        signature.update(data);
        return signature.sign();
    }

    public static Boolean verifyMsg(byte[] data, byte[] signMsg, byte[] rsaPublicKeyBytes) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, javax.security.cert.CertificateException, NoSuchProviderException {
        Signature signature = Signature.getInstance("SHA1WithRSA", "BC");
        signature.initVerify(CertTools.getPublicKey(rsaPublicKeyBytes));
        signature.update(data);
        return signature.verify(signMsg);
    }

}
