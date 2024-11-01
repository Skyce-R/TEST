package com.itrus.contract.demo.controller;

import cn.hutool.core.util.IdUtil;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.CertificateTypeEnum;
import com.itrus.contract.demo.enums.account.UserEnterpriseLabelEnum;
import com.itrus.contract.demo.utils.data.ChineseName;
import com.itrus.contract.demo.utils.data.IdCardNum;
import com.itrus.contract.demo.utils.data.Mobile;
import com.itrus.contract.demo.utils.data.Now;
import com.itrus.contract.demo.vo.view.PreUserCreate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
@RestController
@RequestMapping("/contract")
public class ContractController {

    /**
     * 初始化创建合同
     */
    @GetMapping("/pre/create")
    public ModelAndView createUser(){
        PreUserCreate vo = new PreUserCreate();
        vo.setDisplayName(new ChineseName().toString());
        vo.setUserLabel(UserEnterpriseLabelEnum.PERSON.getCode());
        vo.setPhone(new Mobile().toString());
        vo.setEmail(new Now().toString() + ParamConstant.MAIL_SUFFIX);
        vo.setIdCardNum(new IdCardNum().toString());
        vo.setAccount(IdUtil.randomUUID());
        vo.setOtherCardName(CertificateTypeEnum.OTHER.getDescription());

        PreUserCreate.SelectData selectData = new PreUserCreate.SelectData();
        vo.setSelectData(selectData);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createUser");
        modelAndView.addObject("entity", vo);

        return modelAndView;
    }

}
