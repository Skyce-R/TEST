package com.itrus.contract.demo.other;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.utils.crypto.AesUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pjw
 * @date 2023/5/30/0030
 */
public class AesTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("/apigate/contractapi/user/create");
        list.add("/apigate/contractapi/user/update");
        JSONArray jsonArray = JSONUtil.parseArray(list);
        String test = jsonArray.toString();
        String data = AesUtil.encrypt(test);
        System.out.println("原文："+test);
        System.out.println("密文："+data);
        System.out.println("解密："+AesUtil.desEncrypt(data));
    }
}
