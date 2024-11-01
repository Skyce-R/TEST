package com.itrus.contract.demo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.utils.data.ChineseOrgName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T15_TongyongSyncTest extends BaseTest {

    /**
     * 创建外部企业
     */
    @Test
    public void syncEnterprise() {
        String apiUrl = "/tongyong/sync/enterprise";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("operation", "0")//操作类型：0-新增/修改、2-删除
                .putOpt("ucOrgId", "test-01")  //公司编码
                .putOpt("ucParentOrgId", "test-01")  //上级公司
                .putOpt("name", "test公司04")//公司简称
                .putOpt("fullname", "北京test科技股份有限公司01") //公司全称
                .putOpt("taxpayerId", "EA30635468A6UNCU20") //纳税人登记号
                ;
        JSONObject responseJson = sendPost(apiUrl, requestJson);
    }

    /**
     * 创建部门
     */
    @Test
    public void syncDept() {
        String apiUrl = "/tongyong/sync/dept";
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("operation", "0")//操作类型：0-新增/修改、2-删除
                .putOpt("ucOrgId", "dept-01")  //编码
                .putOpt("ucParentOrgId", "test-01")  //父组织编码
                .putOpt("fullname", "dept-部门-01")//简称
                .putOpt("sequence", "1") //排序
                ;
        JSONObject responseJson = sendPost(apiUrl, requestJson);

    }

    /**
     * 创建用户
     */
    @Test
    public void syncUser() {
        String apiUrl = "/tongyong/sync/user";
        JSONObject duty = JSONUtil.createObj()
                .putOpt("ucUnitOrgId","test-01")  //公司编码
                .putOpt("ucDeptOrgId","dept-01")  //部门编码
                ;
        JSONObject duty2 = JSONUtil.createObj()
                .putOpt("ucUnitOrgId","test-01")  //公司编码
                .putOpt("ucDeptOrgId","dept-02")  //部门编码
                    //工作邮箱
                ;

        List<JSONObject> list = new ArrayList<>();
        list.add(duty);
//        list.add(duty2);
        JSONObject requestJson = JSONUtil.createObj()
                .putOpt("operation", "0")   //操作类型：0-新增/修改、2-删除
                .putOpt("userId", "lishi001")  //员工账号
                .putOpt("fullname", "sb李四001")  //用户名
                .putOpt("idCard", "430101199901011231")//身份证号
                .putOpt("idCardType", "TW") //身份证件类型
                .putOpt("mobile", "13412340001") //手机号
                .putOpt("email", "123001_001@qq.com") //工作邮箱
                .putOpt("duties", list) //岗位信息
                ;
        JSONObject responseJson = sendPost(apiUrl, requestJson);

    }

}
