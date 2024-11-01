package com.itrus.contract.demo.utils.thread;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.utils.data.ChineseName;
import com.itrus.contract.demo.utils.data.IdCardNum;
import com.itrus.contract.demo.utils.data.Mobile;

import java.util.concurrent.Callable;

/**
 * @author pjw
 * @date 2022/12/7/0007
 */
public class CallableTask extends BaseTest implements Callable<Integer> {

    private int a;
    public CallableTask(int a) {
        this.a = a;
    }
    @Override
    public Integer call() {
        for (int i = 0; i < 20; i++) {
            String apiUrl = "/user/create";
            String name = new ChineseName().toString();
            String idCardNum = new IdCardNum().toString();
            String phone = new Mobile().toString();
            JSONObject requestJson = JSONUtil.createObj()
                    .putOpt("type", 1)
                    .putOpt("phone", phone)
                    .putOpt("authentication", true)
                    .putOpt("displayName", name)
                    .putOpt("idCardNum", idCardNum)
                    .putOpt("idCardType", "0")
                    ;
            sendPost(apiUrl, requestJson);
        }
        return null;
    }

}
