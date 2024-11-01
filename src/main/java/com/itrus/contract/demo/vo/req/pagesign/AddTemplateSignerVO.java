package com.itrus.contract.demo.vo.req.pagesign;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author meng
 * @version 1.0
 * @date 2021/5/11 0011
 * @description
 */
@Getter
@Setter
public class AddTemplateSignerVO implements Serializable {

    /**
     * 签署人类型
     */
    private Integer signerType;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 是否要做意愿认证
     */
    private Boolean isUserWishes;


    private List<Integer> userWishesWay = new ArrayList<>();

}
