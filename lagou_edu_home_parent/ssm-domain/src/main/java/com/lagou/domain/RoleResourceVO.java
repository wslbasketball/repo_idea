package com.lagou.domain;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/9 22:03
 * @Project_Name lagou_edu_home_parent
 */
public class RoleResourceVO {

    private Integer roleId;
    private List<Integer> resourceIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}
