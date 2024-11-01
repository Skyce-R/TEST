package com.itrus.contract.demo.vo.req.contract.addSignerByFile;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author pjw
 * @date 2022/10/4/0004
 */
@Data
public class AddSignerApiVO  {

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
    private String enterpriseId;

    /**
     * 是否要做意愿认证
     */
    private Boolean isUserWishes;


    private List<Integer> userWishesWay = new ArrayList<>();

    /**
     * 签署人顺序（签署顺序1-100之间）
     */
    private Integer sequence;

    /**
     * 是否发送短信通知到诚信签-前置系统签署,false不发送(默认)、true发送
     */
    private Boolean sendMsg;

    /**
     * 是否指定签署位置,设置签署控件
     */
    private Boolean setting;

    /**
     * 不设置控件,签署时的控件类型范围;当setting为false时,该参数为必填
     */
    private Set<String> controlsType;

    /**
     * 签署人要签署的合同文件
     */
    private List<SignFileApiVO> signFiles;

    /**
     * 签署时是否可编辑控件
     */
    private Boolean updateControlAtSign;

    /**
     * 签署时是否需要弹窗提示信息
     */
    private Boolean toastRead;

}
