package com.itrus.contract.demo.vo.req.cert;



public class ApiRaCertConfigReq   {

//    | 名称         | 类型    | 约束 | 描述                                      |
//            | ------------ | ------- | ---- | ----------------------------------------- |
//            | cpaAppid     | String  | 必填 | PCA 应用id（1-64字符）                    |
//            | cpaSecret    | String  | 必填 | PCA 应用秘钥（1-64字符）                  |
//            | serviceUrl   | String  | 必填 | PCA 接口调用地址（1-256字符）             |
//            | accountHash  | String  | 必填 | 阿里云PCA接口必调参数。用于标识客户CA账户 |

//            | useByLable   | Integer | 选填 | 是否应用于默认标签                        |
//            | certName     | String  | 选填 | 证书名称                                  |
//            | certType     | Integer | 选填 | 证书类型                                  |
//            | certSubType  | Integer | 选填 | 证书子类                                  |
//            | keyAlgorithm | String  | 选填 | 证书算法                                  |


    private String cpaAppid;
    private String cpaSecret;
    private String serviceUrl;
    private String accountHash;

    /****/
    private int certType;

    /**证书子类**/
    private int certSubType;

    /**证书算法**/
    private String keyAlgorithm;

    /**证书名称**/
    private String certName;

    /**是否应用于默认标签**/
    private Integer useByLable;

    public String getCpaAppid() {
        return cpaAppid;
    }

    public void setCpaAppid(String cpaAppid) {
        this.cpaAppid = cpaAppid;
    }

    public String getCpaSecret() {
        return cpaSecret;
    }

    public void setCpaSecret(String cpaSecret) {
        this.cpaSecret = cpaSecret;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getAccountHash() {
        return accountHash;
    }

    public void setAccountHash(String accountHash) {
        this.accountHash = accountHash;
    }

    public int getCertType() {
        return certType;
    }

    public void setCertType(int certType) {
        this.certType = certType;
    }

    public int getCertSubType() {
        return certSubType;
    }

    public void setCertSubType(int certSubType) {
        this.certSubType = certSubType;
    }

    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    public void setKeyAlgorithm(String keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public Integer getUseByLable() {
        return useByLable;
    }

    public void setUseByLable(Integer useByLable) {
        this.useByLable = useByLable;
    }
}
