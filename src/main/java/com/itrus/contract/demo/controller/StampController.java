package com.itrus.contract.demo.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.utils.log.DebugUtils;
import com.itrus.contract.demo.vo.req.signet.CreateAutographReq;
import com.itrus.contract.demo.vo.view.PreStampCreate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
@RestController
@RequestMapping("/stamp")
public class StampController extends BaseTest {

    /**
     * 初始化创建用户
     */
    @GetMapping("/pre/create")
    public ModelAndView createStamp(){
        PreStampCreate vo = new PreStampCreate();
        vo.setUserId(profile.getProperty(userId));
        vo.setAutographName(profile.getProperty(displayName));

        PreStampCreate.SelectData selectData = new PreStampCreate.SelectData();
        vo.setSelectData(selectData);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createStamp");
        modelAndView.addObject("entity", vo);

        return modelAndView;
    }

    /**
     * 创建签名
     */
    @PostMapping("/create")
    public String createUser(@RequestBody CreateAutographReq req){
        JSONObject reqJson = JSONUtil.parseObj(req);
        JSONObject jsonObject = sendPost(ApiUrl.CREATE_AUTOGRAPH, reqJson);
        if (isOk(jsonObject)) {
            JSONObject data = jsonObject.getJSONObject("data");
            profile.put(autographId, data.getStr(autographId));
            saveProFile();
        }

        return JSONUtil.createObj().putOpt("reqMsg", reqJson).putOpt("respMsg", jsonObject).putOpt("status", jsonObject.get("status")).toStringPretty();
    }

}
