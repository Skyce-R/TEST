package com.itrus.contract.demo;

import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.signet.*;
import com.itrus.contract.demo.vo.req.signet.CreateAutographReq;
import com.itrus.contract.demo.vo.req.signet.DelStampReq;
import com.itrus.contract.demo.vo.req.signet.StampListReq;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.signet.CreateStampResp;
import org.junit.Test;

/**
 * 六、签名接口
 * @author pjw
 * @date 2022/7/22/0022
 */
public class T06_StampTest extends BaseTest {

    /**
     * 6.1、创建签名
     */
    @Test
    public void createAutograph() {
        CreateAutographReq req = new CreateAutographReq();
        req.setUserId(profile.getProperty(userId));
        req.setAutographType(CreateTypeEnum.CUSTOM.getIndex());
        req.setAutographName(profile.getProperty(displayName));
        req.setAutographBase64(getFileBase64(autographFile));
        req.setColor(ColorEnum.RED.getIndex());
        req.setAlpha(AlphaEnum.A5.getIndex());
        req.setWidth(WidthEnum.W40.getIndex());
        req.setBorder(BorderEnum.HAVE.getIndex());
        req.setFontType(FontTypeEnum.WEIRUANYAHEI.getIndex());
        req.setCreateStampType(CreateSignetTypeEnum.ORDINARY.getIndex());
        req.setOperationMode(OperationModeEnum.CREATE.getIndex());
        req.setBaseTypeName(BaseTypeNameEnum.jpg.getIndex());
        req.setLimpid(false);

        BaseResp<CreateStampResp> resp = sendPost(ApiUrl.CREATE_AUTOGRAPH, JSONUtil.parseObj(req), new CreateStampResp());
        if (isOk(resp)) {
            CreateStampResp data = resp.getData();
            profile.put(autographId, data.getAutographId());
            saveProFile();
        }
    }

    /**
     * 6.2、签名列表
     */
    @Test
    public void stampList() {
        StampListReq req = new StampListReq();
        req.setId(Long.parseLong(profile.getProperty(autographId)));
        req.setUserId(profile.getProperty(userId));
        req.setName(profile.getProperty(displayName));
        req.setRequiredBase64(false);
        req.setPageNum(ParamConstant.PAGE_NUM);
        req.setPageSize(ParamConstant.PAGE_SIZE);

        sendPost(ApiUrl.STAMP_LIST, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

    /**
     * 6.3、删除签名
     */
    @Test
    public void delStamp() {
        DelStampReq req = new DelStampReq();
        req.setUserId(profile.getProperty(userId));
        req.setStampId(Long.parseLong(profile.getProperty(autographId)));

        sendPost(ApiUrl.DELETE_STAMP, JSONUtil.parseObj(req), new BaseResp<Void>());
    }

}
