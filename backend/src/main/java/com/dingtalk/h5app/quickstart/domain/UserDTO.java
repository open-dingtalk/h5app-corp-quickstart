package com.dingtalk.h5app.quickstart.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author openapi@dingtalk
 * @date 2020/2/4
 */
public class UserDTO implements Serializable {
    /**
     * 用户userId
     */
    private String userid;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 头像URL
     */
    private String avatar;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
