package com.itrus.contract.demo.vo.view;

import com.itrus.contract.demo.enums.signet.*;

/**
 * @author pjw
 * @date 2023/8/16/0016
 */
public class PreStampCreate {

    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 签名名称(长度1-32字符)
     */
    private String autographName;


    private PreStampCreate.SelectData selectData;

    public static class SelectData {
        public CreateTypeEnum[] getCreateTypeEnumList() {
            return CreateTypeEnum.values();
        }
        public ColorEnum[] getColorEnumList() {
            return ColorEnum.values();
        }
        public AlphaEnum[] getAlphaEnumList() {
            return AlphaEnum.values();
        }
        public WidthEnum[] getWidthEnumList() {
            return WidthEnum.values();
        }
        public BorderEnum[] getBorderEnumList() {
            return BorderEnum.values();
        }
        public FontTypeEnum[] getFontTypeEnumList() {
            return FontTypeEnum.values();
        }
        public CreateSignetTypeEnum[] getCreateSignetTypeEnumList() {
            return CreateSignetTypeEnum.values();
        }
        public OperationModeEnum[] getOperationModeEnumList() {
            return OperationModeEnum.values();
        }
        public BaseTypeNameEnum[] getBaseTypeNameEnumList() {
            return BaseTypeNameEnum.values();
        }
    }


    public PreStampCreate.SelectData getSelectData() {
        return selectData;
    }

    public void setSelectData(PreStampCreate.SelectData selectData) {
        this.selectData = selectData;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAutographName() {
        return autographName;
    }

    public void setAutographName(String autographName) {
        this.autographName = autographName;
    }

}
