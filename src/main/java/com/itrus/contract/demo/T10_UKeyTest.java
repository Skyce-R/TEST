package com.itrus.contract.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.enums.account.UserTypeEnum;
import com.itrus.contract.demo.enums.cert.CertTypeEnum;
import com.itrus.contract.demo.enums.ukey.SignatureTypeEnum;
import com.itrus.contract.demo.enums.ukey.UkeyBindOperationEnum;
import com.itrus.contract.demo.vo.req.contract.signByFile.ControlValueApiVO;
import com.itrus.contract.demo.vo.req.contract.signByFile.SignSignerApiVO;
import com.itrus.contract.demo.vo.req.contract.signByFile.SignSignerFileApiVO;
import com.itrus.contract.demo.vo.req.ofdUkey.BuildOfdSealApiReq;
import com.itrus.contract.demo.vo.req.ofdUkey.GetOfdSignetHashApiReq;
import com.itrus.contract.demo.vo.req.ukey.BindApiReq;
import com.itrus.contract.demo.vo.req.ukey.BuildApiReq;
import com.itrus.contract.demo.vo.req.ukey.GetSignDataApiReq;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.ofdUkey.GetOfdSignetHashApiResp;
import com.itrus.contract.demo.vo.resp.ukey.GetSignDataResp;
import com.itrus.contract.demo.vo.view.DocumentHashVO;
import com.itrus.contract.demo.vo.view.HashVO;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 十、客户端证书(UKey)接口
 * @author pjw
 * @date 2022/8/11/0011
 */
public class T10_UKeyTest extends BaseTest {

    /**
     * 10.1、绑定客户端证书
     */
    @Test
    public void bind() {
//        Map<String, Object> keyPair = getKeyPair();
//        String certEncoded = (String) keyPair.get(keyPairCertEncoded);

//        String publicKey = getPublicKeyFromCer("诚信签前置项目公司-签名证书.cer");
//        String publicKey = getPublicKeyFromCer("张三法人-签名证书.cer");
        Map<String, Object> keyPair = getPublicKeyFromPfx("诚信签前置项目公司-签名证书.pfx","1q2w3e4r");
        String certEncoded = (String) keyPair.get(keyPairCertEncoded);
        BindApiReq req = new BindApiReq();
        req.setUserId("L02194JYTMNH1C5");
        req.setEnterpriseId("M01193NSTILM0RX");
        req.setCertType(CertTypeEnum.ENTERPRISE.getIndex());
        req.setOperation(UkeyBindOperationEnum.BIND.getIndex());
        req.setPublicKey(certEncoded);

        sendPost(ApiUrl.BIND, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 10.2、获取待签名原文
     */
    @Test
    public void getSignData() {
        Map<String, Object> keyPair = getPublicKeyFromPfx("诚信签前置项目公司-签名证书.pfx","1q2w3e4r");
        String certEncoded = (String) keyPair.get(keyPairCertEncoded);
//        String publicKey = getPublicKeyFromCer("张三法人-签名证书.cer");
//        String publicKey = getPublicKeyFromCer("诚信签前置项目公司-签名证书.cer");

        GetSignDataApiReq req = new GetSignDataApiReq();
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));

        SignSignerApiVO signer = new SignSignerApiVO();
        signer.setSignerId(Long.parseLong(profile.getProperty(signerId)));
//        signer.setIntentionId(profile.getProperty(intentionId));
        signer.setIntentionId("167798541937279041");

        List<SignSignerFileApiVO> signFiles = new ArrayList<>();
        SignSignerFileApiVO signFile = new SignSignerFileApiVO();
        signFile.setDocId(Long.parseLong(profile.getProperty(contractDocId)));

        List<ControlValueApiVO> controlValues = new ArrayList<>();
        ControlValueApiVO controlValue = new ControlValueApiVO();
        controlValue.setControlsId(1L);
//        controlValue.setStampId(Long.parseLong(profile.get(autographId).toString()));
//        controlValue.setSealId(Long.parseLong(profile.get(sealId).toString()));
        controlValue.setSealId(165282624720339024L);
        controlValues.add(controlValue);
        signFile.setControlValues(controlValues);

        signFile.setFonts(getSignFonts(1));

        signFile.setShowTimestamp(true);
        signFile.setSealTimestamp(getSealTimeStampStyle());

        signFiles.add(signFile);
        signer.setSignFiles(signFiles);
        req.setSigner(signer);
        req.setPublicKey(certEncoded);

        BaseResp<GetSignDataResp> resp = sendPost(ApiUrl.GET_SIGN_DATA, JSONUtil.parseObj(req), new GetSignDataResp());
        if (isOk(resp)) {
            List<DocumentHashVO> ukeyHashList = resp.getData().getUkeyHashList();
            for (DocumentHashVO documentHashVO : ukeyHashList) {
                HashVO ukeyHash = documentHashVO.getUkeyHash();
                profile.put(hash, ukeyHash.getHash());
                profile.put(intermediateData,ukeyHash.getIntermediateData());


               try {
                   Signature signature = Signature.getInstance(SignatureTypeEnum.Sha256WithRsa.getCode());
                   signature.initSign((PrivateKey) keyPair.get(keyPairPrivateKey));
                   signature.update(Base64.decode(ukeyHash.getHash()));
                   profile.put("signedHash", Base64.encode(signature.sign()));
               }catch (Exception ex){
                   ex.printStackTrace();
               }
//                profile.put(signedHash,ukeyHash.getSignedHash());
            }
            saveProFile();
        }
    }

