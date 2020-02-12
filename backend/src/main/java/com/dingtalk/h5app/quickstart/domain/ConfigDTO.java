package com.dingtalk.h5app.quickstart.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * JSAPI鉴权签名信息
 *
 * @author openapi@dingtalk
 * @date 2020/2/4
 */
public class ConfigDTO implements Serializable {
    private String jsticket;
    /**
     * 随机串，自己定义
     */
    private String nonceStr;
    /**
     * 应用的标识
     */
    private String agentId;
    /**
     * 时间戳
     */
    private Long timeStamp;
    /**
     * 企业ID
     */
    private String corpId;
    /**
     * 签名
     */
    private String signature;
    /**
     * 选填。0表示微应用的jsapi,1表示服务窗的jsapi；不填默认为0。该参数从dingtalk.js的0.8.3版本开始支持
     */
    private Integer type;

    public ConfigDTO() {
        type = 0;
    }

    public String getJsticket() {
        return jsticket;
    }

    public void setJsticket(String jsticket) {
        this.jsticket = jsticket;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
