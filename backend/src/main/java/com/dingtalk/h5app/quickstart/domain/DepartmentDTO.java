package com.dingtalk.h5app.quickstart.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 部门查询返回结果
 *
 * @author openapi@dingtalk
 * @date 2020/2/6
 */
public class DepartmentDTO implements Serializable {
    /**
     * 部门id
     */
    private Long id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门id，根部门为1
     */
    private Long parentid;
    /**
     * 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     */
    private Boolean createDeptGroup;
    /**
     * 当群已经创建后，是否有新人加入部门会自动加入该群, true表示是，false表示不是
     */
    private Boolean autoAddUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Boolean getCreateDeptGroup() {
        return createDeptGroup;
    }

    public void setCreateDeptGroup(Boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    public Boolean getAutoAddUser() {
        return autoAddUser;
    }

    public void setAutoAddUser(Boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