    /**
     * 10.3、签名值合成
     *
     */
    @Test
    public void signByUkey() {
        BuildApiReq req = new BuildApiReq();
        req.setContractId(Long.parseLong( profile.getProperty(contractId)));
        req.setSignerId(Long.parseLong(profile.getProperty(signerId)));

        DocumentHashVO documentHashVO = new DocumentHashVO();
        documentHashVO.setDocId(profile.getProperty(contractDocId));
        HashVO hashVO = new HashVO();
        hashVO.setHash(profile.getProperty(hash));
        hashVO.setIntermediateData(profile.getProperty(intermediateData));
        hashVO.setSignedHash(profile.getProperty(signedHash));
        documentHashVO.setUkeyHash(hashVO);
        req.setUkeyHashList(Collections.singletonList(documentHashVO));

        sendPost(ApiUrl.SIGN_BY_UKEY, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 10.4、获取OFD签章待签署hash
     */
    @Test
    public void getOfdSignetHash() {
        Map<String, Object> keyPair = getKeyPair();
        String certEncoded = (String) keyPair.get(keyPairCertEncoded);

        GetOfdSignetHashApiReq req = new GetOfdSignetHashApiReq();
        req.setUserId(profile.getProperty(userId));
        req.setSignatureId(Long.parseLong( profile.getProperty(autographId)));
        req.setSignatureType(UserTypeEnum.PERSON.getIndex());
        req.setCertBase64(certEncoded);

        BaseResp<GetOfdSignetHashApiResp> resp = sendPost(ApiUrl.OFD_GET_OFD_SEAL_HASH, JSONUtil.parseObj(req), new GetOfdSignetHashApiResp());
        if (isOk(resp)) {
            GetOfdSignetHashApiResp data = resp.getData();
            profile.put(hash, data.getHash());
            saveProFile();
        }
    }

    /**
     * 10.5、OFD印章合成
     */
    @Test
    public void buildOfdSeal() {
        BuildOfdSealApiReq req = new BuildOfdSealApiReq();
        req.setSignatureId(Long.parseLong(profile.getProperty(autographId)));
        req.setSignedHash(profile.getProperty(signedHash));

        sendPost(ApiUrl.OFD_BUILD_OFD_SEAL, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 10.6、OFD签署获取待签名原文
     */
    @Test
    public void getOfdSignData() {
        Map<String, Object> keyPair = getKeyPair();
        String certEncoded = (String) keyPair.get(keyPairCertEncoded);

        ControlValueApiVO controlValue = new ControlValueApiVO();
        controlValue.setControlsId(1L);
        controlValue.setStampId(Long.parseLong(profile.getProperty(autographId)));
        controlValue.setText("文本");

        ControlValueApiVO controlValue2 = new ControlValueApiVO();
        controlValue.setControlsId(2L);
        controlValue.setStampId(Long.parseLong(profile.getProperty(autographId)));
        controlValue.setText("文本2");

        List<ControlValueApiVO> controlValues = new ArrayList<>();
        controlValues.add(controlValue);
        controlValues.add(controlValue2);

        SignSignerFileApiVO signFile = new SignSignerFileApiVO();
        signFile.setDocId(Long.parseLong(profile.getProperty(contractDocId)));
        signFile.setControlValues(controlValues);

        SignSignerApiVO signer = new SignSignerApiVO();
        signer.setSignerId(Long.parseLong(signerId));
        signer.setSignFiles(Collections.singletonList(signFile));

        GetSignDataApiReq req = new GetSignDataApiReq();
        req.setSigner(signer);
        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setPublicKey(certEncoded);

        BaseResp<GetSignDataResp> resp = sendPost(ApiUrl.OFD_CONTRACT_HASH, JSONUtil.parseObj(req), new GetSignDataResp());
        if (isOk(resp)) {
            GetSignDataResp data = resp.getData();
            for (DocumentHashVO documentHashVO : data.getUkeyHashList()) {
                HashVO ukeyHash = documentHashVO.getUkeyHash();
                profile.put(hash, ukeyHash.getHash());
                profile.put(intermediateData, ukeyHash.getIntermediateData());
            }
            saveProFile();
        }
    }

    /**
     * 10.7、OFD签名值合成
     */
    @Test
    public void signByOfdClientCert() {
        BuildApiReq req = new BuildApiReq();

        HashVO hashVO = new HashVO();
        hashVO.setHash(profile.getProperty(hash));
        hashVO.setIntermediateData(profile.getProperty(intermediateData));
        hashVO.setSignedHash(profile.getProperty(signedHash));

        DocumentHashVO documentHashVO = new DocumentHashVO();
        documentHashVO.setDocId( profile.getProperty(contractDocId));
        documentHashVO.setUkeyHash(hashVO);

        List<DocumentHashVO> ukeyHashList = new ArrayList<>();
        ukeyHashList.add(documentHashVO);

        req.setContractId(Long.parseLong(profile.getProperty(contractId)));
        req.setSignerId(Long.parseLong(profile.getProperty(signerId)));
        req.setUkeyHashList(ukeyHashList);

        sendPost(ApiUrl.OFD_BUILD_OFD_CONTRACT, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 客户端签署
     */
    @Test
    public void clientSign() throws Exception {
        Map<String, Object> keyPair = getKeyPair();
        Signature signature = Signature.getInstance(SignatureTypeEnum.Sha256WithRsa.getCode());
        signature.initSign((PrivateKey) keyPair.get(keyPairPrivateKey));
        signature.update(Base64.decode(profile.getProperty(hash)));
        profile.put("signedHash", Base64.encode(signature.sign()));
        saveProFile();
        System.out.println(profile.getProperty(signedHash));
    }

}
