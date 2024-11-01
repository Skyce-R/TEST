package com.itrus.contract.demo.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.CertificateTypeEnum;
import com.itrus.contract.demo.enums.account.UserEnterpriseLabelEnum;
import com.itrus.contract.demo.utils.data.ChineseName;
import com.itrus.contract.demo.utils.data.IdCardNum;
import com.itrus.contract.demo.utils.data.Mobile;
import com.itrus.contract.demo.utils.data.Now;
import com.itrus.contract.demo.vo.req.user.CreatePersonReq;
import com.itrus.contract.demo.vo.view.PreUserCreate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pjw
 * @date 2023/8/15/0015
 */
@RestController
@RequestMapping("/user")
public class PersonController extends BaseTest {

    /**
     * 初始化创建用户
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

    /**
     * 创建用户
     */
    @PostMapping("/create")
    public String createUser(@RequestBody CreatePersonReq req){
        JSONObject reqJson = JSONUtil.parseObj(req);
        JSONObject jsonObject = sendPost(ApiUrl.CREATE_PERSON, reqJson);
        if (isOk(jsonObject)) {
            JSONObject data = jsonObject.getJSONObject("data");
            profile.put(userId, data.getStr(userId));
            profile.put(displayName, req.getDisplayName());
            profile.put(phone, req.getPhone());
            profile.put(idCardNum, req.getIdCardNum());
            saveProFile();
        }
        return JSONUtil.createObj().putOpt("reqMsg", reqJson).putOpt("respMsg", jsonObject).putOpt("status", jsonObject.get("status")).toStringPretty();
    }

}
