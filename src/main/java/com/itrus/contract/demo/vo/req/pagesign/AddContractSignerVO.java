package com.itrus.contract.demo.vo.req.pagesign;

import com.itrus.contract.demo.vo.req.contract.addSignerByFile.SignFileApiVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class AddContractSignerVO {
    /**
     * 签署人类型：1个人、2企业
     */
    private Integer signerType;

    /**
     * 签署人用户id，签署人可以未实名
     */
    private String userId;

    /**
     * 签署人公司ID（当签署人类型为企业时，必填）
     */
    private String  enterpriseId;

    /**
     * 是否要做意愿认证
     */
    private Boolean isUserWishes = false;

    /**
     * 签署人顺序（签署顺序1-100之间）
     */
    private Integer sequence = 1;

    /**
     * 是否发送短信通知到诚信签-前置系统签署,false不发送(默认)、true发送
     */
    private Boolean sendMsg = false;

    /**
     * 是否指定签署位置,设置签署控件
     */
    private Boolean setting = true;

    /**
     * 不设置控件,签署时的控件类型范围;当setting为false时,该参数为必填
     */
    private Set<String> controlsType;


    /**
     * 签署人要签署的合同文件
     * @required
     */
    private List<SignFileApiVO> signFiles;


}
