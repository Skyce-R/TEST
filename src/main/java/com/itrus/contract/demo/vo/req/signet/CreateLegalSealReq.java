package com.itrus.contract.demo.vo.req.signet;

import java.util.List;

/**
 * @author pjw
 * @date 2023/8/17/0017
 */
public class CreateLegalSealReq {

    private String userId;
    private String enterpriseId;
    private String name;
    private String sealBase64;
    private Integer createMode;
    private Integer shapeType;
    private Integer color;
    private String suffixName;
    private Integer frame;
    private Float width;
    private Integer font;
    private Boolean alphaDeal;
    private String operatorUserId;
    private Integer operationMode;
    private Boolean returnBase64;

    private List<Integer> intentionWays;

    private String syncUrl;

    public List<Integer> getIntentionWays() {
        return intentionWays;
    }

    public void setIntentionWays(List<Integer> intentionWays) {
        this.intentionWays = intentionWays;
    }

    public String getSyncUrl() {
        return syncUrl;
    }

    public void setSyncUrl(String syncUrl) {
        this.syncUrl = syncUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSealBase64() {
        return sealBase64;
    }

    public void setSealBase64(String sealBase64) {
        this.sealBase64 = sealBase64;
    }

    public Integer getCreateMode() {
        return createMode;
    }

    public void setCreateMode(Integer createMode) {
        this.createMode = createMode;
    }

    public Integer getShapeType() {
        return shapeType;
    }

    public void setShapeType(Integer shapeType) {
        this.shapeType = shapeType;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public Integer getFrame() {
        return frame;
    }

    public void setFrame(Integer frame) {
        this.frame = frame;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Integer getFont() {
        return font;
    }

    public void setFont(Integer font) {
        this.font = font;
    }

    public Boolean getAlphaDeal() {
        return alphaDeal;
    }

    public void setAlphaDeal(Boolean alphaDeal) {
        this.alphaDeal = alphaDeal;
    }

    public String getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(String operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    public Integer getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(Integer operationMode) {
        this.operationMode = operationMode;
    }

    public Boolean getReturnBase64() {
        return returnBase64;
    }

    public void setReturnBase64(Boolean returnBase64) {
        this.returnBase64 = returnBase64;
    }
}
