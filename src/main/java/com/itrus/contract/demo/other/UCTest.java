package com.itrus.contract.demo.other;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.utils.data.ChineseName;
import com.itrus.contract.demo.utils.data.IdCardNum;
import com.itrus.contract.demo.utils.data.Mobile;
import org.junit.Test;

/**
 * 用户中心api
 * @author pjw
 * @date 2023/1/6/0006
 */
public class UCTest extends BaseTest {

    /**
     * 创建用户
     */
    @Test
    public void addTempUser() {
        String apiUrl = "/userApi/addTempUser";
        String name = "尚若清10";
        String phone = "13907972644";
        //L02117R5FXXQKP1
        name = new ChineseName().toString();
        phone = new Mobile().toString();
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("name", name)
                .putOpt("phone", phone)
                ;
        sendPost(configUtil.getBaseUCUrl(), apiUrl, requestJson);
    }

    /**
     * 创建用户
     */
    @Test
    public void getCompanyInfo() {
        String apiUrl = "/contractApproval/callbackContract";
        String name = "尚若清10";
        String phone = "13907972644";
        //L02117R5FXXQKP1
        name = new ChineseName().toString();
        phone = new Mobile().toString();
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("name", name)
                .putOpt("phone", phone)
                ;
        sendPost(configUtil.getBaseUCUrl(), apiUrl, requestJson);
    }

}
