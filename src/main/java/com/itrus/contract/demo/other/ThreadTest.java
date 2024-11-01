package com.itrus.contract.demo.other;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.itrus.contract.demo.base.BaseTest;
import com.itrus.contract.demo.constant.ApiUrl;
import com.itrus.contract.demo.constant.ParamConstant;
import com.itrus.contract.demo.enums.account.AccountTypeEnum;
import com.itrus.contract.demo.enums.account.CertificateTypeEnum;
import com.itrus.contract.demo.utils.data.ChineseName;
import com.itrus.contract.demo.utils.data.IdCardNum;
import com.itrus.contract.demo.utils.data.Mobile;
import com.itrus.contract.demo.utils.data.Now;
import com.itrus.contract.demo.utils.thread.CallableTask;
import com.itrus.contract.demo.vo.req.user.CreatePersonReq;
import com.itrus.contract.demo.vo.resp.BaseResp;
import com.itrus.contract.demo.vo.resp.user.PersonResp;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author pjw
 * @date 2022/12/7/0007
 */
public class ThreadTest extends BaseTest {

    @Test
    public void threadTest() throws Exception{
        //创建执行服务
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService ser = new ThreadPoolExecutor(
                10,
                30,
                100,
                TimeUnit.SECONDS,
                queue,
                new ThreadPoolExecutor.AbortPolicy()
        );
        //提交执行
        for (int i = 0; i < 10; i++) {
            CallableTask test = new CallableTask(i);
            Future<Integer> sub = ser.submit(test);
            System.out.println("线程" + i + "的结果：" + sub.get());
        }
        //关闭服务
        ser.shutdownNow();
    }

    @Test
    public void forTest() {
        for (int i = 0; i < 1; i++) {
            CreatePersonReq req = new CreatePersonReq();
            req.setDisplayName(new ChineseName().toString());
            req.setIdCardType(CertificateTypeEnum.IDENTITY_CARD.getCode());
            req.setIdCardNum(new IdCardNum().toString());
            req.setOtherCardName(ParamConstant.OTHER_CARD_NAME);
            req.setType(AccountTypeEnum.PHONE.getIndex());
            req.setPhone(new Mobile().toString());
            req.setAccount(RandomUtil.randomString(32));
            req.setEmail(new Now().toString() + ParamConstant.MAIL_SUFFIX);
            req.setPasswd(RandomUtil.randomString(16));
            req.setAuthentication(true);
            req.setUserLabel(ParamConstant.USER_LABEL);

            BaseResp<PersonResp> resp = sendPost(ApiUrl.CREATE_PERSON, JSONUtil.parseObj(req), new PersonResp());
            if (isOk(resp)) {
                PersonResp data = resp.getData();
                profile.put(userId, data.getUserId());
                profile.put(displayName, req.getDisplayName());
                profile.put(phone, req.getPhone());
                profile.put(idCardNum, req.getIdCardNum());
                saveProFile();
            }
        }
    }

}
